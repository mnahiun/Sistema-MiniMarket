
package datos.interfaces;

import java.util.List;


public interface CrudDetalleIngreInterface<T> {
    public List<T> listar(int ingresoId);
    public boolean insertar(T obj);
    public boolean eliminar(int id);
    public boolean eliminarPorIngreso(int ingresoId);
    public int total();
    public int ultimoId();
}
