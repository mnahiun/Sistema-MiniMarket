
package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class UsuarioDAO implements CrudSimpleInterface<Usuario>{
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public UsuarioDAO() {
        
        CON = Conexion.getInstancia();
    }

    
    @Override
    public List<Usuario> listar(String texto) {
          List<Usuario> registros = new ArrayList();
        try{
           ps = CON.getConexion().prepareStatement("SELECT * FROM usuario WHERE nombre LIKE ?");
           ps.setString(1, "%" + texto + "%");
           rs = ps.executeQuery();
            while (rs.next()){                
                registros.add(new Usuario(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getBoolean(10)));
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
          ps=null;
          rs=null;
          CON.cerrarConexion();
        }
        
        return registros;
    }

    @Override
    public boolean insertar(Usuario obj) {
         resp=false;
        try {
          ps=CON.getConexion().prepareStatement("INSERT INTO usuario (rol_id, nombre, tipo_documento, num_documento, descripcion, telefono, email, clave,activo) VALUES (?,?,?,?,?,?,?,?,1)");
          ps.setInt(1, obj.getRolId());
          ps.setString(2, obj.getNombre());
          ps.setString(3, obj.getTipoDocumento());
          ps.setString(4, obj.getNumeroDocumento());
          ps.setString(5, obj.getDescripcion());
          ps.setString(6, obj.getTelefono());
          ps.setString(7, obj.getEmail());
          ps.setString(8, obj.getClave());
           
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
    public boolean actualizar(Usuario obj) {
       resp=false;
        try {
          ps=CON.getConexion().prepareStatement("UPDATE usuario SET rolId=?, nombre=?,  tipoDocumento=?, numeroDocumento=?, descripcion=?, telefono=?, email=?, clave=? WHERE id=?");
          ps.setInt(1, obj.getRolId());
          ps.setString(2, obj.getNombre());
          ps.setString(3, obj.getTipoDocumento());
          ps.setString(4, obj.getNumeroDocumento());
          ps.setString(5, obj.getDescripcion());
          ps.setString(6, obj.getTelefono());
          ps.setString(7, obj.getEmail());
          ps.setString(8, obj.getClave());
          ps.setInt(9, obj.getId());
          
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
          ps=CON.getConexion().prepareStatement("UPDATE usuario SET activo=0 WHERE id=?");
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
          ps=CON.getConexion().prepareStatement("UPDATE usuario SET activo=1 WHERE id=?");
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
         ps = CON.getConexion().prepareStatement("DELETE FROM usuario WHERE id=?");
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
          ps=CON.getConexion().prepareStatement("SELECT COUNT(id) FROM usuario");
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
          ps=CON.getConexion().prepareStatement("SELECT nombre FROM usuario WHERE nombre=? OR email=?");
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
    
    public Usuario login(String nombre, String clave) {
    try {
        ps = CON.getConexion().prepareStatement("SELECT * FROM usuario WHERE nombre=? AND clave=? AND activo=1");
        ps.setString(1, nombre);
        ps.setString(2, clave);
        rs = ps.executeQuery();
        if (rs.next()) {
            return new Usuario(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),  rs.getBoolean(10));
        }
        ps.close();
        rs.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    } finally {
        ps = null;
        rs = null;
        CON.cerrarConexion();
    }
    return null;
}

    
}
