
package negocio;

import datos.IngresoDAO;
import datos.ProductoDAO;
import datos.ProveedorDAO;
import datos.UsuarioDAO;
import entidades.Ingreso;
import entidades.Producto;
import entidades.Proveedor;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


public class IngresoControl {
    private final IngresoDAO DATOS;
    private final ProveedorDAO DATOSPROV;
    private final ProductoDAO DATOSPRO;
    private final UsuarioDAO DATOSUSU;
    private Ingreso obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public IngresoControl() {
        this.DATOS = new IngresoDAO();
        this.DATOSPROV = new ProveedorDAO();
        this.DATOSUSU = new UsuarioDAO();
        this.DATOSPRO = new ProductoDAO();
        this.obj = new Ingreso();
        this.registrosMostrados = 0;
        
    }
    
    public DefaultTableModel listar(String texto) {
        List<Ingreso> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));

        String[] titulos = {"Id", "Usuario Id", "Usuario", "Persona Id", "Proveedor", "Tipo Comprobante", "Serie", "Num Comprobante", "Fecha", "Impuesto", "Total", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[12];
        this.registrosMostrados = 0;

        for (Ingreso item : lista) {
            if (item.getEstado().equals("Aceptado")) {
                estado = "Aceptado";
            } else {
                estado = "No aceptado";
            }
            registro[0]  = Integer.toString(item.getId());
            registro[1]  = Integer.toString(item.getUsuarioId());
            registro[2]  = item.getUsuarioNombre();
            registro[3]  = Integer.toString(item.getPersonaId());
            registro[4]  = item.getPersonaNombre();
            registro[5]  = item.getTipo_Comprobante();
            registro[6]  = item.getSerieComprobante();
            registro[7]  = item.getNumComprobante();
            registro[8]  = item.getFecha().toString();
            registro[9]  = Double.toString(item.getImpuesto());
            registro[10] = Double.toString(item.getTotal());
            registro[11] = estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados = this.registrosMostrados + 1;
        }
        return this.modeloTabla;
    }
    
    
    public String insertar(int usuarioId, String usuarioNombre, int personaId, String personaNombre,  String tipo_Comprobante, String serieComprobante, String numComprobante,
                           java.util.Date fecha, double impuesto, double total, String estado) {
        if (DATOS.existe(numComprobante)) {
            return "El comprobante ya existe";
        } else {
            obj.setUsuarioId(usuarioId);
            obj.setUsuarioNombre(usuarioNombre);
            obj.setPersonaId(personaId);
            obj.setPersonaNombre(personaNombre);
            obj.setTipo_Comprobante(tipo_Comprobante);
            obj.setSerieComprobante(serieComprobante);
            obj.setNumComprobante(numComprobante);
            obj.setFecha(fecha);
            obj.setImpuesto(impuesto);
            obj.setTotal(total);
            obj.setEstado(estado);
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro";
            }
        }
    }
    
    public String actualizar(int id, int usuarioId, String usuarioNombre, int personaId, String personaNombre, String tipo_Comprobante, String serieComprobante, String numComprobante, String numComprobanteAnt,
                             java.util.Date fecha, double impuesto, double total, String estado) {
        if (numComprobante.equals(numComprobanteAnt)) {
            obj.setId(id);
            obj.setUsuarioId(usuarioId);
            obj.setUsuarioNombre(usuarioNombre);
            obj.setPersonaId(personaId);
            obj.setPersonaNombre(personaNombre);
            obj.setTipo_Comprobante(tipo_Comprobante);
            obj.setSerieComprobante(serieComprobante);
            obj.setNumComprobante(numComprobante);
            obj.setFecha(fecha);
            obj.setImpuesto(impuesto);
            obj.setTotal(total);
            obj.setEstado(estado);
            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualización";
            }
        } else {
            if (DATOS.existe(numComprobante)) {
                return "El comprobante ya existe";
            } else {
                obj.setId(id);
                obj.setUsuarioId(usuarioId);
                obj.setUsuarioNombre(usuarioNombre);
                obj.setPersonaId(personaId);
                obj.setPersonaNombre(personaNombre);
                obj.setTipo_Comprobante(tipo_Comprobante);
                obj.setSerieComprobante(serieComprobante);
                obj.setNumComprobante(numComprobante);
                obj.setFecha(fecha);
                obj.setImpuesto(impuesto);
                obj.setTotal(total);
                obj.setEstado(estado);
                if (DATOS.actualizar(obj)) {
                    return "OK";
                } else {
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
    
      public DefaultComboBoxModel seleccionarProveedor(){
     DefaultComboBoxModel item = new DefaultComboBoxModel();
     List<Proveedor> lista = new ArrayList<>();
     lista = DATOSPROV.listar("");
     
        for (Proveedor pro : lista) {
            item.addElement(new Proveedor(pro.getId(), pro.getTipo_Persona(), pro.getNombre(), pro.getTipoDocumento(), pro.getNumDocumento(), pro.getDireccion(), pro.getTelefono(), pro.getEmail(), pro.isActivo()));
            
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
     
      
   public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return this.registrosMostrados;
        
    }
    
    
}
