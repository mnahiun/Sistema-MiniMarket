
package datos;

import database.Conexion;
import datos.interfaces.CrudVentasInterfaces;
import entidades.Pago;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PagoDAO  implements CrudVentasInterfaces<Pago>{
     private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public PagoDAO() {
        this.CON = Conexion.getInstancia();
    }
    
    @Override
    public List<Pago> listar(String texto) {
      List<Pago> registros = new ArrayList();
        try{
           ps = CON.getConexion().prepareStatement("SELECT * FROM pago WHERE metodo_pago LIKE ?");
           ps.setString(1, "%" + texto + "%");
           rs = ps.executeQuery();
            while (rs.next()){                
                registros.add(new Pago(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getDate(5)));
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
       ps=CON.getConexion().prepareStatement("SELECT * FROM pago WHERE venta_id=?");
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
    public boolean insertar(Pago obj) {
        resp=false;
        try {
          ps=CON.getConexion().prepareStatement("INSERT INTO pago (venta_id, metodo_pago, monto, fecha) VALUES (?,?,?,?)");
          ps.setInt(1, obj.getVenta_Id());
          ps.setString(2, obj.getMetodo_pago());
          ps.setDouble(3, obj.getMonto());
          ps.setDate(4, new java.sql.Date(obj.getFecha().getTime()));
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
    public boolean actualizar(Pago obj) {
       resp=false;
        try {
          ps=CON.getConexion().prepareStatement("UPDATE pago SET venta_id=?, metodo_pago=?, monto=?, fecha=? WHERE id=?");
          ps.setInt(1, obj.getVenta_Id());
            ps.setString(2, obj.getMetodo_pago());
            ps.setDouble(3, obj.getMonto());
            ps.setDate(4, new java.sql.Date(obj.getFecha().getTime()));
            ps.setInt(5, obj.getId());
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
          ps = CON.getConexion().prepareStatement("DELETE FROM pago WHERE id=?");
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
          ps=CON.getConexion().prepareStatement("SELECT COUNT(id) FROM pago");
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
          ps=CON.getConexion().prepareStatement("SELECT * FROM pago WHERE metodo_pago=? ");
          ps.setString(1, texto);
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
