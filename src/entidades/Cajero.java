
package entidades;

public class Cajero extends Empleado{

    public Cajero(int idEmpleado, String nombre, String tipoDocumento, String numDocumento) {
        super(idEmpleado, nombre, tipoDocumento, numDocumento);
    }
    
 
  
   @Override
  public String getRol() {
    return "Cajero";
  }
  
  @Override
  public String[] getPermisosAcceso() {
     return new String[]{
  "REGISTRAR_VENTA",
  "VER_INVENTARIO"
  };
 }

    @Override
    public String mostrarInfo() {
    return "Id empleado: " + getIdEmpleado() + "\n"
         + "Tipo documento: " + getTipoDocumento() +  "\n" 
         + "Numero Documento: " + getNumDocumento();
    }
}
