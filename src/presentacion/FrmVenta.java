
package presentacion;

import entidades.Cliente;
import entidades.DetalleVenta;
import entidades.Producto;
import entidades.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import negocio.DetalleVentaControl;
import negocio.VentaControl;


public class FrmVenta extends javax.swing.JInternalFrame {

     private final VentaControl CONTROL;
     private final DetalleVentaControl CONTROLDET;
     private DefaultTableModel modeloDetalle;
     private List<DetalleVenta> detalles;
     private String accion;
     
    public FrmVenta() {
        initComponents();
        this.CONTROL = new VentaControl();
        this.CONTROLDET = new DetalleVentaControl();
        this.detalles = new ArrayList<>();
         this.cargarUsuario(); 
         this.cargarProducto();
         this.cargarCliente();
         this.listar("");
        tabGeneral.setEnabledAt(1, false);
        this.accion="guardar";
        txtIdVenta.setVisible(false);
       txtFecha.setText(fechaVenta());
       
      String[] columnasDetalle = {"Id", "Id Venta", "Id Producto", "Codigo", "Nombre", "Stock", "Cantidad", "Precio", "Descuento", "Subtotal"};
       modeloDetalle = new DefaultTableModel(null, columnasDetalle);
      tablaDetalle.setModel(modeloDetalle);
    
    }

     private void cargarUsuario(){
        DefaultComboBoxModel item  = CONTROL.seleccionarUsuario();
          cboUsuario.setModel(item); 
    }
     
      private void cargarProducto(){
        DefaultComboBoxModel item  = CONTROL.seleccionarProducto();
          cboProducto.setModel(item); 
    }
    
        private void cargarCliente(){
        DefaultComboBoxModel item  = CONTROL.seleccionarCliente();
          cboCliente.setModel(item); 
    }
    
      private void listar(String texto){
        tablaListado.setModel(this.CONTROL.listar(texto));
        TableRowSorter orden = new TableRowSorter(tablaListado.getModel());
        tablaListado.setRowSorter(orden);
        lbTotalVentas.setText("Mostrando " + this.CONTROL.totalMostrados() + " de un total de " + this.CONTROL.total());
        this.accion="guardar";
      
    }
    
    private void limpiar () {
             txtIdVenta.setText("");
             txtIdUsuario.setText("");
             txtIdCliente.setText("");
             txtTipoDocumento.setText("");
             txtNumDocumento.setText("");
             txtTipoComprobante.setText("");
             txtNumComprobante.setText("");
             txtSerieComprobante.setText("");
             txtImpuesto.setText("0");
             txtEstado.setText("");
             txtFecha.setText(fechaVenta());
             txtTotal.setText("0.00");
             cboUsuario.setSelectedIndex(0);
             cboProducto.setSelectedIndex(0);
             cboCliente.setSelectedIndex(0);
             modeloDetalle.setRowCount(0);
             detalles.clear();
            accion = "guardar";
             
}
    
    private String fechaVenta(){
    LocalDate date = LocalDate.now();
          return date.toString();
      
    }
    
