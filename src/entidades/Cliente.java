
package entidades;


public class Cliente extends Persona {
    
    private String direccion;
    

    public Cliente(String nombre, String cedula, String direccion) {
        super(nombre, cedula);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }
  
    public Producto solicitarProducto(int id){
    
    }
    
    public boolean realizarPago(double monto){
    
    }
    
    
    @Override
    public void mostrarInfo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
