
package datos.interfaces;

import java.util.List;

public interface CrudVentasInterfaces <T>{
    
   public List<T> listar(String texto);
   public boolean buscarId(int id); 
   public boolean insertar (T obj);
   public boolean actualizar (T obj);
   public boolean eliminar(int id);
   public int total();
    public boolean existe(String texto);
   
}
