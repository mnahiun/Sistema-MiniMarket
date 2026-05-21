
package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO implements CrudSimpleInterface<Cliente> {
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public ClienteDAO() {
        this.CON = Conexion.getInstancia();
    }

    @Override
    public List<Cliente> listar(String texto) {
         List<Cliente> registros = new ArrayList();
        try{
           ps = CON.getConexion().prepareStatement("SELECT * FROM persona WHERE tipo_Persona='Cliente' AND  nombre LIKE ?");
           ps.setString(1, "%" + texto + "%");
           rs = ps.executeQuery();
            while (rs.next()){                
                registros.add(new Cliente(rs.getInt(1),rs.getString(2), rs.getString(3),  rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9)));
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
    public boolean insertar(Cliente obj) {
        resp=false;
        try {
          ps=CON.getConexion().prepareStatement("INSERT INTO persona (tipo_Persona, nombre, tipo_documento, num_documento, direccion, telefono, email, activo) VALUES ('Cliente',?,?,?,?,?,?,1)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getTipoDocumento());
            ps.setString(3, obj.getNumDocumento());
            ps.setString(4, obj.getDireccion());
            ps.setString(5, obj.getTelefono());
            ps.setString(6, obj.getEmail());
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
    public boolean actualizar(Cliente obj) {
        resp=false;
        try {
          ps=CON.getConexion().prepareStatement("UPDATE persona SET nombre=?, tipo_documento=?, num_documento=?, direccion=?, telefono=?, email=? WHERE id=? AND tipo_Persona='Cliente'");
          ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getTipoDocumento());
            ps.setString(3, obj.getNumDocumento());
            ps.setString(4, obj.getDireccion());
            ps.setString(5, obj.getTelefono());
            ps.setString(6, obj.getEmail());
            ps.setInt(7, obj.getId());
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
    public boolean desactivar(int id) {
       resp=false;
        try {
          ps=CON.getConexion().prepareStatement("UPDATE persona SET activo=0 WHERE id=? AND tipo_persona = 'Cliente'");
          ps.setInt(1, id);
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
    public boolean activar(int id) {
      resp=false;
        try {
          ps=CON.getConexion().prepareStatement("UPDATE persona SET activo=1 WHERE id=? AND tipo_persona = 'Cliente'");
          ps.setInt(1, id);
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
          ps = CON.getConexion().prepareStatement( "DELETE FROM persona WHERE id=? AND tipo_Persona = 'Cliente'");
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
          ps=CON.getConexion().prepareStatement("SELECT COUNT(id) FROM persona WHERE tipo_Persona='Clente'");
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
          ps=CON.getConexion().prepareStatement("SELECT id FROM persona WHERE tipo_Persona='Cliente'  AND num_documento=?  OR nombre=?");
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
