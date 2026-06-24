package vistas;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class Menu extends javax.swing.JFrame {

    public Menu(String usuario) {
        initComponents();
        this.setSize(790, 460);
        this.setLocationRelativeTo(null);
        
        javax.swing.plaf.PanelUI uiDegradado = new javax.swing.plaf.PanelUI() {
            @Override
            public void paint(Graphics g, javax.swing.JComponent c) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 191, 255), 0, c.getHeight(), new Color(0, 26, 120));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, c.getWidth(), c.getHeight());
                super.paint(g, c);
            }
        };
        
        //lblBienvenidoUsuario.setText(usuario);
        //lblBienvenidoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        //lblBienvenidoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        //jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        //jLabel18.setText("GRUPO A") ;
        
        //jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        //jLabel19.setText("SISTEMA DE VENTAS") ;
        
      //  jPanel1.setUI(uiDegradado);
      //  jPanel2.setUI(uiDegradado);
        javax.swing.JLabel[] todosLosTextos = {
       //     lblBienvenida,lblBienvenidoUsuario, jLabel17,
        //    jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8,
       //     jLabel9, jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel15, jLabel16, jLabel18, jLabel19
        };
        
        for (javax.swing.JLabel lbl : todosLosTextos) {
            lbl.setForeground(Color.WHITE);
        }

       // btnCerrarSesion.setBackground(new Color(220, 53, 69));
       // btnCerrarSesion.setForeground(Color.WHITE);
      //  btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
       // btnCerrarSesion.setFocusPainted(false);
      //  btnCerrarSesion.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
       // btnCerrarSesion.setOpaque(true);
      //  btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuItemNuevoCliente = new javax.swing.JMenuItem();
        MenuItemVerClientes = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");
        setResizable(false);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(0, 0, 780, 400);

        jMenu1.setText("Clientes");
        jMenu1.addActionListener(this::jMenu1ActionPerformed);

        MenuItemNuevoCliente.setText("Nuevo Cliente");
        MenuItemNuevoCliente.addActionListener(this::MenuItemNuevoClienteActionPerformed);
        jMenu1.add(MenuItemNuevoCliente);

        MenuItemVerClientes.setText("Buscar Cliente");
        MenuItemVerClientes.addActionListener(this::MenuItemVerClientesActionPerformed);
        jMenu1.add(MenuItemVerClientes);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ventas");

        jMenuItem1.setText("Registrar Venta");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemNuevoClienteActionPerformed
        // TODO add your handling code here:
        vistas.internas.InternalNuevoCliente ventana = new vistas.internas.InternalNuevoCliente();
        jDesktopPane1.add(ventana);
        ventana.setVisible(true);
    }//GEN-LAST:event_MenuItemNuevoClienteActionPerformed

    private void MenuItemVerClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemVerClientesActionPerformed
        // TODO add your handling code here:
        vistas.internas.InternalVerClientes ventana2 = new vistas.internas.InternalVerClientes();
        jDesktopPane1.add(ventana2);
        ventana2.setVisible(true);
    }//GEN-LAST:event_MenuItemVerClientesActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        vistas.internas.InternalVentas2 ventana3 = new vistas.internas.InternalVentas2();
        jDesktopPane1.add(ventana3);
        ventana3.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {                                                
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas cerrar sesión?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            this.dispose();
            Login pantallaLogin = new Login();
        pantallaLogin.setVisible(true);
        }
    }                                               

    public static void main(String args[]) {
        // --- ACTIVAR RENDERIZADO NÍTIDO DE TEXTO (ANTI-ALIASING) ---
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        
        java.awt.EventQueue.invokeLater(() -> {
            new Menu("Usuario").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuItemNuevoCliente;
    private javax.swing.JMenuItem MenuItemVerClientes;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}