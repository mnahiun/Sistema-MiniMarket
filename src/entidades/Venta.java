
package entidades;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venta {

  private int id;
  private int usuario_Id;
  private String usuarioNombre;
  private int persona_Id;
  private String tipo_Documento;
  private String num_Documento;
  private String nombrePersona;
  private String tipo_Comprobante;
  private String serie_Comprobante;
  private String num_Comprobante;
  private Date fecha;
  private double impuesto;
  private double total;
  private String estado;
  private List<DetalleVenta> detalles;

    public Venta() {
    }

    public Venta(int id, int usuario_Id, String usuarioNombre, int persona_Id, String tipo_Documento, String num_Documento, String nombrePersona, String tipo_Comprobante, String serie_Comprobante, String num_Comprobante, Date fecha, double impuesto, double total, String estado, List<DetalleVenta> detalles) {
        this.id = id;
        this.usuario_Id = usuario_Id;
        this.usuarioNombre = usuarioNombre;
        this.persona_Id = persona_Id;
        this.tipo_Documento = tipo_Documento;
        this.num_Documento = num_Documento;
        this.nombrePersona = nombrePersona;
        this.tipo_Comprobante = tipo_Comprobante;
        this.serie_Comprobante = serie_Comprobante;
        this.num_Comprobante = num_Comprobante;
        this.fecha = fecha;
        this.impuesto = impuesto;
        this.total = total;
        this.estado = estado;
        this.detalles = detalles;
    }

    public Venta(int id, int usuario_Id, String usuarioNombre, int persona_Id, String tipo_Documento, String num_Documento, String nombrePersona, String tipo_Comprobante, String serie_Comprobante, String num_Comprobante, Date fecha, double impuesto, double total, String estado) {
        this.id = id;
        this.usuario_Id = usuario_Id;
        this.usuarioNombre = usuarioNombre;
        this.persona_Id = persona_Id;
        this.tipo_Documento = tipo_Documento;
        this.num_Documento = num_Documento;
        this.nombrePersona = nombrePersona;
        this.tipo_Comprobante = tipo_Comprobante;
        this.serie_Comprobante = serie_Comprobante;
        this.num_Comprobante = num_Comprobante;
        this.fecha = fecha;
        this.impuesto = impuesto;
        this.total = total;
        this.estado = estado;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario_Id() {
        return usuario_Id;
    }

    public void setUsuario_Id(int usuario_Id) {
        this.usuario_Id = usuario_Id;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public int getPersona_Id() {
        return persona_Id;
    }

    public void setPersona_Id(int persona_Id) {
        this.persona_Id = persona_Id;
    }

    public String getTipo_Documento() {
        return tipo_Documento;
    }

    public void setTipo_Documento(String tipo_Documento) {
        this.tipo_Documento = tipo_Documento;
    }

    public String getNum_Documento() {
        return num_Documento;
    }

    public void setNum_Documento(String num_Documento) {
        this.num_Documento = num_Documento;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getTipo_Comprobante() {
        return tipo_Comprobante;
    }

    public void setTipo_Comprobante(String tipo_Comprobante) {
        this.tipo_Comprobante = tipo_Comprobante;
    }

    public String getSerie_Comprobante() {
        return serie_Comprobante;
    }

    public void setSerie_Comprobante(String serie_Comprobante) {
        this.serie_Comprobante = serie_Comprobante;
    }

    public String getNum_Comprobante() {
        return num_Comprobante;
    }

    public void setNum_Comprobante(String num_Comprobante) {
        this.num_Comprobante = num_Comprobante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return serie_Comprobante + "-" + num_Comprobante + " | S/." + total;
    }

    

     
    
    
}
