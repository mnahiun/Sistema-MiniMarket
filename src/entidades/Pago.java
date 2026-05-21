
package entidades;

import java.util.Date;


public class Pago {
   private int id;
   private int venta_Id;
   private String metodo_pago;
   private double monto;
   private Date fecha;

    public Pago() {
    }

    public Pago(int id, int venta_Id, String metodo_pago, double monto, Date fecha) {
        this.id = id;
        this.venta_Id = venta_Id;
        this.metodo_pago = metodo_pago;
        this.monto = monto;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVenta_Id() {
        return venta_Id;
    }

    public void setVenta_Id(int venta_Id) {
        this.venta_Id = venta_Id;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
   
   
   
}
