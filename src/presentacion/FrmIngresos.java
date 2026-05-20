
package presentacion;

import entidades.DetalleIngreso;
import entidades.Producto;
import entidades.Proveedor;
import entidades.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import negocio.DetalleIngresoControl;
import negocio.IngresoControl;

public class FrmIngresos extends javax.swing.JInternalFrame {
     private final IngresoControl CONTROL;
     private final DetalleIngresoControl CONTROLDETI;
     private DefaultTableModel modeloDetalle;
     private List<DetalleIngreso> detalles;
     private String accion;
     
    public FrmIngresos() {
        initComponents();
        this.CONTROL = new IngresoControl();
        this.CONTROLDETI = new DetalleIngresoControl(); 
        this.detalles = new ArrayList<>();
         this.cargarUsuario(); 
         this.cargarProducto();
         this.cargarProveedor();
        this.listar("");
        tabGeneral.setEnabledAt(1, false);
         txtId.setVisible(false);
            txtFecha.setText(fechaCompra());
         this.accion="guardar";
         
         
         
         String[] columnasDetalle = {"Id", "Id Ingreso", "Id Producto", "Codigo", "Nombre Producto ", "Cantidad", "Precio",  "Subtotal"};
       modeloDetalle = new DefaultTableModel(null, columnasDetalle);
      tablaDetalle.setModel(modeloDetalle);
         
    }
    
     private void cargarUsuario(){
        DefaultComboBoxModel item  = CONTROL.seleccionarUsuario();
          cboUsuario.setModel(item); 
    }
     
    private void cargarProveedor(){
        DefaultComboBoxModel item = CONTROL.seleccionarProveedor();
        cboProveedor.setModel(item);
    }
    
    private void cargarProducto(){
        DefaultComboBoxModel item  = CONTROL.seleccionarProducto();
          cboProducto.setModel(item); 
    }
     

    private void listar(String texto){
        tablaListado.setModel(this.CONTROL.listar(texto));
     TableRowSorter orden = new TableRowSorter(tablaListado.getModel());
     tablaListado.setRowSorter(orden);
      lbTotalIngresos.setText("Mostrando " + this.CONTROL.totalMostrados() + " de un total de " + this.CONTROL.total());
         this.accion="guardar";
      
    }
     private void limpiar () {
             txtId.setText("");
             txtIdUsuario.setText("");
             txtIdProveedor.setText("");
            txtTipoComprobante.setText(""); 
            txtNumComprobante.setText("");
             txtSerieComprobante.setText("");
             txtEstado.setText("");
             txtImpuesto.setText("0");
             txtTotal.setText("0.00");
             txtFecha.setText(fechaCompra());
             cboUsuario.setSelectedIndex(0);
             cboProveedor.setSelectedIndex(0);
             cboProducto.setSelectedIndex(0);
             modeloDetalle.setRowCount(0);
             detalles.clear();
            accion = "guardar";
             
}
     private String fechaCompra(){
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnRegistar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lbTotalIngresos = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cboUsuario = new javax.swing.JComboBox<>();
        cboProveedor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIdProveedor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTipoComprobante = new javax.swing.JTextField();
        txtNumComprobante = new javax.swing.JTextField();
        txtSerieComprobante = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtImpuesto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalle = new javax.swing.JTable();
        btnQuitar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cboProducto = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Ingresos");

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaListado);

