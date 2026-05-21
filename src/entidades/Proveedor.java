
package entidades;


public class Proveedor  extends Persona{

    public Proveedor() {
    }

    
    public Proveedor(int id, String tipo_Persona, String nombre, String tipoDocumento, String numDocumento,
                                      String direccion, String telefono, String email, boolean activo) {
        
        super(id, tipo_Persona, nombre, tipoDocumento, numDocumento, direccion, telefono, email, activo);
    }

     
   @Override
    public String mostrarInfo() {
        return "Persona: " + getTipo_Persona()+ "\n"
             + "Id: " + getId() + "\n"
             + "Nombre: " + getNombre() + "\n"
             + "Tipo documento: " + getTipoDocumento() + "\n"
             + "Numero documento: " + getNumDocumento() + "\n"
             + "Dirección: " + getDireccion() + "\n"
             + "Telefono: " + getTelefono() + "\n"
             + "Email: "  + getEmail() + "\n"
             + "Activo: " + isActivo();
        
    }

    @Override
    public String toString() {
        return getNombre() + getId();
    }
       
    
  }

   
    
    

