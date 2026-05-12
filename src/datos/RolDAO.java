
package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Rol;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class RolDAO implements CrudSimpleInterface<Rol>{

      private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public RolDAO() {
        this.CON = Conexion.getInstancia();
    }
    
    
    @Override
    public List<Rol> listar(String texto) {
             List<Rol> registros = new ArrayList();
        try{
           ps = CON.getConexion().prepareStatement("SELECT * FROM rol WHERE nombre LIKE ?");
           ps.setString(1, "%" + texto + "%");
           rs = ps.executeQuery();
            while (rs.next()){                
                registros.add(new Rol(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getBoolean(4)));
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
    public boolean insertar(Rol obj) {
        resp=false;
        try {
          ps=CON.getConexion().prepareStatement("INSERT INTO rol (nombre, descripcion) VALUES (?,?)");
          ps.setString(1, obj.getNombre());
          ps.setString(2, obj.getDescripcion());
           
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps=null;
            CON.cerrarConexion();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Rol obj) {
      resp=false;
        try {
          ps=CON.getConexion().prepareStatement("UPDATE rol SET  nombre=?, descripcion=?  WHERE id=?");
          ps.setString(1, obj.getNombre());
          ps.setString(2, obj.getDescripcion());
          ps.setInt(3, obj.getId());
         
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps=null;
            CON.cerrarConexion();
        }
        return resp;
    }

    @Override
    public boolean desactivar(int id) {
        resp=false;
        try {
          ps=CON.getConexion().prepareStatement("UPDATE rol SET activo=0 WHERE id=?");
          ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps=null;
            CON.cerrarConexion();
        }
        return resp;
    }

    @Override
    public boolean activar(int id) {
         resp=false;
        try {
          ps=CON.getConexion().prepareStatement("UPDATE rol SET activo=1 WHERE id=?");
          ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps=null;
            CON.cerrarConexion();
        }
        return resp;
    }
    
    @Override
    public boolean eliminar(int id) {
         resp = false;
        try {
          ps = CON.getConexion().prepareStatement( "DELETE FROM rol WHERE id=?");
          ps.setInt(1, id);
            if (ps.executeUpdate() > 0){
                resp = true;
            }   
        ps.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    } finally {
        ps = null;
        CON.cerrarConexion();
    }
    return resp;
    }

    @Override
    public int total() {
          int totalRegistros=0;
        try {
          ps=CON.getConexion().prepareStatement("SELECT COUNT(id) FROM rol");
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
            CON.cerrarConexion();
        }
        return totalRegistros;
    }

    @Override
    public boolean existe(String texto) {
       resp= false;
        try{
          ps=CON.getConexion().prepareStatement("SELECT nombre FROM rol WHERE nombre=? ");
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
          CON.cerrarConexion();
        }
         return resp;   
    }

    
    
}
