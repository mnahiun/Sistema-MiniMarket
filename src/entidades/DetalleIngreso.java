
package entidades;


public class DetalleIngreso {
      
    private int id;
    private int ingresoId;
    private int productoId;
    private String productoCodigo;
    private String productoNombre;
    private int cantidad;
    private double precio;
    private double subtotal;

    public DetalleIngreso() {
    }

    public DetalleIngreso(int id, int ingresoId, int productoId, String productoCodigo, String productoNombre, int cantidad, double precio, double subtotal) {
        this.id = id;
        this.ingresoId = ingresoId;
        this.productoId = productoId;
        this.productoCodigo = productoCodigo;
        this.productoNombre = productoNombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public DetalleIngreso(int productoId, int cantidad, double precio) {
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    

    public DetalleIngreso(int productoId, String productoCodigo, String productoNombre, int cantidad, double precio, double subtotal) {
        this.productoId = productoId;
        this.productoCodigo = productoCodigo;
        this.productoNombre = productoNombre;
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

    public int getIngresoId() {
        return ingresoId;
    }

    public void setIngresoId(int ingresoId) {
        this.ingresoId = ingresoId;
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

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
}
