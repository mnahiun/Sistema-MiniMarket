
package entidades;

/**
 * Clase abstracta Empleado.
 */
public abstract class Empleado {
    
      private int idEmpleado;
      private String nombre;
      private String cedula;

    public Empleado(int idEmpleado, String nombre, String cedula) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
      
    // Metodo abstracto que define el rol de cada empleado 
    public abstract String getRol();
    
       // Método abstracto que define el acceso del empleado (Polimorfismo)
  public abstract String[] getPermisosAcceso();
  
       public abstract String mostrarInfo();  
}
