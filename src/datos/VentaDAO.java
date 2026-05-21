
package datos;

import database.Conexion;
import datos.interfaces.CrudVentasInterfaces;
import entidades.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class VentaDAO implements CrudVentasInterfaces<Venta> {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public VentaDAO() {
        this.CON = Conexion.getInstancia();
    }
    
    
    
    
    @Override
    public List<Venta> listar(String texto) {
      List<Venta> registros = new ArrayList();
        try{
           ps = CON.getConexion().prepareStatement("SELECT  id, persona_id,usuarioNombre, usuario_id, tipo_documento, num_documento, nombrePersona,  tipo_comprobante, serie_comprobante, num_comprobante, fecha, impuesto, total, estado  FROM venta WHERE nombrePersona LIKE ?");
           ps.setString(1, "%" + texto + "%");
           rs = ps.executeQuery();
            while (rs.next()){                
                registros.add(new Venta(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getDouble(12), rs.getDouble(13), rs.getString(14)));
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
    public boolean buscarId(int id) {
      resp=false;
      try{
       ps=CON.getConexion().prepareStatement("SELECT id FROM venta WHERE id=?");
       ps.setInt(1,id);
       rs = ps.executeQuery();
          if (rs.next()) {
              resp= true;
          }
          ps.close();
          rs.close();
          
      }catch (SQLException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
      
      }finally {
          ps=null;
      }
      return resp;
    }

    @Override
    public boolean insertar(Venta obj) {
      resp=false;
        try {
          ps=CON.getConexion().prepareStatement("INSERT INTO venta (persona_id, usuario_Id, tipo_documento, serie_comprobante, num_comprobante, fecha, impuesto, total, estado, nombrePersona, usuarioNombre, tipo_comprobante, num_documento) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
          ps.setInt(1, obj.getPersona_Id());
          ps.setInt(2, obj.getUsuario_Id());
          ps.setString(3, obj.getTipo_Documento());
          ps.setString(4, obj.getSerie_Comprobante());
          ps.setString(5, obj.getNum_Comprobante());
          ps.setDate(6, new java.sql.Date(obj.getFecha().getTime()));
          ps.setDouble(7, obj.getImpuesto());
          ps.setDouble(8, obj.getTotal());
          ps.setString(9, obj.getEstado());
          ps.setString(10, obj.getNombrePersona());
          ps.setString(11, obj.getUsuarioNombre());   
          ps.setString(12, obj.getTipo_Comprobante());
          ps.setString(13, obj.getNum_Documento());
        
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps=null;
           
        }
        return resp;
    }

    @Override
    public boolean actualizar(Venta obj) {
       resp=false;
        try {
          ps=CON.getConexion().prepareStatement("UPDATE venta SET persona_Id=?, usuario_Id=?, tipo_Documento=?, serie_Comprobante=?, num_Comprobante=?, fecha=?, impuesto=?, total=?, estado=?, nombrePersona=?, usuarioNombre=?, tipo_Comprobante=?, num_Documento=? WHERE id=?");
          ps.setInt(1, obj.getPersona_Id());
          ps.setInt(2, obj.getUsuario_Id());
          ps.setString(3, obj.getTipo_Documento());
          ps.setString(4, obj.getSerie_Comprobante());
          ps.setString(5, obj.getNum_Comprobante());
          ps.setDate(6, new java.sql.Date(obj.getFecha().getTime()));
          ps.setDouble(7, obj.getImpuesto());
          ps.setDouble(8, obj.getTotal());
          ps.setString(9, obj.getEstado());
          ps.setString(10, obj.getNombrePersona());
          ps.setString(11, obj.getUsuarioNombre());   
          ps.setString(12, obj.getTipo_Comprobante());
          ps.setString(13, obj.getNum_Documento());
          ps.setInt(14, obj.getId());          
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps=null;
            
        }
        return resp;
    }

    @Override
    public boolean eliminar(int id) {
       resp = false;
        try {
          ps = CON.getConexion().prepareStatement("DELETE FROM venta WHERE id=?");
          ps.setInt(1, id);
            if (ps.executeUpdate() > 0){
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
       int totalRegistros=0;
        try {
          ps=CON.getConexion().prepareStatement("SELECT COUNT(id) FROM venta");
          rs=ps.executeQuery();
            while (rs.next()) {                
                totalRegistros=rs.getInt("COUNT(id)");
               
            }
            ps.close();
            rs.close(); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps=null;
            
        }
        return totalRegistros;
    }

    @Override
    public boolean existe(String texto) {
         resp= false;
        try{
          ps=CON.getConexion().prepareStatement("SELECT id FROM venta WHERE serie_Comprobante=? OR num_Comprobante=?");
          ps.setString(1, texto);
          ps.setString(2, texto);
          rs=ps.executeQuery();
          if (rs.next()) {
            resp = true;
          }
           ps.close();
           rs.close();

        }catch (SQLException e ){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
          ps=null;
          rs=null;
         
        }
         return resp;   
    }
    
}
