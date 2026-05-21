
package negocio;

import datos.CategoriaDAO;
import datos.ProveedorDAO;
import entidades.Categoria;
import entidades.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ProveedorControl {
    
    private final ProveedorDAO DATOS;
    private final CategoriaDAO DATOSCAT; 
    private Proveedor obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public ProveedorControl() {
        this.DATOS = new ProveedorDAO();
        this.DATOSCAT =  new CategoriaDAO();
        this.obj = new Proveedor();
        this.registrosMostrados = 0;
        
    }
    

    public DefaultTableModel listar(String texto){
     List<Proveedor> lista = new ArrayList<>();
     lista.addAll(DATOS.listar(texto));

     String[] titulos = {"Id", "Nombre", "Tipo Documento", "Num Documento", "Direccion", "Telefono", "Email", "Estado"};
     this.modeloTabla = new DefaultTableModel(null, titulos);

     String estado;
     String[] registro =  new String[9];
     this.registrosMostrados=0;
     

     for(Proveedor item:lista){
        if(item.isActivo()){
            
        estado = "Activo";

        }else{
            estado = "Inactivo";
        }

            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getTipoDocumento();
            registro[3] = item.getNumDocumento();
            registro[4] = item.getDireccion();
            registro[5] = item.getTelefono();
            registro[6] = item.getEmail();
            registro[7] = estado;
        this.modeloTabla.addRow(registro);
        this.registrosMostrados=this.registrosMostrados+1;
    
     }
       return this.modeloTabla;
    }

     public String insertar(String nombre, String tipoDocumento, String numDocumento, String direccion, String telefono, String email){
    if(DATOS.existe(numDocumento)){
        return "El proveedor  ya existe";
    }else{
        obj.setTipo_Persona("Proveedor");
        obj.setNombre(nombre);
        obj.setTipoDocumento(tipoDocumento);
        obj.setNumDocumento(numDocumento);
        obj.setDireccion(direccion);
        obj.setTelefono(telefono);
        obj.setEmail(email);
        if(DATOS.insertar(obj)){
            return "OK";
        }else{
            return "Error en el registro";
        }
    }
    }
 
     public String actualizar(int id,  String nombre, String tipoDocumento, String numDocumento, String nombreAnt, String direccion,  String telefono, String email){
        if (nombre.equals(nombreAnt)) {
           obj.setId(id);
            obj.setNombre(nombre);
            obj.setTipoDocumento(tipoDocumento);
            obj.setNumDocumento(numDocumento);
            obj.setDireccion(direccion);
            obj.setTelefono(telefono);
            obj.setEmail(email);
            if (DATOS.actualizar(obj)) {
                return "OK";
            }else{
                return "Error en la actualización";
                
                }
        }else {
            if (DATOS.existe(nombre)) {
                return "El registro ya existe";
            }else{
                obj.setId(id);
                obj.setNombre(nombre);
                obj.setTipoDocumento(tipoDocumento);
                obj.setNumDocumento(numDocumento);
                obj.setDireccion(direccion);
                obj.setTelefono(telefono);
                obj.setEmail(email);
                if (DATOS.actualizar(obj)) {
                    return "OK";
                    
                }else{
                 return "Error en la actualización";              
                }
            }
        }
    }
     
      public String desactivar(int id){
        if (DATOS.desactivar(id)) {
            return "OK";
        }else{
            return "No se puede desactivar el registro";
        }
    }

    public String activar(int id){
         if (DATOS.activar(id)) {
            return "OK";
        }else{
            return "No se puede activar el registro";
        }

    }
    
    public String eliminar(int id){
        if(DATOS.eliminar(id)){
           return "OK";
      }else{
          return "No se puede eliminar  el registro";
    }
  }
    
     public DefaultComboBoxModel seleccionarCategoria(){
     DefaultComboBoxModel item = new DefaultComboBoxModel();
     List<Categoria> lista = new ArrayList<>();
     lista = DATOSCAT.listar("");
     
        for (Categoria cat : lista) {
            item.addElement(new Categoria(cat.getId(), cat.getNombre(), cat.getDescripcion(), cat.isActivo()));
            
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
