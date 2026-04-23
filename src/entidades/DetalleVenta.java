
package entidades;

/**
 *
 * Representa una línea (detalle) dentro de una venta.
 * Aplica: Encapsulamiento, Composición (Venta contiene DetalleVenta)
 */
public class DetalleVenta {
    
  private Producto producto;
  private int cantidad;
  private double subtotal;

    public DetalleVenta(Producto producto, int cantidad, double subtotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = producto.getPrecioUnitario() * cantidad;
    }
    
    //getters 

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return "Detalle Venta: " + "\n"
              + "Producto: " + producto.getNombre() + "\n"
              + "Cantidad: " + cantidad +  "\n"
              + "Subtotal: " + subtotal;
    }
    
    
  
  
}
