
package datos.interfaces;

import java.util.List;

public interface CrudDetalleInterface<T> {
    public List<T> listar(int ventaId);
    public boolean insertar(T obj);
    public boolean eliminar(int id);
    public boolean eliminarPorVenta(int ventaId);
    public int total();
    public int ultimoId();
}
