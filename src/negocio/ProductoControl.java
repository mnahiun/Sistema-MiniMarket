
package negocio;

import datos.CategoriaDAO;
import datos.ProductoDAO;
import entidades.Categoria;
import entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


public class ProductoControl {
    
    private final ProductoDAO DATOS;
    private final CategoriaDAO DATOSCAT; 
    private Producto obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public ProductoControl() {
        this.DATOS = new ProductoDAO();
        DATOSCAT = new CategoriaDAO();
        this.obj = new Producto();
        this.registrosMostrados = 0;
        
    }
    
    
    public DefaultTableModel listar(String texto){
     List<Producto> lista = new ArrayList<>();
     lista.addAll(DATOS.listar(texto));

     String[] titulos = {"Id", "CategoriaId", "Codigo", "Nombre", "Precio Venta", "Stock", "Descripcion", "Imagen","Estado"};
     this.modeloTabla = new DefaultTableModel(null, titulos);

     String estado;
     String[] registro =  new String[9];
     this.registrosMostrados=0;
     

     for(Producto item:lista){
        if(item.isActivo()){
            
        estado = "Activo";

        }else{
            estado = "Inactivo";
        }

            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getCategoria_Id());
            registro[2] = item.getCodigo();
            registro[3] = item.getNombre();
            registro[4] = Double.toString(item.getPrecio_Venta());
            registro[5] = Integer.toString(item.getStock());
            registro[6] = item.getDescripcion();
            registro[7] = item.getImagen();
            registro[8] = estado;
        this.modeloTabla.addRow(registro);
        this.registrosMostrados=this.registrosMostrados+1;
    
     }
       return this.modeloTabla;
    }

    public String insertar(int categoria_Id, String codigo, String nombre, double precio_Venta, int stock, String descripcion, String imagen){
    if(DATOS.existe(nombre)){
        return "El registro ya existe";
    }else{
        obj.setCategoria_Id(categoria_Id);
        obj.setCodigo(codigo);
        obj.setNombre(nombre);
        obj.setPrecio_Venta(precio_Venta);
        obj.setStock(stock);
        obj.setDescripcion(descripcion);
        obj.setImagen(imagen);
        if(DATOS.insertar(obj)){
            return "OK";
        }else{
            return "Error en el registro";
        }
    }
    }

    public String actualizar(int id, int categoria_Id, String codigo, String nombre, String nombreAnt, double precio_Venta, int stock, String descripcion, String imagen){
        if (nombre.equals(nombreAnt)) {
           obj.setId(id);
            obj.setCategoria_Id(categoria_Id);
            obj.setCodigo(codigo);
            obj.setNombre(nombre);
            obj.setPrecio_Venta(precio_Venta);
            obj.setStock(stock);
            obj.setDescripcion(descripcion);
            obj.setImagen(imagen);
            if (DATOS.actualizar(obj)) {
                return "OK";
            }else{
                return "Error en la actualización";
                
                }
        }else {
            if (DATOS.existe(nombre)) {
                return "El registro ya existe";
            }else{
                obj.setId(id);
                obj.setCategoria_Id(categoria_Id);
                obj.setCodigo(codigo);
                obj.setNombre(nombre);
                obj.setPrecio_Venta(precio_Venta);
                obj.setStock(stock);
                obj.setDescripcion(descripcion);
                obj.setImagen(imagen);
                if (DATOS.actualizar(obj)) {
                    return "OK";
                    
                }else{
                 return "Error en la actualización";              
                }
            }
        }
    }

    public String desactivar(int id){
        if (DATOS.desactivar(id)) {
            return "OK";
        }else{
            return "No se puede desactivar el registro";
        }
    }

    public String activar(int id){
         if (DATOS.activar(id)) {
            return "OK";
        }else{
            return "No se puede activar el registro";
        }

    }
    public String actualizarStock(int id, int nuevoStock) {
         if (DATOS.actualizarStock(id, nuevoStock)) {
            return "OK";
        } else {
            return "Error al actualizar el stock";
        }
    }
    
    
    public DefaultComboBoxModel seleccionarCategoria(){
     DefaultComboBoxModel item = new DefaultComboBoxModel();
     List<Categoria> lista = new ArrayList<>();
     lista = DATOSCAT.listar("");
     
        for (Categoria cat : lista) {
            item.addElement(new Categoria(cat.getId(), cat.getNombre(), cat.getDescripcion(), cat.isActivo()));
            
        }
      return item;
    
    }
    
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return this.registrosMostrados;
        
    }
    
    
}
