
package negocio;


import datos.RolDAO;
import negocio.RolControl;
import datos.UsuarioDAO;
import entidades.Rol;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


public class UsuarioControl {
    
    private final UsuarioDAO DATOS;
    private final RolDAO DATOSROL; 
    private Usuario obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public UsuarioControl() {
        this.DATOS = new UsuarioDAO();
        DATOSROL = new RolDAO();
        this.obj = new Usuario();
        this.registrosMostrados = 0;
    }
    
     public DefaultTableModel listar(String texto){
     List<Usuario> lista = new ArrayList<>();
     lista.addAll(DATOS.listar(texto));

     String[] titulos = {"Id", "RolId", "Nombre", "Tipo Documento", "Numero Documento", "Descripcion", "Telefono", "Email", "Estado"};
     this.modeloTabla = new DefaultTableModel(null, titulos);

     String estado;
     String[] registro =  new String[9];
     this.registrosMostrados=0;
     

     for(Usuario item:lista){
        if(item.isActivo()){
            
        estado = "Activo";

        }else{
            estado = "Inactivo";
        }

        
        registro [0] = Integer.toString(item.getId());
        registro [1] = Integer.toString(item.getRolId());
        registro [2] = item.getNombre();
        registro [3] = item.getTipoDocumento();
        registro [4] = item.getNumeroDocumento();
        registro [5] = item.getDescripcion();    
        registro [6] = item.getTelefono();  
        registro [7] = item.getEmail();
        registro [8] = estado;
        this.modeloTabla.addRow(registro);
        this.registrosMostrados=this.registrosMostrados+1;
    
     }
       return this.modeloTabla;
    }

    public String insertar(int rolId, String nombre, String tipoDocumento, String numeroDocumento, String descripcion, String telefono, String email, String clave){
    if(DATOS.existe(nombre)){
        return "El registro ya existe";
    }else{
        obj.setRolId(rolId);
        obj.setNombre(nombre);
        obj.setTipoDocumento(tipoDocumento);
        obj.setNumeroDocumento(numeroDocumento);
        obj.setDescripcion(descripcion);
        obj.setTelefono(telefono);
        obj.setEmail(email);
        obj.setClave(clave);
        if(DATOS.insertar(obj)){
            return "OK";
        }else{
            return "Error en el registro";
        }
    }
    }

    public String actualizar(int id, int rolId, String nombre, String nombreAnt, String tipoDocumento, String numeroDocumento, String descripcion, String telefono, String email, String clave){
        if (nombre.equals(nombreAnt)) {
            obj.setId(id);
            obj.setRolId(rolId);
            obj.setNombre(nombre);
            obj.setTipoDocumento(tipoDocumento);
            obj.setNumeroDocumento(numeroDocumento);
            obj.setDescripcion(descripcion);
            obj.setTelefono(telefono);
            obj.setEmail(email);
            obj.setClave(clave);
            if (DATOS.actualizar(obj)) {
                return "OK";
            }else{
                return "Error en la actualización";
                
                }
        }else {
            if (DATOS.existe(nombre)) {
                return "El usuario ya existe";
            }else{
               obj.setId(id);
               obj.setRolId(rolId);
               obj.setNombre(nombre);
               obj.setTipoDocumento(tipoDocumento);
               obj.setNumeroDocumento(numeroDocumento);
               obj.setDescripcion(descripcion);
               obj.setTelefono(telefono);
               obj.setEmail(email);
               obj.setClave(clave);
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
    
     public DefaultComboBoxModel seleccionarRol(){
     DefaultComboBoxModel item = new DefaultComboBoxModel();
     List<Rol> lista = new ArrayList<>();
     lista = DATOSROL.listar("");
     
        for (Rol rol : lista) {
            item.addElement(new Rol(rol.getId(), rol.getNombre(), rol.getDescripcion(), rol.isActivo()));
            
        }
      return item;
    
    }
    

    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return this.registrosMostrados;
        
    }

    public Usuario login(String nombre, String clave) {
        return DATOS.login(nombre, clave);
    }
    
    
    
}
