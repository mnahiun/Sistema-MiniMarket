
package entidades;

/**
 * Clase Producto.
 * Aplica: Encapsulamiento (atributos privados con getters/setters)
 * 
 */
public class Producto {
    
  private int idProducto;
  private String nombre;
  private String categoria;
  private double precioUnitario;
  private int stock;

    public Producto(int idProducto, String nombre, String categoria, double precioUnitario, int stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
    }
  
    
  // Getters y Setters

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
             + "Id Producto: " + idProducto + "\n"
             + "Nombre: " + nombre + "\n"
             + "Categoria: " + categoria + "\n" 
             + "Precio Unitario: " + precioUnitario +  "\n"
             + "Stock" + stock;
    }

  
}
