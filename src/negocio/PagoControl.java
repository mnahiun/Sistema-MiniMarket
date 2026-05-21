
package negocio;

import datos.PagoDAO;
import datos.VentaDAO;
import entidades.Pago;
import entidades.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


public class PagoControl {
    private final PagoDAO DATOS;
    private final VentaDAO DATOSVENTA;
    private Pago obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public PagoControl() {
        this.DATOS =  new PagoDAO();
        this.DATOSVENTA =  new VentaDAO();
        this.obj = new Pago();
        this.registrosMostrados = 0;
    }
    
     public DefaultTableModel listar(String texto){
     List<Pago> lista = new ArrayList<>();
     lista.addAll(DATOS.listar(texto));

     String[] titulos = {"Id", "Venta id ", "Metodo de pago", "Monto", "fecha"};
     this.modeloTabla = new DefaultTableModel(null, titulos);
     String[] registro =  new String[5];
     this.registrosMostrados=0;
     

     for(Pago item:lista){
       
        registro [0] = Integer.toString(item.getId());
        registro [1] = Integer.toString(item.getVenta_Id());
        registro [2] = item.getMetodo_pago();
        registro [3] = Double.toString(item.getMonto());
        registro [4] = item.getFecha().toString();
        this.modeloTabla.addRow(registro);
        this.registrosMostrados=this.registrosMostrados+1;
    
     }
       return this.modeloTabla;
    }
    
     public String insertar(int venta_Id, String metodo_pago, double monto, java.util.Date fecha){
    if(DATOS.buscarId(venta_Id)){
        return "El registro ya existe";
    }else{
        obj.setVenta_Id(venta_Id);
        obj.setMetodo_pago(metodo_pago);
        obj.setMonto(monto);
        obj.setFecha(fecha);
        if(DATOS.insertar(obj)){
            return "OK";
        }else{
            return "Error en el registro";
        }
    }
    }
    
      public String actualizar(int id, int venta_Id, int venta_IdAnt, String metodo_pago, double monto, java.util.Date fecha){
        if (venta_Id == venta_IdAnt) {
            obj.setId(id);
            obj.setVenta_Id(venta_Id);
            obj.getMetodo_pago();
            obj.getMonto();
            obj.getFecha();
            if (DATOS.actualizar(obj)) {
                return "OK";
            }else{
                return "Error en la actualización";
                
                }
        }else {
            if (DATOS.buscarId(venta_Id)) {
                return "El registro ya existe";
            }else{
               obj.setId(id);
               obj.setVenta_Id(venta_Id);
               obj.getMetodo_pago();
               obj.getMonto();
               obj.getFecha();
                if (DATOS.actualizar(obj)) {
                    return "OK";
                    
                }else{
                 return "Error en la actualización";              
                }
            }
        }
    }
    
     public String eliminar(int id){
        if(DATOS.eliminar(id)){
           return "OK";
      }else{
          return "No se puede eliminar  el registro";
    }
  }
     
     public DefaultComboBoxModel seleccionarVenta() {
        DefaultComboBoxModel item = new DefaultComboBoxModel();
        List<Venta> lista = new ArrayList<>();
        lista = DATOSVENTA.listar("");

        for (Venta ven : lista) {
            item.addElement(new Venta(ven.getId(),ven.getUsuario_Id(), ven.getUsuarioNombre(), ven.getPersona_Id(), ven.getTipo_Documento(), ven.getNum_Documento(),  ven.getNombrePersona(), ven.getTipo_Comprobante(), ven.getSerie_Comprobante(), ven.getNum_Comprobante(), ven.getFecha(),
                    ven.getImpuesto(), ven.getTotal(), ven.getEstado()));
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
