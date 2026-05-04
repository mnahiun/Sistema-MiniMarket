
package entidades;

/**
 * Clase Producto.
 * Aplica: Encapsulamiento (atributos privados con getters/setters)
 * 
 */
public class Producto {
    
  private int id;
  private int categoria_Id;
  private String codigo;
  private String nombre;
  private double precio_Venta;
  private int stock;
  private String descripcion;
  private String imagen;
  private boolean activo;

    
     //Constructores 
  
    public Producto() {
    }
  
    public Producto(int id, int categoria_Id, String codigo, String nombre, double precio_Venta, int stock, String descripcion, String imagen, boolean activo) {
        this.id = id;
        this.categoria_Id = categoria_Id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio_Venta = precio_Venta;
        this.stock = stock;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.activo = activo;
    }

    public int getId() {
         return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoria_Id() {
        return categoria_Id;
    }

    public void setCategoria_Id(int categoria_Id) {
        this.categoria_Id = categoria_Id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_Venta() {
        return precio_Venta;
    }

    public void setPrecio_Venta(double precio_Venta) {
        this.precio_Venta = precio_Venta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isActivo() {
        return activo;
    }

    // Getters y Setters
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
    - Descuenta del stock la cantidad vendida.
    - @return false si no hay stock suficiente.
     */
    public boolean descontarStock(int cantidad) {
        if (cantidad > stock) return false;
        this.stock -= cantidad;
        
        return true;
    }
  
  /** Agrega existencias al stock (usado por el Bodeguero). */
  public void agregarStock(int cantidad) {
  this.stock += cantidad;
  }

    @Override
    public String toString() {
        return "Producto" + "\n"
             + "Id Producto: " + id + "\n"
             + "Id Categoria: " + categoria_Id + "\n" 
             + "Codigo: " + codigo + "\n" 
             + "Nombre: " + nombre + "\n"
             + "Precio Venta: " + precio_Venta +  "\n"
             + "Stock" + stock  +  "\n"
             + "Descripción: " + descripcion + "\n"
             + "Imagen: " + imagen + "\n"
             + "Activo: " + activo;
    }

  
}
