
package entidades;

/**
 *  Clase Cajero.
* Aplica: Herencia (extiende Empleado), Polimorfismo
 */
public class Cajero extends Empleado{
    
  public Cajero(int idEmpleado, String nombre, String cedula) {
    super(idEmpleado, nombre, cedula);
  }
  
   @Override
  public String getRol() {
    return "Cajero";
  }
  
  @Override
  public String[] getPermisosAcceso() {
   String[] permisos ={
     "REGISTRAR_VENTA",
     "VER_INVENTARIO"
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
