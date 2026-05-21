
package datos;

import database.Conexion;
import datos.interfaces.CrudComprasInterface;
import datos.interfaces.CrudSimpleInterface;
import entidades.Ingreso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class IngresoDAO implements CrudComprasInterface<Ingreso>{
 private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public IngresoDAO() {
        this.CON = Conexion.getInstancia();
    }
    
    
    
    
    @Override
    public List<Ingreso> listar(String texto) {
        List<Ingreso> registros = new ArrayList();
        try{
           ps = CON.getConexion().prepareStatement("SELECT * FROM ingreso WHERE nombrePersona LIKE ?");
           ps.setString(1, "%" + texto + "%");
           rs = ps.executeQuery();
            while (rs.next()){                
                registros.add(new Ingreso(rs.getInt("id"),  rs.getInt("usuario_Id"), rs.getString("usuarioNombre"), rs.getInt("persona_Id"), rs.getString("nombrePersona"), rs.getString("tipo_comprobante"), rs.getString("serie_Comprobante"),  rs.getString("num_Comprobante"), rs.getDate("fecha"),  rs.getDouble("impuesto"),  rs.getDouble("total"), rs.getString("estado")));
                    
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
          ps=null;
          rs=null;
          
        }
        
        return registros;
    }

    @Override
    public boolean insertar(Ingreso obj) {
         resp = false;
        try {
            ps = CON.getConexion().prepareStatement("INSERT INTO ingreso (usuario_Id, usuarioNombre, persona_Id, nombrePersona, tipo_comprobante, serie_Comprobante, num_Comprobante, fecha, impuesto, total, estado) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, obj.getUsuarioId());
            ps.setString(2, obj.getUsuarioNombre());
            ps.setInt(3, obj.getPersonaId());
            ps.setString(4, obj.getPersonaNombre());
            ps.setString(5, obj.getTipo_Comprobante());
            ps.setString(6, obj.getSerieComprobante());
            ps.setString(7, obj.getNumComprobante());
            ps.setDate(8, new java.sql.Date(obj.getFecha().getTime()));
            ps.setDouble(9, obj.getImpuesto());
            ps.setDouble(10, obj.getTotal());
            ps.setString(11, obj.getEstado());
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
    public boolean actualizar(Ingreso obj) {
        resp = false;
        try {
            ps = CON.getConexion().prepareStatement("UPDATE ingreso SET usuario_Id=?, usuario_Nombre=?, persona_Id=?, nombrePersona=?, tipo_Comprobante=?, serie_Comprobante=?, num_Comprobante=?, fecha=?, impuesto=?, total=?, estado=? WHERE id=?");
            ps.setInt(1, obj.getUsuarioId());
            ps.setString(2, obj.getUsuarioNombre());
            ps.setInt(3, obj.getPersonaId());
            ps.setString(4, obj.getPersonaNombre());
            ps.setString(5, obj.getTipo_Comprobante());
            ps.setString(6, obj.getSerieComprobante());
            ps.setString(7, obj.getNumComprobante());
            ps.setDate(8, new java.sql.Date(obj.getFecha().getTime()));
            ps.setDouble(9, obj.getImpuesto());
            ps.setDouble(10, obj.getTotal());
            ps.setString(11, obj.getEstado());
            ps.setInt(12, obj.getId());
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
            ps = CON.getConexion().prepareStatement("DELETE FROM ingreso WHERE id=?");
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
    public int total() {
       int totalRegistros = 0;
        try {
            ps = CON.getConexion().prepareStatement("SELECT COUNT(id) FROM ingreso");
            rs = ps.executeQuery();
            while (rs.next()) {
                totalRegistros = rs.getInt("COUNT(id)");
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
        }
        return totalRegistros;
    }

    @Override
    public boolean existe(String texto) {
        resp = false;
        try {
            ps = CON.getConexion().prepareStatement("SELECT * FROM ingreso WHERE num_Comprobante=?");
            ps.setString(1, texto);
            rs = ps.executeQuery();
            if (rs.next()) {
                resp = true;
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
        }
        return resp;
    }
    
}
