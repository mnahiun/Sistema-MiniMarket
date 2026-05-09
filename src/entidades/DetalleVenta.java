
package entidades;

public class DetalleVenta {
    
  private int id;
    private int ventaId;
    private int productoId;
    private String productoCodigo;
    private String productoNombre;
    private int productoStock;
    private int cantidad;
    private double precio;
    private double  descuento;
    private double  subtotal;

    
    public DetalleVenta() {
    }

    public DetalleVenta(int id, int ventaId, int productoId, String productoCodigo, String productoNombre, int productoStock, int cantidad, double precio, double descuento, double subtotal) {
        this.id = id;
        this.ventaId = ventaId;
        this.productoId = productoId;
        this.productoCodigo = productoCodigo;
        this.productoNombre = productoNombre;
        this.productoStock = productoStock;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.subtotal = subtotal;
    }

    public DetalleVenta(int productoId, String productoCodigo, String productoNombre, int productoStock, int cantidad, double precio, double descuento, double subtotal) {
        this.productoId = productoId;
        this.productoCodigo = productoCodigo;
        this.productoNombre = productoNombre;
        this.productoStock = productoStock;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.subtotal = subtotal;
    }

    public DetalleVenta(int productoId, int cantidad, double precio, double subtotal) {
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getProductoCodigo() {
        return productoCodigo;
    }

    public void setProductoCodigo(String productoCodigo) {
        this.productoCodigo = productoCodigo;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public int getProductoStock() {
        return productoStock;
    }

    public void setProductoStock(int productoStock) {
        this.productoStock = productoStock;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "id=" + id + ", ventaId=" + ventaId + ", productoId=" + productoId + ", productoCodigo=" + productoCodigo + ", productoNombre=" + productoNombre + ", productoStock=" + productoStock + ", cantidad=" + cantidad + ", precio=" + precio + ", descuento=" + descuento + ", subtotal=" + subtotal + '}';
    }


    
    
  
  
}
