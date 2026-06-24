/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas.internas;
import dao.ClienteDAO;
import modelos.Cliente;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author m4uri
 */
public final class InternalVerClientes extends javax.swing.JInternalFrame {
    private DefaultTableModel miModelo;
    
    private void setCamposEditables(boolean estado){
    txtNomb.setEnabled(estado);
    txtApel.setEnabled(estado);
    txtCIR.setEnabled(estado);
    txtDire.setEnabled(estado);
    txtEmai.setEnabled(estado);
    txtTele.setEnabled(estado);
    }
    
    private void configurarTabla() {
        miModelo = (DefaultTableModel) modeloTabla.getModel();
    }
    
public void cargarClientes() {
        miModelo.setRowCount(0);
    ClienteDAO cDao = new ClienteDAO();
    List<Cliente> lista = cDao.listar();
    
    Object[] fila = new Object[6]; 
    for (Cliente c : lista) {
        fila[0] = c.getNombre();
        fila[1] = c.getApellido();
        fila[2] = c.getCiRuc();
        fila[3] = c.getEmail();
        fila[4] = c.getTelefono();
        fila[5] = c.getDireccion();
        miModelo.addRow(fila);
    }
    }

public void filtrarTablaClientes() {
    miModelo.setRowCount(0);
    String txtNom = txtNomb.getText(); 
    String txtApe = txtApel.getText(); 
    String txtCed = txtCIR.getText(); 
    ClienteDAO cDao = new ClienteDAO();
    List<Cliente> listaFiltrada = cDao.buscarFiltrado(txtNom, txtApe, txtCed);
    
    Object[] fila = new Object[6];
    for (Cliente c : listaFiltrada) {
        fila[0] = c.getNombre();
        fila[1] = c.getApellido();
        fila[2] = c.getCiRuc();
        fila[3] = c.getEmail();
        fila[4] = c.getTelefono();
        fila[5] = c.getDireccion();
        miModelo.addRow(fila);
    }
}

