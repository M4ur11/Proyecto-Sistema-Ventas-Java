package vistas;

import dao.UsuarioDAO;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import modelos.Usuario;

public class Login extends javax.swing.JFrame {

    private JTextField campousuario;
    private JPasswordField campocontrasena;
    private Image imagenfondo;

    private static final String rutafondo = "/recursos/fuenteshopping.jpg";
    private static final Color ambar       = new Color(0xBB, 0x74, 0x2E);
    private static final Color textoclaro  = new Color(240, 236, 240);
    private static final Color placeholder = new Color(185, 168, 180);

    public Login() {
        imagenfondo = cargarImagen();
        initComponents();
        setLocationRelativeTo(null);
    }

    private Image cargarImagen() {
        try {
            return ImageIO.read(getClass().getResource(rutafondo));
        } catch (Exception ignorado) {
            return null;
        }
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sistema de Ventas");
        setResizable(false);
        setSize(960, 700);

        JPanel fondo = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2.setColor(new Color(20, 15, 25));
                g2.fillRect(0, 0, getWidth(), getHeight());
                if (imagenfondo != null) {
                    int imgw = imagenfondo.getWidth(this);
                    int imgh = imagenfondo.getHeight(this);
                    if (imgw > 0 && imgh > 0) {
                        double escala = Math.max((double) getWidth() / imgw, (double) getHeight() / imgh);
                        int w = (int)(imgw * escala);
                        int h = (int)(imgh * escala);
                        g2.drawImage(imagenfondo, (getWidth() - w) / 2, (getHeight() - h) / 2, w, h, this);
                    }
                }
                g2.setColor(new Color(0, 0, 0, 55));
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.dispose();
            }
        };
        fondo.setOpaque(true);
        setContentPane(fondo);

        int anchocarta = 380;
        int altocarta  = 390;

        JPanel tarjeta = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(28, 18, 34, 165));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 28, 28);
                g2.setColor(new Color(167, 121, 129, 130));
                g2.setStroke(new BasicStroke(1.3f));
                g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 28, 28);
                g2.dispose();
            }
        };
        tarjeta.setOpaque(false);
        tarjeta.setBounds((960 - anchocarta) / 2, (700 - altocarta) / 2, anchocarta, altocarta);
        fondo.add(tarjeta);

        int margen     = 46;
        int anchocampo = anchocarta - margen * 2;

        JLabel titulo = new JLabel("SISTEMA DE VENTAS", SwingConstants.CENTER);
        titulo.setFont(new Font("Verdana", Font.BOLD, 22));
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(0, 38, anchocarta, 42);
        tarjeta.add(titulo);

        campousuario = crearCampoTexto("Usuario");
        campousuario.setBounds(margen, 112, anchocampo, 42);
        tarjeta.add(campousuario);

        campocontrasena = new JPasswordField("Contraseña");
        campocontrasena.setEchoChar((char) 0);
        campocontrasena.setFont(new Font("Verdana", Font.PLAIN, 13));
        campocontrasena.setForeground(placeholder);
        campocontrasena.setCaretColor(Color.WHITE);
        campocontrasena.setOpaque(false);
        campocontrasena.setBorder(BorderFactory.createCompoundBorder(
            new BordeInferior(new Color(200, 175, 190, 200)),
            BorderFactory.createEmptyBorder(8, 0, 8, 0)
        ));
        campocontrasena.setBounds(margen, 180, anchocampo, 42);
        campocontrasena.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(campocontrasena.getPassword()).equals("Contraseña")) {
                    campocontrasena.setText("");
                    campocontrasena.setEchoChar('•');
                    campocontrasena.setForeground(Color.WHITE);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (campocontrasena.getPassword().length == 0) {
                    campocontrasena.setEchoChar((char) 0);
                    campocontrasena.setText("Contraseña");
                    campocontrasena.setForeground(placeholder);
                }
            }
        });
        tarjeta.add(campocontrasena);

        JButton botonentrar = new JButton("Iniciar Sesion") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(ambar);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        botonentrar.setFont(new Font("Verdana", Font.BOLD, 14));
        botonentrar.setForeground(Color.WHITE);
        botonentrar.setContentAreaFilled(false);
        botonentrar.setFocusPainted(false);
        botonentrar.setBorderPainted(false);
        botonentrar.setOpaque(false);
        botonentrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonentrar.setBounds(margen, 252, anchocampo, 48);
        botonentrar.addActionListener(this::accionentrar);
        tarjeta.add(botonentrar);

        JLabel lblregistro = new JLabel("<html>¿No tenés cuenta?&nbsp;&nbsp;<b>Registrarse</b></html>", SwingConstants.CENTER);
        lblregistro.setFont(new Font("Verdana", Font.PLAIN, 12));
        lblregistro.setForeground(textoclaro);
        lblregistro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblregistro.setBounds(0, 326, anchocarta, 30);
        lblregistro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                accionregistrarse();
            }
        });
        tarjeta.add(lblregistro);
    }

    private JTextField crearCampoTexto(String ph) {
        JTextField campo = new JTextField(ph);
        campo.setFont(new Font("Verdana", Font.PLAIN, 13));
        campo.setForeground(placeholder);
        campo.setCaretColor(Color.WHITE);
        campo.setOpaque(false);
        campo.setBorder(BorderFactory.createCompoundBorder(
            new BordeInferior(new Color(200, 175, 190, 200)),
            BorderFactory.createEmptyBorder(8, 0, 8, 0)
        ));
        campo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (campo.getText().equals(ph)) {
                    campo.setText("");
                    campo.setForeground(Color.WHITE);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (campo.getText().isEmpty()) {
                    campo.setText(ph);
                    campo.setForeground(placeholder);
                }
            }
        });
        return campo;
    }

    private static class BordeInferior extends AbstractBorder {
        private final Color color;
        BordeInferior(Color color) { this.color = color; }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(color);
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawLine(x, y + height - 1, x + width - 1, y + height - 1);
            g2.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) { return new Insets(0, 0, 2, 0); }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.top = insets.right = 0;
            insets.bottom = 2;
            return insets;
        }
    }

    private void accionentrar(ActionEvent evt) {
        String usuarioescrito = campousuario.getText().trim();
        String passescrita    = new String(campocontrasena.getPassword()).trim();
        if (usuarioescrito.equals("Usuario") || usuarioescrito.isEmpty()
                || passescrita.isEmpty() || passescrita.equals("Contraseña")) {
            JOptionPane.showMessageDialog(this, "Completá usuario y contraseña");
            return;
        }
        Usuario usuarioformulario = new Usuario(usuarioescrito, passescrita);
        UsuarioDAO dao = new UsuarioDAO();
        if (dao.login(usuarioformulario)) {
            new Menu(usuarioescrito).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario y/o contraseña incorrectos");
        }
    }

    private void accionregistrarse() {
        new Registro().setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }
}
