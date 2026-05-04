
package entidades;

/**
 * Clase Bodeguero.
 * Aplica: Herencia (extiende Empleado), Polimorfismo
 * 
 */
public class Bodeguero  extends Empleado{
    
  public Bodeguero(int idEmpleado, String nombre, String cedula) {
    super(idEmpleado, nombre, cedula);
  }
  
   @Override
    public String getRol() {
             
             return "Bodeguero";
  }
  
  @Override
  public String[] getPermisosAcceso() {
  String[] permisos = {
     "VER_INVENTARIO",
     "ACTUALIZAR_INVENTARIO"
    };
              return permisos;
  }
  
   @Override
    public String mostrarInfo() {
    return "Id empleado: " + getIdEmpleado() + "\n"
            + "Nombre: " + getNombre() +  "\n"
            + "Cedula: " + getCedula();
    }
}
