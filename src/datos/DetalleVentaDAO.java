
package datos;

import database.Conexion;
import datos.interfaces.CrudDetalleInterface;
import entidades.DetalleVenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DetalleVentaDAO implements CrudDetalleInterface<DetalleVenta> {

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public DetalleVentaDAO() {
        this.CON = Conexion.getInstancia();
    }

    @Override
    public List<DetalleVenta> listar(int ventaId) {
        List<DetalleVenta> registros = new ArrayList<>();
        try {
            ps = CON.getConexion().prepareStatement("SELECT * FROM detalle_venta WHERE ventaId = ?");
            ps.setInt(1, ventaId);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new DetalleVenta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
        }
        return registros;
    }

    @Override
    public boolean insertar(DetalleVenta obj) {
        resp = false;
        try {
            ps = CON.getConexion().prepareStatement("INSERT INTO detalle_venta (venta_Id, producto_Id, codigo_Producto, nombre_Producto, stock_Producto, cantidad, precio, descuento, subtotal) VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, obj.getVenta_Id());
            ps.setInt(2, obj.getProducto_Id());
            ps.setString(3, obj.getCodigo_Producto());
            ps.setString(4, obj.getNombre_Producto());
            ps.setInt(5, obj.getStock_Producto());
            ps.setInt(6, obj.getCantidad());
            ps.setDouble(7, obj.getPrecio());
            ps.setDouble(8, obj.getDescuento());
            ps.setDouble(9, obj.getSubtotal());
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
        }
        return resp;
    }

    @Override
    public boolean eliminar(int id) {
        resp = false;
        try {
            ps = CON.getConexion().prepareStatement("DELETE FROM detalle_venta WHERE id = ?" );
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
        }
        return resp;
    }

    @Override
    public boolean eliminarPorVenta(int ventaId) {
        resp = false;
        try {
            ps = CON.getConexion().prepareStatement("DELETE FROM detalle_venta WHERE venta_Id = ?");
            ps.setInt(1, ventaId);
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
        }
        return resp;
    }

    @Override
    public int total() {
        int totalRegistros = 0;
        try {
            ps = CON.getConexion().prepareStatement("SELECT COUNT(id) FROM detalle_venta");
            rs = ps.executeQuery();
            if (rs.next()) {
                totalRegistros = rs.getInt(1);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
        }
        return totalRegistros;
    }

    @Override
    public int ultimoId() {
        int ultimo = 0;
        try {
            ps = CON.getConexion().prepareStatement("SELECT MAX(id) FROM venta");
            rs = ps.executeQuery();
            if (rs.next()) {
                ultimo = rs.getInt(1);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
        }
        return ultimo;
    }
}