
package negocio;

import datos.DetalleVentaDAO;
import datos.ProductoDAO;
import entidades.DetalleVenta;
import entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class DetalleVentaControl {
    
    private final DetalleVentaDAO DATOS;
    private final ProductoDAO DATOSPRO;
    private DetalleVenta obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;
 
    public DetalleVentaControl() {
        this.DATOS = new DetalleVentaDAO();
        this.DATOSPRO = new ProductoDAO();
        this.obj = new DetalleVenta();
        this.registrosMostrados = 0;
    }
 
    public DefaultTableModel listar(int ventaId) {
        List<DetalleVenta> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(ventaId));
 
        String[] titulos = {"Id", "Venta Id", "Producto Id", "Codigo", "Nombre Producto", "Stock", "Cantidad", "Precio", "Descuento", "Subtotal"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
 
        String[] registro = new String[10];
        this.registrosMostrados = 0;
 
        for (DetalleVenta item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getVenta_Id());
            registro[2] = Integer.toString(item.getProducto_Id());
            registro[3] = item.getCodigo_Producto();
            registro[4] = item.getNombre_Producto();
            registro[5] = Integer.toString(item.getStock_Producto());
            registro[6] = Integer.toString(item.getCantidad());
            registro[7] = Double.toString(item.getPrecio());
            registro[8] = Double.toString(item.getDescuento());
            registro[9] = Double.toString(item.getSubtotal());
            this.modeloTabla.addRow(registro);
            this.registrosMostrados=this.registrosMostrados+1;
        }
        return this.modeloTabla;
    }
 
    public String insertar(int venta_Id, int producto_Id, String codigo_Producto,
            String nombre_Producto, int stock_Producto, int cantidad,
            double precio, double descuento, double subtotal) {
 
        obj.setVenta_Id(venta_Id);
        obj.setProducto_Id(producto_Id);
        obj.setCodigo_Producto(codigo_Producto);
        obj.setNombre_Producto(nombre_Producto);
        obj.setStock_Producto(stock_Producto);
        obj.setCantidad(cantidad);
        obj.setPrecio(precio);
        obj.setDescuento(descuento);
        obj.setSubtotal(subtotal);
 
        if (DATOS.insertar(obj)) {
            return "OK";
        } else {
            return "Error en el registro";
        }
    }
 
    public String insertarLista(List<DetalleVenta> lista, int venta_Id) {
        for (DetalleVenta detalle : lista) {
            detalle.setVenta_Id(venta_Id);
            if (!DATOS.insertar(detalle)) {
                return "Error al insertar el detalle del producto: " + detalle.getNombre_Producto();
            }
        }
        return "OK";
    }
 
    public String eliminar(int id) {
        if (DATOS.eliminar(id)) {
            return "OK";
        } else {
            return "No se puede eliminar el registro";
        }
    }
 
    public String eliminarPorVenta(int ventaId) {
        if (DATOS.eliminarPorVenta(ventaId)) {
            return "OK";
        } else {
            return "No se pueden eliminar los detalles de la venta";
        }
    }
 
    public DefaultComboBoxModel seleccionarProducto() {
        DefaultComboBoxModel item = new DefaultComboBoxModel();
        List<Producto> lista = new ArrayList<>();
        lista = DATOSPRO.listar("");
 
        for (Producto pro : lista) {
            item.addElement(new Producto(pro.getId(), pro.getCategoria_Id(), pro.getCodigo(),
                    pro.getNombre(), pro.getPrecio_Venta(), pro.getStock(), pro.getDescripcion(),
                    pro.getImagen(), pro.isActivo(), pro.getProveedor_Id()));
        }
        return item;
    }
 
    public int ultimoIdVenta() {
        return DATOS.ultimoId();
    }
 
    public int total() {
        return DATOS.total();
    }
 
    public int totalMostrados() {
        return this.registrosMostrados;
    }
}
