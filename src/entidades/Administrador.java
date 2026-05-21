
package entidades;

public class Administrador extends Empleado {

    public Administrador(int idEmpleado, String nombre, String tipoDocumento, String numDocumento) {
        super(idEmpleado, nombre, tipoDocumento, numDocumento);
    }
    
   
    
    @Override
  public String getRol() {
  return "administrador";
  
  }
  
   @Override
  public String[] getPermisosAcceso() {
  String[] permisos = {
  "GESTIONAR_PRODUCTOS",
  "GESTIONAR_EMPLEADOS",
  "VER_INVENTARIO",
  "REGISTRAR_VENTA",
  "VER_HISTORIAL_VENTAS",
  "ACTUALIZAR_INVENTARIO"
  };
  return permisos;
 }

    @Override
    public String mostrarInfo() {
     return "Id Empleado: " + getIdEmpleado() +  "\n"
            + "Nombre: " + getNombre() +  "\n"
            + "Tipo documento: " + getTipoDocumento() +  "\n" 
            + "Numero Documento: " + getNumDocumento();
    }
}
