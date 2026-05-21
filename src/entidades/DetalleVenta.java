
package entidades;

public class DetalleVenta {
    
  private int id;
    private int venta_Id;
    private int producto_Id;
    private String codigo_Producto;
    private String nombre_Producto;
    private int stock_Producto;
    private int cantidad;
    private double precio;
    private double  descuento;
    private double  subtotal;

    
    public DetalleVenta() {
    }

    public DetalleVenta(int id, int venta_Id, int producto_Id, String codigo_Producto, String nombre_Producto, int stock_Producto, int cantidad, double precio, double descuento, double subtotal) {
        this.id = id;
        this.venta_Id = venta_Id;
        this.producto_Id = producto_Id;
        this.codigo_Producto = codigo_Producto;
        this.nombre_Producto = nombre_Producto;
        this.stock_Producto = stock_Producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.subtotal = subtotal;
    }

    public DetalleVenta(int producto_Id, String codigo_Producto, String nombre_Producto, int stock_Producto, int cantidad, double precio, double descuento, double subtotal) {
        this.producto_Id = producto_Id;
        this.codigo_Producto = codigo_Producto;
        this.nombre_Producto = nombre_Producto;
        this.stock_Producto = stock_Producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.subtotal = subtotal;
    }

    public DetalleVenta(int producto_Id, int cantidad, double precio, double subtotal) {
        this.producto_Id = producto_Id;
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

    public int getVenta_Id() {
        return venta_Id;
    }

    public void setVenta_Id(int venta_Id) {
        this.venta_Id = venta_Id;
    }

    public int getProducto_Id() {
        return producto_Id;
    }

    public void setProducto_Id(int producto_Id) {
        this.producto_Id = producto_Id;
    }

    public String getCodigo_Producto() {
        return codigo_Producto;
    }

    public void setCodigo_Producto(String codigo_Producto) {
        this.codigo_Producto = codigo_Producto;
    }

    public String getNombre_Producto() {
        return nombre_Producto;
    }

    public void setNombre_Producto(String nombre_Producto) {
        this.nombre_Producto = nombre_Producto;
    }

    public int getStock_Producto() {
        return stock_Producto;
    }

    public void setStock_Producto(int stock_Producto) {
        this.stock_Producto = stock_Producto;
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
        return "DetalleVenta{" + "id=" + id + ", venta_Id=" + venta_Id + ", producto_Id=" + producto_Id + ", codigo_Producto=" + codigo_Producto + ", nombre_Producto=" + nombre_Producto + ", stock_Producto=" + stock_Producto + ", cantidad=" + cantidad + ", precio=" + precio + ", descuento=" + descuento + ", subtotal=" + subtotal + '}';
    }

  
}
