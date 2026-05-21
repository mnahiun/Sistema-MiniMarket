
package negocio;

import datos.DetalleIngresoDAO;
import datos.ProductoDAO;
import entidades.DetalleIngreso;
import entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class DetalleIngresoControl {
   private final DetalleIngresoDAO DATOS;
   private final ProductoDAO DATOSPRO;
   private DetalleIngreso obj;
   private DefaultTableModel modeloTabla;
   public int registrosMostrados; 

    public DetalleIngresoControl() {
        this.DATOS = new DetalleIngresoDAO();
       this.DATOSPRO = new ProductoDAO();
       this.obj = new DetalleIngreso();
       this.registrosMostrados = 0;
    }
    
    public DefaultTableModel listar(int ingresoId) {
        List<DetalleIngreso> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(ingresoId));

        String[] titulos = {"Id", "Ingreso Id", "Producto Id", "Codigo", "Nombre Producto", "Cantidad", "Precio", "Subtotal"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String[] registro = new String[8];
        this.registrosMostrados = 0;

        for (DetalleIngreso item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getIngreso_Id());
            registro[2] = Integer.toString(item.getProducto_Id());
            registro[3] = item.getCodigo_Producto();
            registro[4] = item.getNombre_Producto();
            registro[5] = Integer.toString(item.getCantidad());
            registro[6] = Double.toString(item.getPrecio());
            registro[7] = Double.toString(item.getSubtotal());
            this.modeloTabla.addRow(registro);
            this.registrosMostrados=this.registrosMostrados+1;
        }
        return this.modeloTabla;
    }
    
    public String insertar(int ingreso_Id, int producto_Id, String codigo_Producto,
            String nombre_Producto, int cantidad, double precio, double subtotal) {

        obj.setIngreso_Id(ingreso_Id);
        obj.setProducto_Id(producto_Id);
        obj.setCodigo_Producto(codigo_Producto);
        obj.setNombre_Producto(nombre_Producto);
        obj.setCantidad(cantidad);
        obj.setPrecio(precio);
        obj.setSubtotal(subtotal);

        if (DATOS.insertar(obj)) {
            return "OK";
        } else {
            return "Error en el registro";
        }
    }

    public String insertarLista(List<DetalleIngreso> lista, int ingreso_Id) {
        for (DetalleIngreso detalle : lista) {
            detalle.setIngreso_Id(ingreso_Id);
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

    public String eliminarPorIngreso(int ingresoId) {
        if (DATOS.eliminarPorIngreso(ingresoId)) {
            return "OK";
        } else {
            return "No se pueden eliminar los detalles del ingreso";
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
    
     public int ultimoIdIngreso() {
        return DATOS.ultimoId();
    }

    public int total() {
        return DATOS.total();
    }

    public int totalMostrados() {
        return this.registrosMostrados;
    }
    
}
