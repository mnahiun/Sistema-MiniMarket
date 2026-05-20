
package presentacion;

import entidades.Venta;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import negocio.PagoControl;


public class FrmPago extends javax.swing.JInternalFrame {
      private final PagoControl CONTROL;
       private int  venta_IdAnt;
     private String accion;
     
     
     
    public FrmPago() {
        initComponents();
        this.CONTROL = new PagoControl();
        this.accion="guardar";
        txtId.setVisible(false);
        this.cargarVenta();
         this.listar("");
          tabGeneral.setEnabledAt(1, false);
          txtFecha.setText(fechaPago());
          
    }

    
    
     private void listar(String texto){
        tablaListado.setModel(this.CONTROL.listar(texto));
     TableRowSorter orden = new TableRowSorter(tablaListado.getModel());
     tablaListado.setRowSorter(orden);
     lbTotalPagos.setText("Mostrando " + this.CONTROL.totalMostrados() + " de un total de " + this.CONTROL.total());
         this.accion="guardar";
      
    }
     
     private void cargarVenta(){
        DefaultComboBoxModel item  = CONTROL.seleccionarVenta();
          cboVenta.setModel(item); 
    }
    
      private void limpiar () {
          txtId.setText("");
          txtMetodoPago.setText("");
          txtMonto.setText("");
          txtFecha.setText("");
          cboVenta.setSelectedIndex(0);
          accion = "guardar";
             
}
          
          
      private String fechaPago(){
            LocalDate date = LocalDate.now();
          return date.toString();
      
    }

    
      private void mensajeError(String mensaje){
         JOptionPane.showMessageDialog(this, mensaje, "Sistema", JOptionPane.ERROR_MESSAGE);
    }

    
    private void mensajeOk(String mensaje){
      JOptionPane.showMessageDialog(this, mensaje, "Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        tabGeneral = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lbTotalPagos = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMetodoPago = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cboVenta = new javax.swing.JComboBox<>();

        jLabel3.setText("jLabel3");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Pagos");

        tabGeneral.setBackground(new java.awt.Color(51, 255, 0));
        tabGeneral.setForeground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaListado);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lbTotalPagos.setText("Pagos: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(32, 32, 32)
                        .addComponent(btnEditar)
                        .addGap(34, 34, 34)
                        .addComponent(btnEliminar)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbTotalPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbTotalPagos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabGeneral.addTab("Consultar", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setText("Metodo de pago: ");

        jLabel2.setText("Id venta: ");

        jLabel4.setText("Monto:");

        jLabel5.setText("fecha: ");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cboVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addGap(58, 58, 58)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMonto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMetodoPago, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboVenta, 0, 156, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(461, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cboVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        tabGeneral.addTab("Registrar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabGeneral)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabGeneral)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       if (tablaListado.getSelectedRowCount() == 1) {
            String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String venta_Id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
            String venta_IdAnt = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1)); 
            String metodo_pago = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 2));
            String monto = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 3));
            String fecha = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 4));
            
            txtId.setText(id);
            txtMetodoPago.setText(metodo_pago);
            txtMonto.setText(monto);
            txtFecha.setText(fecha);
           
            tabGeneral.setEnabledAt(0, false);
            tabGeneral.setEnabledAt(1, true);
            tabGeneral.setSelectedIndex(1);
             
            this.accion ="editar";
            btnRegistrar.setText("Editar");
             
        } else {
         this.mensajeError("Seleccione 1 pago a editar.");
        }

            
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
      tabGeneral.setEnabledAt(1, true);
      tabGeneral.setEnabledAt(0, true);
      tabGeneral.setSelectedIndex(1);
      this.accion="guardar";
      btnRegistrar.setText("Guardar");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
     if (txtMetodoPago.getText().length()==0  || txtMetodoPago.getText().length() > 20) {
         JOptionPane.showMessageDialog(this, "Debes ingresar un metodo de pago y no debe ser mayor a 20 caracteres, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE );
         txtMetodoPago.requestFocus();
         return;
         
     } 
     
     if (txtMonto.getText().length()==0  || txtMonto.getText().length() > 20) {
         JOptionPane.showMessageDialog(this, "Debes ingresar un monto y no debe ser mayor a 20 caracteres, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE );
         txtMonto.requestFocus();
         return;
         
     }
     
     if (cboVenta.getItemCount() == 0) {
         JOptionPane.showMessageDialog(this, "Debes seleccionar una venta", "Sistema", JOptionPane.WARNING_MESSAGE );
         cboVenta.requestFocus();
         return;
         
         }
     
     Venta ven = (Venta)cboVenta.getSelectedItem();
     
      String resp;
     if (this.accion.equals("editar")) {
       try{
         
         
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fecha = sdf.parse(txtFecha.getText());
        
        
     resp= this.CONTROL.actualizar(Integer.parseInt(txtId.getText()), ven.getId(),  this.venta_IdAnt, txtMetodoPago.getText(), Double.parseDouble(txtMonto.getText()), fecha);
        if (resp.equals("OK")) {
            this.mensajeOk("Actualizado correctamente ");
            this.limpiar();
            this.listar("");
            tabGeneral.setSelectedIndex(0);
            tabGeneral.setEnabledAt(1, false);
            tabGeneral.setEnabledAt(0, true);
        }else {
             this.mensajeError(resp);
        }
       }catch (ParseException e){
          this.mensajeError("Formato de fecha inválido. Use: yyyy-MM-dd");
       }
     }else {
       // Guardar 
     
     resp= this.CONTROL.insertar(ven.getId(), txtMetodoPago.getText(), Double.parseDouble(txtMonto.getText()), java.sql.Date.valueOf(txtFecha.getText()));
        if (resp.equals("OK")) {
            this.mensajeOk("Registrado correctamente ");
            this.limpiar();
            this.listar("");
        }else {
             this.mensajeError(resp);
        }
     }
     
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
      tabGeneral.setEnabledAt(1, true);
      tabGeneral.setEnabledAt(0, true);
      tabGeneral.setSelectedIndex(0);
      this.limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tablaListado.getSelectedRowCount() == 1) {
        String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
        String metodo_pago = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 3));

        int confirmar = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro que deseas eliminar el pago con metodo : " + metodo_pago + "? Esta acción no se puede deshacer",
                "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirmar == JOptionPane.YES_OPTION) {
            String resp = this.CONTROL.eliminar(Integer.parseInt(id));
            if (resp.equals("OK")) {
                this.mensajeOk("Pago eliminado exitosamente");
                this.listar("");
                this.limpiar();
            } else {
                this.mensajeError(resp);
            }
        }
    } else {
        this.mensajeError("Seleccione 1 pago a eliminar");
    }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cboVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTotalPagos;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMetodoPago;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
