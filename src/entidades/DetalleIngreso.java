
package entidades;


public class DetalleIngreso {
      
    private int id;
    private int ingreso_Id;
    private int producto_Id;
    private String codigo_Producto;
    private String nombre_Producto;
    private int cantidad;
    private double precio;
    private double subtotal;

    public DetalleIngreso() {
    }

    public DetalleIngreso(int id, int ingreso_Id, int producto_Id, String codigo_Producto, String nombre_Producto, int cantidad, double precio, double subtotal) {
        this.id = id;
        this.ingreso_Id = ingreso_Id;
        this.producto_Id = producto_Id;
        this.codigo_Producto = codigo_Producto;
        this.nombre_Producto = nombre_Producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public DetalleIngreso(int producto_Id, int cantidad, double precio) {
        this.producto_Id = producto_Id;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    

    public DetalleIngreso(int producto_Id, String codigo_Producto, String nombre_Producto, int cantidad, double precio, double subtotal) {
        this.producto_Id = producto_Id;
        this.codigo_Producto = codigo_Producto;
        this.nombre_Producto = nombre_Producto;
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

    public int getIngreso_Id() {
        return ingreso_Id;
    }

    public void setIngreso_Id(int ingreso_Id) {
        this.ingreso_Id = ingreso_Id;
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
