package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import modelos.Usuario;
import dao.UsuarioDAO;

public class Login extends javax.swing.JFrame {

    public Login() {
        javax.swing.JPanel panelFondo = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 191, 255), 0, getHeight(), new Color(0, 26, 120));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        this.setContentPane(panelFondo);

        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(800, 500); 

        lblUsuario1.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblUsuario1.setForeground(Color.WHITE);

        Font fuenteLabel = new Font("Segoe UI", Font.BOLD, 14);
        lblUsuario.setFont(fuenteLabel);
        lblUsuario.setForeground(Color.WHITE);
        lblContrasena.setFont(fuenteLabel);
        lblContrasena.setForeground(Color.WHITE);

        
        Font fuenteInput = new Font("Segoe UI", Font.PLAIN, 14);
        Color fondoInput = new Color(248, 249, 250); 
        javax.swing.JTextField[] cajas = {txtUsuario, txtContrasena};
        
        for (javax.swing.JTextField caja : cajas) {
            caja.setFont(fuenteInput);
            caja.setBackground(fondoInput);
            caja.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(206, 212, 218)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10) // Padding interno
            ));
        }

        
        Font fuenteBotones = new Font("Segoe UI", Font.BOLD, 14);
        
        btnIniciarSesion.setBackground(new Color(40, 167, 69)); // Verde éxito
        btnIniciarSesion.setForeground(Color.WHITE);
        btnIniciarSesion.setFont(fuenteBotones);
        btnIniciarSesion.setFocusPainted(false);
        btnIniciarSesion.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        btnIniciarSesion.setOpaque(true);
        btnIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        btnRegistrarse.setBackground(new Color(108, 117, 125));
        btnRegistrarse.setForeground(Color.WHITE);
        btnRegistrarse.setFont(fuenteBotones);
        btnRegistrarse.setFocusPainted(false);
        btnRegistrarse.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        btnRegistrarse.setOpaque(true);
        btnRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblContrasena = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        btnIniciarSesion = new javax.swing.JButton();
        btnRegistrarse = new javax.swing.JButton();
        lblUsuario1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblUsuario.setText("Usuario:");
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 300, -1));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 300, 35));

        lblContrasena.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblContrasena.setText("Contraseña:");
        getContentPane().add(lblContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 300, -1));
        getContentPane().add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 300, 35));

        btnIniciarSesion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnIniciarSesion.setBorderPainted(false);
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 140, 40));

        btnRegistrarse.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRegistrarse.setBorderPainted(false);
        btnRegistrarse.setFocusPainted(false);
        btnRegistrarse.setOpaque(true);
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 140, 40));

        lblUsuario1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblUsuario1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario1.setText("INICIAR SESION");
        getContentPane().add(lblUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 800, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        String usuarioEscrito = txtUsuario.getText().trim();
        String passEscrita = new String(txtContrasena.getPassword()).trim(); 
        
        Usuario usuarioFormulario = new Usuario(usuarioEscrito, passEscrita);
        UsuarioDAO dao = new UsuarioDAO();
        
        if (dao.login(usuarioFormulario)) { 
            JOptionPane.showMessageDialog(this, "Login correcto");
            String usuario = txtUsuario.getText();
            Menu ventanaMenu = new Menu(usuario);
            Menu menu = new Menu(usuario);
            menu.setVisible(true);
            this.dispose(); 
        } else {
            JOptionPane.showMessageDialog(this, "Usuario y/o contraseña incorrectos");
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        Registro pantallaRegistro = new Registro();
        pantallaRegistro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    public static void main(String args[]) {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}