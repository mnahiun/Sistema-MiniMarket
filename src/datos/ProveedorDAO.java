
package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Producto;
import entidades.Proveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProveedorDAO implements CrudSimpleInterface<Proveedor>{

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public ProveedorDAO() {
        this.CON = Conexion.getInstancia();
    }

    @Override
    public List<Proveedor> listar(String texto) {
        List<Proveedor> registros = new ArrayList();
        try{
           ps = CON.getConexion().prepareStatement("SELECT * FROM persona WHERE tipo_Persona='Proveedor' AND  nombre LIKE ?");
           ps.setString(1, "%" + texto + "%");
           rs = ps.executeQuery();
            while (rs.next()){                
                registros.add(new Proveedor(rs.getInt(1),rs.getString(2), rs.getString(3),  rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9)));
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
    public boolean insertar(Proveedor obj) {
       resp=false;
        try {
          ps=CON.getConexion().prepareStatement("INSERT INTO persona (tipo_Persona, nombre, tipo_documento, num_documento, direccion, telefono, email, activo) VALUES ('Proveedor',?,?,?,?,?,?,1)");
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
    public boolean actualizar(Proveedor obj) {
        resp=false;
        try {
          ps=CON.getConexion().prepareStatement("UPDATE persona SET nombre=?, tipoDocumento=?, numDocumento=?, direccion=?, telefono=?, email=? WHERE id=? AND tipo_Persona='Proveedor'");
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
          ps=CON.getConexion().prepareStatement("UPDATE persona SET activo=0 WHERE id=? AND tipo_persona = 'Proveedor'");
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
          ps=CON.getConexion().prepareStatement("UPDATE persona SET activo=1 WHERE id=? AND tipo_persona = 'Proveedor'");
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
          ps = CON.getConexion().prepareStatement( "DELETE FROM persona WHERE id=? AND tipo_Persona = 'Proveedor'");
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
          ps=CON.getConexion().prepareStatement("SELECT COUNT(id) FROM persona WHERE tipo_Persona='Proveedor'");
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
          ps=CON.getConexion().prepareStatement("SELECT id FROM persona WHERE tipo_Persona='Proveedor'  AND numDocumento=?  OR nombre=?");
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
