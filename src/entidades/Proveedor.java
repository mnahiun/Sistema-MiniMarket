
package entidades;


public class Proveedor extends Persona {
    
      private String direccion;

    public Proveedor(String nombre, String cedula) {
        super(nombre, cedula);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public boolean suministrarProducto(int idProducto, int cantidad) {
        
        return true;
    }

    @Override
    public void mostrarInfo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