        jLabel1.setText("Nombre: ");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnRegistar.setText("Registrar");
        btnRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarActionPerformed(evt);
            }
        });

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

        lbTotalIngresos.setText("Ingresos: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnBuscar)
                        .addGap(52, 52, 52)
                        .addComponent(btnRegistar)
                        .addGap(31, 31, 31)
                        .addComponent(btnEditar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(btnEliminar)
                        .addGap(131, 131, 131)
                        .addComponent(lbTotalIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(243, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar)
                        .addComponent(btnRegistar)
                        .addComponent(btnEditar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(lbTotalIngresos))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        tabGeneral.addTab("Listado", jPanel1);

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

        cboUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboUsuarioActionPerformed(evt);
            }
        });

        cboProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Nombre usuario: ");

        jLabel3.setText("Nombre Proveedor:");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel4.setText("Id usuario:");

        jLabel5.setText("Id proveedor: ");

        jLabel6.setText("Tipo de comprobante: ");

        jLabel7.setText("Numero de comprobante: ");

        jLabel8.setText("Serie Comprobante:  ");

        jLabel9.setText("Fecha: ");

        jLabel10.setText("Impuesto: ");

        jLabel11.setText("Estado: ");

        jLabel12.setText("Total: ");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaDetalle);

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        jLabel13.setText("Nombre Producto: ");

        cboProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cboProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSerieComprobante)
                                            .addComponent(txtImpuesto)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(116, 116, 116)
                                        .addComponent(cboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                            .addComponent(txtFecha))
                                        .addGap(45, 45, 45)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAgregar))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtIdUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                            .addComponent(txtIdProveedor))
                                        .addGap(45, 45, 45)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(42, 42, 42)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 103, Short.MAX_VALUE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(btnGuardar)
                                .addGap(212, 212, 212)
                                .addComponent(btnCancelar)
                                .addGap(233, 233, 233)
                                .addComponent(btnQuitar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtSerieComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregar)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnQuitar))
                .addGap(105, 105, 105))
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

    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed
      tabGeneral.setEnabledAt(1, true);
      tabGeneral.setEnabledAt(0, true);
      tabGeneral.setSelectedIndex(1);
      this.accion="guardar";
      btnGuardar.setText("Guardar");
    }//GEN-LAST:event_btnRegistarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.listar(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void cboUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboUsuarioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
      tabGeneral.setEnabledAt(1, true);
      tabGeneral.setEnabledAt(0, true);
      tabGeneral.setSelectedIndex(0);
      this.limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
      if (tablaListado.getSelectedRowCount() == 1) {
        String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
        String nombre = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 3));

        int confirmar = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro que deseas eliminar el producto: " + nombre + "? Esta acción no se puede deshacer",
                "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirmar == JOptionPane.YES_OPTION) {
            String resp = this.CONTROL.eliminar(Integer.parseInt(id));
            if (resp.equals("OK")) {
                this.mensajeOk("Producto eliminado exitosamente");
                this.listar("");
                this.limpiar();
            } else {
                this.mensajeError(resp);
            }
        }
    } else {
        this.mensajeError("Seleccione 1 producto a eliminar");
    }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

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
        double subtotal = (producto.getPrecio_Venta() * cantidad);
        
        
        DetalleIngreso detalle = new DetalleIngreso();
        detalle.setProducto_Id(producto.getId());
        detalle.setCodigo_Producto(producto.getCodigo());
        detalle.setNombre_Producto(producto.getNombre());
        detalle.setCantidad(cantidad);
        detalle.setPrecio(producto.getPrecio_Venta());
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
   
   
    if (txtIdProveedor.getText().length()==0  || txtIdProveedor.getText().length() > 20) {
         JOptionPane.showMessageDialog(this, "Debes ingresar un Id proveedor y no debe ser mayor a 20 caracteres, es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE );
         txtIdProveedor.requestFocus();
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
        
         if (cboProveedor.getItemCount() == 0) {
         JOptionPane.showMessageDialog(this, "Debes seleccionar un Cliente", "Sistema", JOptionPane.WARNING_MESSAGE );
         cboProveedor.requestFocus();
         return;
         
         }
   
        Usuario usu = (Usuario)cboUsuario.getSelectedItem();
        Producto pro = (Producto)cboProducto.getSelectedItem();
        Proveedor prov = (Proveedor)cboProveedor.getSelectedItem(); 
         
        String resp; 
     
          
     
     resp= this.CONTROL.insertar(Integer.parseInt(txtIdUsuario.getText()), usu.getNombre(), Integer.parseInt(txtIdProveedor.getText()), prov.getNombre(), txtTipoComprobante.getText(), txtSerieComprobante.getText(), txtNumComprobante.getText(), java.sql.Date.valueOf(txtFecha.getText()), Double.parseDouble(txtImpuesto.getText().replace(",", ".")),Double.parseDouble(txtTotal.getText().replace(",", ".")), txtEstado.getText());
     if (resp.equals("OK")) {
            this.mensajeOk("Registrado correctamente ");
            this.limpiar();
            this.listar("");
        }else {
             this.mensajeError(resp);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRegistar;
    private javax.swing.JComboBox<String> cboProducto;
    private javax.swing.JComboBox<String> cboProveedor;
    private javax.swing.JComboBox<String> cboUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbTotalIngresos;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaDetalle;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtNumComprobante;
    private javax.swing.JTextField txtSerieComprobante;
    private javax.swing.JTextField txtTipoComprobante;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
