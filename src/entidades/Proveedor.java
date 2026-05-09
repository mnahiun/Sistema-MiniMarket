
package entidades;


public class Proveedor  extends Persona{

    public Proveedor(int id, String tipoPersona, String nombre, String tipoDocumento, String numDocumento,
                                      String direccion, String telefono, String email, boolean activo) {
        
        super(id, tipoPersona, nombre, tipoDocumento, numDocumento, direccion, telefono, email, activo);
    }

     
   @Override
    public String mostrarInfo() {
        return "Persona: " + getTipoPersona()+ "\n"
             + "Id: " + getId() + "\n"
             + "Nombre: " + getNombre() + "\n"
             + "Tipo documento: " + getTipoDocumento() + "\n"
             + "Numero documento: " + getNumDocumento() + "\n"
             + "Dirección: " + getDireccion() + "\n"
             + "Telefono: " + getTelefono() + "\n"
             + "Email: "  + getEmail() + "\n"
             + "Activo: " + isActivo();
        
    }
       
  }

   
    
    

