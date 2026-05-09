
package entidades;

public abstract class Empleado {
    
      private int idEmpleado;
      private String nombre;
      private String tipoDocumento;
      private String numDocumento;

    public Empleado(int idEmpleado, String nombre, String tipoDocumento, String numDocumento) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
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

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    // Metodo abstracto que define el rol de cada empleado 
    public abstract String getRol();
    
       // Método abstracto que define el acceso del empleado 
  public abstract String[] getPermisosAcceso();
  
       public abstract String mostrarInfo();  
}
