
package entidades;


public class Usuario {
    private int id;
    private int rolId;
    private String rolNombre;
    private String nombre;
    private String tipoDocumento;
    private String numeroDocumento;
    private String descripcion;
    private String telefono;
    private String email;
    private String clave;
    private boolean activo;

    //Constructores
    
    public Usuario() {
    }

    public Usuario(int id, int rolId, String rolNombre, String nombre, String tipoDocumento, String numeroDocumento, String descripcion, String telefono, String email, String clave, boolean activo) {
        this.id = id;
        this.rolId = rolId;
        this.rolNombre = rolNombre;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.email = email;
        this.clave = clave;
        this.activo = activo;
    }

    // Getters y setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
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

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", rolId=" + rolId + ", nombre=" + nombre + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", descripcion=" + descripcion + ", telefono=" + telefono + ", email=" + email + ", clave=" + clave + ", activo=" + activo + '}';
    }
    
    
    
}
