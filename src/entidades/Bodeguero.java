
package entidades;

/**
 * Clase Bodeguero.
 * Aplica: Herencia (extiende Empleado), Polimorfismo
 * 
 */
public class Bodeguero  extends Empleado{

    public Bodeguero(int idEmpleado, String nombre, String tipoDocumento, String numDocumento) {
        super(idEmpleado, nombre, tipoDocumento, numDocumento);
    }
    
 
  
    @Override
  public String getRol() {
  return "Bodeguero";
  }
  
   @Override
  public String[] getPermisosAcceso() {
  String[] permisos = {"VER_INVENTARIO", "ACTUALIZAR_INVENTARIO"};
  return permisos;
  }
  
   @Override
    public String mostrarInfo() {
    return "Id empleado: " + getIdEmpleado() + "\n"
          + "Tipo documento: " + getTipoDocumento() +  "\n" 
          + "Numero Documento: " + getNumDocumento();
    }
}