    private void calcularTotal(){
     double subtotal = 0.00;
     int items = modeloDetalle.getRowCount();
       
          for (int i = 0; i < items; i++) {
              subtotal += detalles.get(i).getSubtotal();
          }
          
          
          
        double impuesto = subtotal * 0.18;
        double total = subtotal + impuesto;
        txtImpuesto.setText(String.format("%.2f", impuesto));
        txtTotal.setText(String.format("%.2f", total));
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

        tabGeneral = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        lbTotalVentas = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        txtIdVenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTipoDocumento = new javax.swing.JTextField();
        txtNumDocumento = new javax.swing.JTextField();
        cboUsuario = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtTipoComprobante = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNumComprobante = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSerieComprobante = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cboProducto = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtImpuesto = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDetalle = new javax.swing.JTable();
        btnQuitar = new javax.swing.JButton();
        cboCliente = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Ventas");

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaListado);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        lbTotalVentas.setText("Ventas: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1069, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNuevo)
                        .addGap(75, 75, 75))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTotalVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnNuevo)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(lbTotalVentas)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        tabGeneral.addTab("Ventas", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setText("Nombre usuario: ");

        txtIdUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdUsuarioActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre Cliente: ");

        jLabel3.setText("Id usuario: ");

        jLabel4.setText("Id cliente: ");

        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo de documento:");

        jLabel6.setText("Numero de documento: ");

        cboUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Tipo de comprobante: ");

        jLabel8.setText("Numero de comprobante: ");

        jLabel9.setText("Serie comprobante: ");

        jLabel11.setText("Nombre Producto: ");

        cboProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Fecha: ");

        jLabel16.setText("Impuesto: ");

        jLabel17.setText("Total");

        jLabel18.setText("Estado: ");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablaDetalle);

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        cboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel16))
                                .addGap(32, 32, 32)
                                .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(24, 24, 24)
                                .addComponent(txtNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtSerieComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 145, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregar)
                                .addGap(44, 44, 44))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtTipoDocumento)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(txtTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(141, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btnGuardar)
                        .addGap(237, 237, 237)
                        .addComponent(btnCancelar)
                        .addGap(212, 212, 212)
                        .addComponent(btnQuitar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtNumDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(txtSerieComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar)
                            .addComponent(btnQuitar))))
                .addContainerGap())
        );

        tabGeneral.addTab("Registrar venta", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabGeneral)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabGeneral, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void txtIdUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdUsuarioActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
   if (txtIdUsuario.getText().length()==0  || txtIdUsuario.getText().length() > 20) {
         JOptionPane.showMessageDialog(this, "Debes ingresar un usuario y no debe ser mayor a 20 caracteres, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE );
         txtIdUsuario.requestFocus();
         return;
         
     }
   
   if (txtTotal.getText().length()==0  || txtTotal.getText().length() > 20) {
         JOptionPane.showMessageDialog(this, "Debes ingresar un total y no debe ser mayor a 20 caracteres, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE );
         txtTotal.requestFocus();
         return;
         
     }
   
   
    if (txtIdCliente.getText().length()==0  || txtIdCliente.getText().length() > 20) {
         JOptionPane.showMessageDialog(this, "Debes ingresar un Id cliente y no debe ser mayor a 20 caracteres, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE );
         txtIdCliente.requestFocus();
         return;
         
     }
   
    if (txtTipoDocumento.getText().length()==0  || txtTipoDocumento.getText().length() > 20) {
         JOptionPane.showMessageDialog(this, "Debes ingresar un tipo de documento y no debe ser mayor a 20 caracteres, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE );
         txtTipoDocumento.requestFocus();
         return;
         
     }
   
     if (txtNumDocumento.getText().length()==0  || txtNumDocumento.getText().length() > 20) {
         JOptionPane.showMessageDialog(this, "Debes ingresar un numero de documento y no debe ser mayor a 20 caracteres, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE );
         txtNumDocumento.requestFocus();
         return;
         
     }
     
      if (txtTipoComprobante.getText().length()==0  || txtTipoComprobante.getText().length() > 20) {
         JOptionPane.showMessageDialog(this, "Debes ingresar un tipo de comprobante y no debe ser mayor a 20 caracteres, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE );
         txtTipoComprobante.requestFocus();
         return;
         
     }
      
       if (txtNumComprobante.getText().length()==0  || txtNumComprobante.getText().length() > 20) {
         JOptionPane.showMessageDialog(this, "Debes ingresar un numero de comprobante y no debe ser mayor a 20 caracteres, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE );
         txtNumComprobante.requestFocus();
         return;
         
     }
       
        if (txtSerieComprobante.getText().length()==0  || txtSerieComprobante.getText().length() > 20) {
         JOptionPane.showMessageDialog(this, "Debes ingresar una serie de comprobantey no debe ser mayor a 20 caracteres, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE );
         txtSerieComprobante.requestFocus();
         return;
         
     }
        
        if (txtImpuesto.getText().length()==0  || txtImpuesto.getText().length() > 20) {
         JOptionPane.showMessageDialog(this, "Debes ingresar un impuesto y no debe ser mayor a 20 caracteres, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE );
         txtImpuesto.requestFocus();
         return;
         
     }
        
        if (txtEstado.getText().length()==0  || txtEstado.getText().length() > 20) {
         JOptionPane.showMessageDialog(this, "Debes ingresar un estado y no debe ser mayor a 20 caracteres, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE );
         txtEstado.requestFocus();
         return;
         
     }
   
       
        
        if (cboUsuario.getItemCount() == 0) {
         JOptionPane.showMessageDialog(this, "Debes seleccionar una usuario", "Sistema", JOptionPane.WARNING_MESSAGE );
         cboUsuario.requestFocus();
         return;
         
         }
        if (cboProducto.getItemCount() == 0) {
         JOptionPane.showMessageDialog(this, "Debes seleccionar un producto", "Sistema", JOptionPane.WARNING_MESSAGE );
         cboProducto.requestFocus();
         return;
         
         }
        
         if (cboCliente.getItemCount() == 0) {
         JOptionPane.showMessageDialog(this, "Debes seleccionar un Cliente", "Sistema", JOptionPane.WARNING_MESSAGE );
         cboCliente.requestFocus();
         return;
         
         }
   
        Usuario usu = (Usuario)cboUsuario.getSelectedItem();
        Producto pro = (Producto)cboProducto.getSelectedItem();
        
        Cliente cli = (Cliente)cboCliente.getSelectedItem(); 
         
        String resp; 
     
          
     
     resp= this.CONTROL.insertar(Integer.parseInt(txtIdCliente.getText()), Integer.parseInt(txtIdUsuario.getText()), txtTipoDocumento.getText(), txtSerieComprobante.getText(), txtNumComprobante.getText(), java.sql.Date.valueOf(txtFecha.getText()), Double.parseDouble(txtImpuesto.getText().replace(",", ".")),Double.parseDouble(txtTotal.getText().replace(",", ".")), txtEstado.getText(), cli.getNombre(), usu.getNombre(), txtTipoComprobante.getText(), txtNumDocumento.getText(), detalles);
     if (resp.equals("OK")) {
         for (int i = 0; i < tablaDetalle.getRowCount(); i++) {
        int productoId = Integer.parseInt(tablaDetalle.getValueAt(i, 0).toString());
        int cantidad   = Integer.parseInt(tablaDetalle.getValueAt(i, 5).toString());
        this.CONTROL.descontarStock(productoId, cantidad);
    }
            this.mensajeOk("Registrado correctamente ");
            this.limpiar();
            this.listar("");
        }else {
             this.mensajeError(resp);
        }
    

   
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
      tabGeneral.setEnabledAt(1, true);
      tabGeneral.setEnabledAt(0, true);
      tabGeneral.setSelectedIndex(0);
      this.limpiar();
      
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
      Producto producto =(Producto)cboProducto.getSelectedItem();
      
      if (producto == null) {
        JOptionPane.showMessageDialog(null, "Selecciona un producto.");
        return;
    }
      
      
      
      String cantidadStr = JOptionPane.showInputDialog(this, "Ingresa la cantidad:", "Cantidad", JOptionPane.QUESTION_MESSAGE);
        if (cantidadStr == null || cantidadStr.trim().isEmpty()) return;

     int cantidad;
     try{
      cantidad = Integer.parseInt(cantidadStr.trim());
      
      
     }catch(NumberFormatException e){
         JOptionPane.showMessageDialog(null, "La cantidad debe ser un numero entero");
         return;
     }
        
      if (cantidad <= 0) {
        JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0.");
        return;
    }
    if (cantidad > producto.getStock()) {
        JOptionPane.showMessageDialog(null, "La cantidad supera el stock disponible (" + producto.getStock() + ").");
        return;
    }
     
     
        double descuento = 0.0;
        double subtotal = (producto.getPrecio_Venta() * cantidad) - descuento;
        
        
        DetalleVenta detalle = new DetalleVenta();
        detalle.setProducto_Id(producto.getId());
        detalle.setCodigo_Producto(producto.getCodigo());
        detalle.setNombre_Producto(producto.getNombre());
        detalle.setStock_Producto(producto.getStock());
        detalle.setCantidad(cantidad);
        detalle.setPrecio(producto.getPrecio_Venta());
        detalle.setDescuento(descuento);
        detalle.setSubtotal(subtotal);
        detalles.add(detalle);

        modeloDetalle.addRow(new Object[]{
            detalles.size(),
            0,
            producto.getId(), producto.getCodigo(), producto.getNombre(),
            producto.getStock(), cantidad,
            String.format("%.2f", producto.getPrecio_Venta()),
            String.format("%.2f", descuento),
            String.format("%.2f", subtotal)

              
        });
     calcularTotal();   
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
      tabGeneral.setEnabledAt(1, true);
      tabGeneral.setEnabledAt(0, true);
      tabGeneral.setSelectedIndex(1);
      this.accion="guardar";
      btnGuardar.setText("Guardar");
      
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if (tablaDetalle.getSelectedRowCount() == 1) {
            modeloDetalle.removeRow(tablaDetalle.getSelectedRow());
            calcularTotal();
        }else{
          JOptionPane.showMessageDialog(this, "Debes seleccionar un registro a quitar", "Sistema", JOptionPane.WARNING_MESSAGE );     
        }
    }//GEN-LAST:event_btnQuitarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox<String> cboCliente;
    private javax.swing.JComboBox<String> cboProducto;
    private javax.swing.JComboBox<String> cboUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbTotalVentas;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaDetalle;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtNumComprobante;
    private javax.swing.JTextField txtNumDocumento;
    private javax.swing.JTextField txtSerieComprobante;
    private javax.swing.JTextField txtTipoComprobante;
    private javax.swing.JTextField txtTipoDocumento;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
