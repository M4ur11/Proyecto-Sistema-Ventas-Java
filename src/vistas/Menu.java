package vistas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class Menu extends javax.swing.JFrame {

    private static final Color moradogris   = new Color(0x56, 0x45, 0x58);
    private static final Color marronoscuro = new Color(0x71, 0x3F, 0x25);
    private static final Color blancosuave  = new Color(242, 238, 240);

    public Menu(String usuario) {
        initComponents();
        this.setSize(790, 460);
        this.setLocationRelativeTo(null);

        jMenuBar1.setBackground(moradogris);
        jMenuBar1.setBorder(BorderFactory.createEmptyBorder(2, 4, 2, 4));

        Font fuentemenu = new Font("Verdana", Font.BOLD, 13);
        for (int i = 0; i < jMenuBar1.getMenuCount(); i++) {
            javax.swing.JMenu menu = jMenuBar1.getMenu(i);
            menu.setFont(fuentemenu);
            menu.setForeground(blancosuave);
            menu.setBackground(moradogris);
            menu.setOpaque(true);
            for (int j = 0; j < menu.getItemCount(); j++) {
                javax.swing.JMenuItem item = menu.getItem(j);
                if (item != null) {
                    item.setFont(new Font("Verdana", Font.PLAIN, 13));
                    item.setBackground(marronoscuro);
                    item.setForeground(blancosuave);
                }
            }
        }

        jDesktopPane1.setBackground(new Color(38, 28, 42));
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
        vistas.internas.InternalNuevoCliente ventana = new vistas.internas.InternalNuevoCliente();
        jDesktopPane1.add(ventana);
        ventana.setVisible(true);
    }//GEN-LAST:event_MenuItemNuevoClienteActionPerformed

    private void MenuItemVerClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemVerClientesActionPerformed
        vistas.internas.InternalVerClientes ventana2 = new vistas.internas.InternalVerClientes();
        jDesktopPane1.add(ventana2);
        ventana2.setVisible(true);
    }//GEN-LAST:event_MenuItemVerClientesActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
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
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        java.awt.EventQueue.invokeLater(() -> new Menu("Usuario").setVisible(true));
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