    /**
     * Creates new form InternalVerClientes
     */
    public InternalVerClientes() {
        java.awt.Color moradogris   = new java.awt.Color(0x56, 0x45, 0x58);
        java.awt.Color marronoscuro = new java.awt.Color(0x71, 0x3F, 0x25);
        java.awt.Color ambar        = new java.awt.Color(0xBB, 0x74, 0x2E);
        java.awt.Color rosa         = new java.awt.Color(0xA7, 0x79, 0x81);
        java.awt.Color fondocampo   = new java.awt.Color(55, 42, 60);
        java.awt.Color blancosuave  = new java.awt.Color(242, 238, 240);
        java.awt.Font fuenteLabel   = new java.awt.Font("Verdana", java.awt.Font.BOLD, 12);
        java.awt.Font fuenteCampo   = new java.awt.Font("Verdana", java.awt.Font.PLAIN, 13);
        java.awt.Font fuenteBoton   = new java.awt.Font("Verdana", java.awt.Font.BOLD, 12);

        setContentPane(new javax.swing.JPanel() {
            @Override protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
                g2.setPaint(new java.awt.GradientPaint(0, 0, moradogris, 0, getHeight(), marronoscuro));
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        });

        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(null);
        configurarTabla();
        cargarClientes();

        for (javax.swing.JLabel lbl : new javax.swing.JLabel[]{jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7}) {
            lbl.setFont(fuenteLabel);
            lbl.setForeground(blancosuave);
        }

        for (javax.swing.JTextField txt : new javax.swing.JTextField[]{txtNomb, txtApel, txtCIR, txtTele, txtEmai, txtDire}) {
            txt.setFont(fuenteCampo);
            txt.setBackground(fondocampo);
            txt.setForeground(blancosuave);
            txt.setCaretColor(blancosuave);
            txt.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(rosa),
                javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8)
            ));
        }

        modeloTabla.setBackground(fondocampo);
        modeloTabla.setForeground(blancosuave);
        modeloTabla.setGridColor(rosa);
        modeloTabla.getTableHeader().setBackground(marronoscuro);
        modeloTabla.getTableHeader().setForeground(blancosuave);
        modeloTabla.getTableHeader().setFont(fuenteBoton);
        jScrollPane1.getViewport().setBackground(fondocampo);

        for (javax.swing.JButton btn : new javax.swing.JButton[]{btnBuscar, jButton2, btnBorrar, btnEditar, btnOK}) {
            btn.setFont(fuenteBoton);
            btn.setBackground(ambar);
            btn.setForeground(blancosuave);
            btn.setFocusPainted(false);
            btn.setOpaque(true);
        }
        btnBorrar.setBackground(marronoscuro);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNomb = new javax.swing.JTextField();
        txtCIR = new javax.swing.JTextField();
        txtTele = new javax.swing.JTextField();
        txtEmai = new javax.swing.JTextField();
        txtDire = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtApel = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        modeloTabla = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();

        jLabel1.setText("CLIENTES");

        jLabel2.setText("Nombre");

        jLabel3.setText("Teléfono");

        jLabel4.setText("CI/RUC");

        txtEmai.addActionListener(this::txtEmaiActionPerformed);

        jLabel5.setText("Apellido");

        jLabel6.setText("Dirección");

        jLabel7.setText("Email");

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        modeloTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "CI/RUC", "Email", "Telefono", "Direccion"
            }
        ));
        modeloTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modeloTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(modeloTabla);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        jButton2.setText("Vaciar Campo");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(this::btnBorrarActionPerformed);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(this::btnEditarActionPerformed);

        btnOK.setText("OK");
        btnOK.addActionListener(this::btnOKActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCIR, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                            .addComponent(txtTele))
                                        .addGap(70, 70, 70))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNomb, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(btnOK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDire, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtApel, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                            .addComponent(txtEmai))))))
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNomb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtApel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtEmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtDire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(btnOK)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar)
                    .addComponent(jButton2)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmaiActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        filtrarTablaClientes();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txtNomb.setText("");
        txtApel.setText("");
        txtCIR.setText("");
        txtDire.setText("");
        txtEmai.setText("");
        txtTele.setText("");
        setCamposEditables(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

    int filaSeleccionada = modeloTabla.getSelectedRow();
    
    if (filaSeleccionada == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Por favor, selecciona un cliente de la tabla para eliminar.", 
            "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    int confirmar = javax.swing.JOptionPane.showConfirmDialog(this, 
        "¿Estás seguro de que deseas eliminar a este cliente?", 
        "Confirmar Eliminación", javax.swing.JOptionPane.YES_NO_OPTION);
        
    if (confirmar == javax.swing.JOptionPane.YES_OPTION) {
        
        String ciRuc = modeloTabla.getValueAt(filaSeleccionada, 2).toString();
        
        ClienteDAO cDao = new ClienteDAO();
        boolean exito = cDao.eliminar(ciRuc);
        
        if (exito) {
            javax.swing.JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente.");
            cargarClientes(); 
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "No se pudo eliminar el cliente de la base de datos.", 
                "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void modeloTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modeloTablaMouseClicked
        // TODO add your handling code here:
        
        int filaSeleccionada = modeloTabla.getSelectedRow();
    if (filaSeleccionada != -1) {
        txtNomb.setText(obtenerValorSeguro(filaSeleccionada, 0)); 
        txtApel.setText(obtenerValorSeguro(filaSeleccionada, 1)); 
        txtCIR.setText(obtenerValorSeguro(filaSeleccionada, 2));
        txtEmai.setText(obtenerValorSeguro(filaSeleccionada, 3));
        txtTele.setText(obtenerValorSeguro(filaSeleccionada, 4));
        txtDire.setText(obtenerValorSeguro(filaSeleccionada, 5));
        setCamposEditables(false);
    }
}                                        

private String obtenerValorSeguro(int fila, int columna) {
    Object valor = modeloTabla.getValueAt(fila, columna);
    return (valor != null) ? valor.toString() : "";
    }//GEN-LAST:event_modeloTablaMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if (modeloTabla.getSelectedRow() == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente de la tabla.");
        return;
    }
    setCamposEditables(true);
    txtCIR.setEnabled(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = modeloTabla.getSelectedRow();
    if (filaSeleccionada == -1) return;
    
    Cliente c = new Cliente();
    c.setNombre(txtNomb.getText().trim());
    c.setApellido(txtApel.getText().trim());
    c.setCiRuc(txtCIR.getText().trim());
    c.setEmail(txtEmai.getText().trim());
    c.setTelefono(txtTele.getText().trim());
    c.setDireccion(txtDire.getText().trim());
    
    ClienteDAO cDao = new ClienteDAO();
    if (cDao.actualizar(c)) {
        javax.swing.JOptionPane.showMessageDialog(this, "¡Cliente modificado con éxito!");
        setCamposEditables(false);
        cargarClientes();
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "No se pudo actualizar el registro.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnOKActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable modeloTabla;
    private javax.swing.JTextField txtApel;
    private javax.swing.JTextField txtCIR;
    private javax.swing.JTextField txtDire;
    private javax.swing.JTextField txtEmai;
    private javax.swing.JTextField txtNomb;
    private javax.swing.JTextField txtTele;
    // End of variables declaration//GEN-END:variables
}
