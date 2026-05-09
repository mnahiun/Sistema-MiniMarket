
package datos;

import database.Conexion;
import datos.interfaces.CrudSimpleInterface;
import entidades.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**

- Data Access Object para Producto.
- Maneja todas las operaciones CRUD contra la tabla productos.
  */

public class ProductoDAO implements CrudSimpleInterface<Producto> {
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public ProductoDAO() {
        this.CON = Conexion.getInstancia();
    }
    
    
    
     @Override
    public List<Producto> listar(String texto) {
        List<Producto> registros = new ArrayList();
        try{
           ps = CON.getConexion().prepareStatement("SELECT * FROM producto WHERE nombre LIKE ?");
           ps.setString(1, "%" + texto + "%");
           rs = ps.executeQuery();
            while (rs.next()){                
                registros.add(new Producto(rs.getInt(1),rs.getInt(2), rs.getString(3),  rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getBoolean(9)));
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
    public boolean insertar(Producto obj) {
      resp=false;
        try {
          ps=CON.getConexion().prepareStatement("INSERT INTO producto (categoria_Id, codigo, nombre, precio_Venta, stock, descripcion, imagen, activo) VALUES (?,?,?,?,?,?,?,1)");
          ps.setInt(1, obj.getCategoria_Id());
            ps.setString(2, obj.getCodigo());
            ps.setString(3, obj.getNombre());
            ps.setDouble(4, obj.getPrecio_Venta());
            ps.setInt(5, obj.getStock());
            ps.setString(6, obj.getDescripcion());
            ps.setString(7, obj.getImagen());
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
    public boolean actualizar(Producto obj) {
       resp=false;
        try {
          ps=CON.getConexion().prepareStatement("UPDATE producto SET categoria_Id=?, codigo=?, nombre=?, precio_Venta=?, stock=?, descripcion=?, imagen=? WHERE id=?");
          ps.setInt(1, obj.getCategoria_Id());
            ps.setString(2, obj.getCodigo());
            ps.setString(3, obj.getNombre());
            ps.setDouble(4, obj.getPrecio_Venta());
            ps.setInt(5, obj.getStock());
            ps.setString(6, obj.getDescripcion());
            ps.setString(7, obj.getImagen());
            ps.setInt(8, obj.getId());
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
          ps=CON.getConexion().prepareStatement("UPDATE producto SET activo=0 WHERE id=?");
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
          ps=CON.getConexion().prepareStatement("UPDATE producto SET activo=1 WHERE id=?");
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
    public int total() {
        int totalRegistros=0;
        try {
          ps=CON.getConexion().prepareStatement("SELECT COUNT(id) FROM producto");
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
          ps=CON.getConexion().prepareStatement("SELECT nombre FROM producto WHERE nombre=? OR codigo=?");
          ps.setString(1, texto);
          ps.setString(2, texto);
          rs=ps.executeQuery();
         // rs.last();
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
    
     // Método  actualizar solo el stock
    public boolean actualizarStock(int id, int nuevoStock) {
        resp = false;
        try {
            ps = CON.getConexion().prepareStatement("UPDATE producto SET stock=? WHERE id=?");
            ps.setInt(1, nuevoStock);
            ps.setInt(2, id);
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
    
    
}
