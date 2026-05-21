
package datos;

import database.Conexion;
import datos.interfaces.CrudDetalleIngreInterface;
import entidades.DetalleIngreso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DetalleIngresoDAO implements CrudDetalleIngreInterface<DetalleIngreso>{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public DetalleIngresoDAO() {
        this.CON = Conexion.getInstancia();
    }

    @Override
    public List<DetalleIngreso> listar(int ingresoId) {
        List<DetalleIngreso> registros = new ArrayList<>();
        try {
            ps = CON.getConexion().prepareStatement("SELECT * FROM detalle_ingreso WHERE ingreso_Id = ?" );
            ps.setInt(1, ingresoId);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new DetalleIngreso(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6),  rs.getDouble(7), rs.getDouble(8)));
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
    public boolean insertar(DetalleIngreso obj) {
       resp = false;
        try {
            ps = CON.getConexion().prepareStatement("INSERT INTO detalle_ingreso (ingreso_Id, producto_Id, codigo_Producto, nombre_Producto, cantidad, precio, subtotal) VALUES (?,?,?,?,?,?,?)" );
            ps.setInt(1, obj.getIngreso_Id());
            ps.setInt(2, obj.getProducto_Id());
            ps.setString(3, obj.getCodigo_Producto());
            ps.setString(4, obj.getNombre_Producto());
            ps.setInt(5, obj.getCantidad());
            ps.setDouble(6, obj.getPrecio());
            ps.setDouble(7, obj.getSubtotal());
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
            ps = CON.getConexion().prepareStatement("DELETE FROM detalle_ingreso WHERE id = ?");
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
    public boolean eliminarPorIngreso(int ingresoId) {
        resp = false;
        try {
            ps = CON.getConexion().prepareStatement("DELETE FROM detalle_ingreso WHERE ingreso_Id = ?");
            ps.setInt(1, ingresoId);
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
            ps = CON.getConexion().prepareStatement("SELECT COUNT(id) FROM detalle_ingreso");
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
            ps = CON.getConexion().prepareStatement("SELECT MAX(id) FROM ingreso");
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
