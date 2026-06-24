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

public class Registro extends javax.swing.JFrame {

    private static final Color moradogris   = new Color(0x56, 0x45, 0x58);
    private static final Color marronoscuro = new Color(0x71, 0x3F, 0x25);
    private static final Color ambar        = new Color(0xBB, 0x74, 0x2E);
    private static final Color rosa         = new Color(0xA7, 0x79, 0x81);
    private static final Color fondocampo   = new Color(55, 42, 60);
    private static final Color blancosuave  = new Color(242, 238, 240);

    public Registro() {
        javax.swing.JPanel panelFondo = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, moradogris, 0, getHeight(), marronoscuro);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        this.setContentPane(panelFondo);

        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(800, 500);

        Font fuenteLabel = new Font("Verdana", Font.BOLD, 12);
        javax.swing.JLabel[] labels = {lblTitulo, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9};
        for (javax.swing.JLabel label : labels) {
            label.setFont(fuenteLabel);
            label.setForeground(blancosuave);
        }

        Font fuenteInput = new Font("Verdana", Font.PLAIN, 13);
        javax.swing.JTextField[] cajas = {txtNombre, txtApellidoP, txtApellidoM, txtDireccion, txtUsuario, txtEmail, txtTelefono};
        for (javax.swing.JTextField caja : cajas) {
            caja.setFont(fuenteInput);
            caja.setBackground(fondocampo);
            caja.setForeground(blancosuave);
            caja.setCaretColor(blancosuave);
            caja.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(rosa),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
            ));
        }

        javax.swing.JPasswordField[] campos = {txtContraseña, txtContraseñaRepetir};
        for (javax.swing.JPasswordField campo : campos) {
            campo.setFont(fuenteInput);
            campo.setBackground(fondocampo);
            campo.setForeground(blancosuave);
            campo.setCaretColor(blancosuave);
            campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(rosa),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
            ));
        }

        Font fuenteBotones = new Font("Verdana", Font.BOLD, 13);

        btnGuardar.setBackground(ambar);
        btnGuardar.setForeground(blancosuave);
        btnGuardar.setFont(fuenteBotones);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        btnGuardar.setOpaque(true);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnVolver.setBackground(marronoscuro);
        btnVolver.setForeground(blancosuave);
        btnVolver.setFont(fuenteBotones);
        btnVolver.setFocusPainted(false);
        btnVolver.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        btnVolver.setOpaque(true);
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidoP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidoM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtContraseñaRepetir = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro");
        setResizable(false);
        getContentPane().setLayout(null);

        lblTitulo.setText("Nombre:");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(180, 90, 200, 20);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(180, 110, 200, 30);

        jLabel2.setText("Apellido Paterno:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 150, 200, 20);
        getContentPane().add(txtApellidoP);
        txtApellidoP.setBounds(180, 170, 200, 30);

        jLabel3.setText("Apellido Materno:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 210, 200, 20);
        getContentPane().add(txtApellidoM);
        txtApellidoM.setBounds(180, 230, 200, 30);

        jLabel4.setText("Dirección:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(180, 270, 200, 20);
        getContentPane().add(txtDireccion);
        txtDireccion.setBounds(180, 290, 200, 30);

        jLabel5.setText("Usuario:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(420, 90, 200, 20);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(420, 110, 200, 30);

        jLabel6.setText("Contraseña:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(420, 150, 200, 20);
        getContentPane().add(txtContraseña);
        txtContraseña.setBounds(420, 170, 200, 30);

        jLabel7.setText("Repetir Contraseña:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(420, 210, 200, 20);
        getContentPane().add(txtContraseñaRepetir);
        txtContraseñaRepetir.setBounds(420, 230, 200, 30);

        jLabel8.setText("Email:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(420, 270, 200, 20);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(420, 290, 200, 30);

        jLabel9.setText("Teléfono:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(180, 330, 200, 20);
        getContentPane().add(txtTelefono);
        txtTelefono.setBounds(180, 350, 200, 30);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(420, 340, 90, 35);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);
        getContentPane().add(btnVolver);
        btnVolver.setBounds(530, 340, 90, 35);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String usuarioEscrito = txtUsuario.getText().trim();
        String passEscrita = new String(txtContraseña.getPassword()).trim();
        String passRepetida = new String(txtContraseñaRepetir.getPassword()).trim();
        String nombreEscrito = txtNombre.getText().trim();
        String apellidoPEscrito = txtApellidoP.getText().trim();
        String apellidoMEscrito = txtApellidoM.getText().trim();
        String direccionEscrita = txtDireccion.getText().trim();
        String emailEscrito = txtEmail.getText().trim();
        String telefonoEscrito = txtTelefono.getText().trim();

        if (usuarioEscrito.isEmpty() || passEscrita.isEmpty() || passRepetida.isEmpty() || 
            nombreEscrito.isEmpty() || apellidoPEscrito.isEmpty() || direccionEscrita.isEmpty() ||
            emailEscrito.isEmpty() || telefonoEscrito.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.");
            return;
        }

        if (!passEscrita.equals(passRepetida)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden. Intente de nuevo.");
            txtContraseña.setText("");
            txtContraseñaRepetir.setText("");
            txtContraseña.requestFocus();
            return;
        }

        Usuario nuevoUsuario = new Usuario(
            usuarioEscrito, passEscrita, nombreEscrito, apellidoPEscrito, 
            apellidoMEscrito, direccionEscrita, emailEscrito, telefonoEscrito
        );
        
        UsuarioDAO dao = new UsuarioDAO();

        if (dao.registrar(nuevoUsuario)) {
            JOptionPane.showMessageDialog(this, "¡Usuario registrado con éxito!");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar el usuario.");
        }
    }                                          

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Login pantallaLogin = new Login();
        pantallaLogin.setVisible(true);
        this.dispose();
    }                                        

    public static void main(String args[]) {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        java.awt.EventQueue.invokeLater(() -> {
            new Registro().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JPasswordField txtContraseñaRepetir;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}