
package negocio;

import datos.ClienteDAO;
import datos.ProductoDAO;
import datos.UsuarioDAO;
import datos.VentaDAO;
import entidades.Cliente;
import entidades.DetalleVenta;
import entidades.Producto;
import entidades.Usuario;
import entidades.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class VentaControl {
    private final VentaDAO DATOS;
    private final ClienteDAO DATOSCLI; 
    private final UsuarioDAO DATOSUSU;
    private final ProductoDAO DATOSPRO;
    private Venta obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public VentaControl() {
        this.DATOS = new VentaDAO();
        this.DATOSCLI = new ClienteDAO();
        this.DATOSUSU = new UsuarioDAO();
        this.DATOSPRO = new ProductoDAO();
        this.obj = new Venta();
        this.registrosMostrados = 0;
    }
 
        public DefaultTableModel listar(String texto){
     List<Venta> lista = new ArrayList<>();
     lista.addAll(DATOS.listar(texto));

     String[] titulos = {"Id", "Persona Id", "Nombre persona", "Usuario Id ", "Nombre usuario", "Tipo documento", "Numero documento", "Tipo comprobante", "Serie comprobante", "Numero comprobante", "Fecha", "Impuesto","Total", "Estado"};
     this.modeloTabla = new DefaultTableModel(null, titulos);

     String estado;
     String[] registro =  new String[14];
     this.registrosMostrados=0;
     

     for(Venta item:lista){
        if(item.getEstado().equals("Aceptado")){
            
            estado = "Aceptado";
            
        }else{
            estado = "No aceptado";
        }

            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getPersona_Id());
            registro[2] = item.getNombrePersona();
            registro[3] = Integer.toString(item.getUsuario_Id());
            registro[4] = item.getUsuarioNombre();
            registro[5] = item.getTipo_Documento();
            registro[6] = item.getNum_Documento();
            registro[7] = item.getTipo_Comprobante();
            registro[8] = item.getSerie_Comprobante();
            registro[9] = item.getNum_Comprobante();
            registro[10] = item.getFecha().toString();
            registro[11] = Double.toString(item.getImpuesto());
            registro[12] = Double.toString(item.getTotal());
            registro[13] = item.getEstado();
        this.modeloTabla.addRow(registro);
        this.registrosMostrados=this.registrosMostrados+1;
    
     }
       return this.modeloTabla;
    }
   
       public String insertar(int persona_Id, int usuario_Id, String tipo_Documento,String serie_Comprobante, String num_Comprobante, java.util.Date fecha,
                              double impuesto, double total, String estado, String nombrePersona,  String usuarioNombre, String tipo_Comprobante, String num_Documento, List<DetalleVenta> detalles){
    if(DATOS.existe(num_Comprobante)){
        return "El registro ya existe";
    }else{
        obj.setPersona_Id(persona_Id);
        obj.setUsuario_Id(usuario_Id);
        obj.setTipo_Documento(tipo_Documento);
        obj.setSerie_Comprobante(serie_Comprobante);
        obj.setNum_Comprobante(num_Comprobante);
        obj.setFecha(fecha);
        obj.setImpuesto(impuesto);
        obj.setTotal(total);
        obj.setEstado(estado);
        obj.setNombrePersona(nombrePersona);
        obj.setUsuarioNombre(usuarioNombre);
        obj.setTipo_Comprobante(tipo_Comprobante);
        obj.setNum_Documento(num_Documento);
        if(DATOS.insertar(obj)){   
           for (DetalleVenta detalle : detalles) {
                // Primero obtenemos el stock actual
                Producto pro = DATOSPRO.buscarPorId(detalle.getProducto_Id());
                if (pro != null) {
                    int stockActual = pro.getStock();
                    int nuevoStock  = stockActual - detalle.getCantidad();
                    DATOSPRO.actualizarStock(detalle.getProducto_Id(), nuevoStock);
                }
            }
            
            
            return "OK";
        }else{
            return "Error en el registro";
        }
    }
    }
      
     public String actualizar(int id, int persona_Id, int usuario_Id, String tipo_Documento,String serie_Comprobante, String num_Comprobante, String num_ComprobanteAnt,
            java.util.Date fecha, double impuesto, double total, String estado, String nombrePersona, String usuarioNombre, String tipo_Comprobante, String num_Documento){
        if (num_Comprobante.equals(num_ComprobanteAnt)) {
            obj.setId(id);
            obj.setPersona_Id(persona_Id);
            obj.setUsuario_Id(usuario_Id);
            obj.setTipo_Documento(tipo_Documento);
            obj.setSerie_Comprobante(serie_Comprobante);
            obj.setNum_Comprobante(num_Comprobante);
            obj.setFecha(fecha);
            obj.setImpuesto(impuesto);
            obj.setTotal(total);
            obj.setEstado(estado);
            obj.setNombrePersona(nombrePersona);
            obj.setUsuarioNombre(usuarioNombre);
            obj.setTipo_Comprobante(tipo_Comprobante);
            obj.setNum_Documento(num_Documento);
            if (DATOS.actualizar(obj)) {
                return "OK";
            }else{
                return "Error en la actualización";
                
                }
        }else {
            if (DATOS.existe(num_Comprobante)) {
                return "El registro ya existe";
            }else{
                obj.setId(id);
                obj.setPersona_Id(persona_Id);
                obj.setUsuario_Id(usuario_Id);
                obj.setTipo_Documento(tipo_Documento);
                obj.setSerie_Comprobante(serie_Comprobante);
                obj.setNum_Comprobante(num_Comprobante);
                obj.setFecha(fecha);
                obj.setImpuesto(impuesto);
                obj.setTotal(total);
                obj.setEstado(estado);
                obj.setNombrePersona(nombrePersona);
                obj.setUsuarioNombre(usuarioNombre);
                obj.setTipo_Comprobante(tipo_Comprobante);
                obj.setNum_Documento(num_Documento);
                if (DATOS.actualizar(obj)) {
                    return "OK";
                    
                }else{
                 return "Error en la actualización";              
                }
            }
        }
    }
     public String eliminar(int id){
        if(DATOS.eliminar(id)){
           return "OK";
      }else{
          return "No se puede eliminar  el registro";
    }
  }   
    public DefaultComboBoxModel seleccionarCliente() {
        DefaultComboBoxModel item = new DefaultComboBoxModel();
        List<Cliente> lista = new ArrayList<>();
        lista = DATOSCLI.listar("");
 
        for (Cliente cli : lista) {
            item.addElement(new Cliente(cli.getId(), cli.getTipo_Persona(), cli.getNombre(), cli.getTipoDocumento(), cli.getNumDocumento(), cli.getDireccion(),
                              cli.getTelefono(), cli.getEmail(), cli.isActivo()));
        }
        return item;
    }
 
    public DefaultComboBoxModel seleccionarUsuario() {
        DefaultComboBoxModel item = new DefaultComboBoxModel();
        List<Usuario> lista = new ArrayList<>();
        lista = DATOSUSU.listar("");
 
        for (Usuario usu : lista) {
            item.addElement(new Usuario(usu.getId(), usu.getRolId(), usu.getNombre(), usu.getTipoDocumento(), usu.getNumeroDocumento(), usu.getDescripcion(), 
                              usu.getTelefono(), usu.getEmail(), usu.getClave(),
                   usu.isActivo()));
        }
        return item;
   }    
    
     public DefaultComboBoxModel seleccionarProducto() {
        DefaultComboBoxModel item = new DefaultComboBoxModel();
        List<Producto> lista = new ArrayList<>();
        lista = DATOSPRO.listar("");
 
        for (Producto pro : lista) {
            item.addElement(new Producto(pro.getId(), pro.getCategoria_Id(), pro.getCodigo(), pro.getNombre(), pro.getPrecio_Venta(), pro.getStock(), pro.getDescripcion(),
                            pro.getImagen(), pro.isActivo(), pro.getProveedor_Id()));
        }
        return item;
   }    
     
       
     
     public void descontarStock(int productoId, int cantidad) {
    Producto pro = DATOSPRO.buscarPorId(productoId);
    if (pro != null) {
        int nuevoStock = pro.getStock() - cantidad;
        DATOSPRO.actualizarStock(productoId, nuevoStock);
    }
}
     
     public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return this.registrosMostrados;
        
    }                
}
