
package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Clase Venta.
 * Aplica: Encapsulamiento, Composición (contiene lista de DetalleVenta)
 */
public class Venta {

  private int idVenta;
  private LocalDateTime fecha;
  private Empleado cajero;
  private List<DetalleVenta> detalles;
  private double total;

    public Venta(int idVenta, LocalDateTime fecha, Empleado cajero, List<DetalleVenta> detalles, double total) {
        this.idVenta = idVenta;
        this.fecha = LocalDateTime.now();
        this.cajero = cajero;
        this.detalles = new ArrayList<>();
        this.total = 0.0;
    }
  
      // Getters

    public int getIdVenta() {
        return idVenta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Empleado getCajero() {
        return cajero;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public double getTotal() {
        return total;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
    
    
    
     /** Agrega un detalle y acumula el total. */
  public void agregarDetalle(DetalleVenta detalle) {
  detalles.add(detalle);
  total += detalle.getSubtotal();
  }
  
  @Override
  public String toString() {
  DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
  StringBuilder sb = new StringBuilder();
  sb.append("=== VENTA #").append(idVenta)
  .append(" | ").append(fecha.format(fmt))
  .append(" | Cajero: ").append(cajero.getNombre())
  .append(" ===\n");
  for (DetalleVenta d : detalles) {
  sb.append(d.toString()).append("\n");
  }
  sb.append(String.format("  TOTAL: $%.2f", total));
  return sb.toString();
  }
    
  
}
