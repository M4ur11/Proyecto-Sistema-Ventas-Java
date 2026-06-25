package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

        javax.swing.JPanel panelFondo = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, moradogris, 0, getHeight(), new Color(20, 10, 25));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        jDesktopPane1.setLayout(new java.awt.BorderLayout());
        jDesktopPane1.add(panelFondo, java.awt.BorderLayout.CENTER);
        jDesktopPane1.setLayer(panelFondo, javax.swing.JLayeredPane.FRAME_CONTENT_LAYER);

        lblBienvenida.setText("Bienvenido al Sistema");
        lblBienvenida.setFont(new Font("Verdana", Font.BOLD, 24));
        lblBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // AGREGÁ ESTAS DOS LÍNEAS PARA EL USUARIO:
        lblBienvenidoUsuario.setText(usuario);
        lblBienvenidoUsuario.setFont(new Font("Verdana", Font.BOLD, 20));

        for (javax.swing.JLabel lbl : new javax.swing.JLabel[]{lblBienvenida, lblBienvenidoUsuario}) {
            lbl.setForeground(blancosuave);
        }

        btnCerrarSesion.setBackground(new Color(220, 53, 69));
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFont(new Font("Verdana", Font.BOLD, 14));
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        btnCerrarSesion.setOpaque(true);
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        lblBienvenida = new javax.swing.JLabel();
        lblBienvenidoUsuario = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuItemNuevoCliente = new javax.swing.JMenuItem();
        MenuItemVerClientes = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");
        setResizable(false);
        getContentPane().setLayout(null);

        jDesktopPane1.setOpaque(false);

        lblBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblBienvenidoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnCerrarSesion.setBackground(new java.awt.Color(255, 0, 0));
        btnCerrarSesion.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(this::btnCerrarSesionActionPerformed);

        jDesktopPane1.setLayer(lblBienvenida, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lblBienvenidoUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnCerrarSesion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(221, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblBienvenidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(210, 210, 210))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBienvenidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
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

        jMenu3.setText("Desarrollado Por");

        jMenuItem2.setText("Ver integrantes");
        jMenuItem2.addActionListener(this::jMenuItem2ActionPerformed);
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void MenuItemNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        vistas.internas.InternalNuevoCliente ventana = new vistas.internas.InternalNuevoCliente();
        jDesktopPane1.add(ventana);
        ventana.setVisible(true);
    }

    private void MenuItemVerClientesActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        vistas.internas.InternalVerClientes ventana2 = new vistas.internas.InternalVerClientes();
        jDesktopPane1.add(ventana2);
        ventana2.setVisible(true);
    }

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        vistas.internas.InternalVentas2 ventana3 = new vistas.internas.InternalVentas2();
        jDesktopPane1.add(ventana3);
        ventana3.setVisible(true);
    }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        jDesktopPane1.removeAll();

        javax.swing.JPanel pantallaDatos = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, moradogris, 0, getHeight(), new Color(20, 10, 25));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        pantallaDatos.setOpaque(true);
        pantallaDatos.setBounds(0, 0, jDesktopPane1.getWidth(), jDesktopPane1.getHeight());
        pantallaDatos.setLayout(new java.awt.BorderLayout(20, 10));

        javax.swing.JLabel lblTitulo = new javax.swing.JLabel("DESARROLLADO POR", javax.swing.SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 26));
        lblTitulo.setForeground(blancosuave); // Cambia a Color.BLACK si preferís letras oscuras sobre el gris
        lblTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(25, 0, 0, 0));
        pantallaDatos.add(lblTitulo, java.awt.BorderLayout.NORTH);

        javax.swing.JPanel panelColumnas = new javax.swing.JPanel(new java.awt.GridLayout(9, 2, 10, 5));
        panelColumnas.setOpaque(false);
        panelColumnas.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 120, 15, 120));

        javax.swing.JLabel hNombre = new javax.swing.JLabel("Nombre", javax.swing.SwingConstants.CENTER);
        hNombre.setFont(new Font("Verdana", Font.BOLD, 16));
        hNombre.setForeground(blancosuave);

        javax.swing.JLabel hCI = new javax.swing.JLabel("C.I.", javax.swing.SwingConstants.CENTER);
        hCI.setFont(new Font("Verdana", Font.BOLD, 16));
        hCI.setForeground(blancosuave);

        panelColumnas.add(hNombre);
        panelColumnas.add(hCI);

        javax.swing.JLabel name1 = new javax.swing.JLabel("Juan Acuña", javax.swing.SwingConstants.CENTER);
        name1.setFont(new Font("Verdana", Font.PLAIN, 14));
        name1.setForeground(blancosuave);

        javax.swing.JLabel ci1 = new javax.swing.JLabel("X.XXX.XXX", javax.swing.SwingConstants.CENTER);
        ci1.setFont(new Font("Verdana", Font.PLAIN, 14));
        ci1.setForeground(blancosuave);

        panelColumnas.add(name1);
        panelColumnas.add(ci1);

        javax.swing.JLabel name2 = new javax.swing.JLabel("Cecilia Alvarez", javax.swing.SwingConstants.CENTER);
        name2.setFont(new Font("Verdana", Font.PLAIN, 14));
        name2.setForeground(blancosuave);

        javax.swing.JLabel ci2 = new javax.swing.JLabel("5.815.049", javax.swing.SwingConstants.CENTER);
        ci2.setFont(new Font("Verdana", Font.PLAIN, 14));
        ci2.setForeground(blancosuave);

        panelColumnas.add(name2);
        panelColumnas.add(ci2);

        javax.swing.JLabel name3 = new javax.swing.JLabel("Cecilia Bogarín", javax.swing.SwingConstants.CENTER);
        name3.setFont(new Font("Verdana", Font.PLAIN, 14));
        name3.setForeground(blancosuave);

        javax.swing.JLabel ci3 = new javax.swing.JLabel("5.641.260", javax.swing.SwingConstants.CENTER);
        ci3.setFont(new Font("Verdana", Font.PLAIN, 14));
        ci3.setForeground(blancosuave);

        panelColumnas.add(name3);
        panelColumnas.add(ci3);

        javax.swing.JLabel name4 = new javax.swing.JLabel("Tobias Castro", javax.swing.SwingConstants.CENTER);
        name4.setFont(new Font("Verdana", Font.PLAIN, 14));
        name4.setForeground(blancosuave);

        javax.swing.JLabel ci4 = new javax.swing.JLabel("X.XXX.XXX", javax.swing.SwingConstants.CENTER);
        ci4.setFont(new Font("Verdana", Font.PLAIN, 14));
        ci4.setForeground(blancosuave);

        panelColumnas.add(name4);
        panelColumnas.add(ci4);

        javax.swing.JLabel name5 = new javax.swing.JLabel("Leiza Castro", javax.swing.SwingConstants.CENTER);
        name5.setFont(new Font("Verdana", Font.PLAIN, 14));
        name5.setForeground(blancosuave);

        javax.swing.JLabel ci5 = new javax.swing.JLabel("X.XXX.XXX", javax.swing.SwingConstants.CENTER);
        ci5.setFont(new Font("Verdana", Font.PLAIN, 14));
        ci5.setForeground(blancosuave);

        panelColumnas.add(name5);
        panelColumnas.add(ci5);

        javax.swing.JLabel name6 = new javax.swing.JLabel("Dámaris Centurión", javax.swing.SwingConstants.CENTER);
        name6.setFont(new Font("Verdana", Font.PLAIN, 14));
        name6.setForeground(blancosuave);

        javax.swing.JLabel ci6 = new javax.swing.JLabel("X.XXX.XXX", javax.swing.SwingConstants.CENTER);
        ci6.setFont(new Font("Verdana", Font.PLAIN, 14));
        ci6.setForeground(blancosuave);

        panelColumnas.add(name6);
        panelColumnas.add(ci6);

        javax.swing.JLabel name7 = new javax.swing.JLabel("Mauricio López", javax.swing.SwingConstants.CENTER);
        name7.setFont(new Font("Verdana", Font.PLAIN, 14));
        name7.setForeground(blancosuave);

        javax.swing.JLabel ci7 = new javax.swing.JLabel("5.647.204", javax.swing.SwingConstants.CENTER);
        ci7.setFont(new Font("Verdana", Font.PLAIN, 14));
        ci7.setForeground(blancosuave);

        panelColumnas.add(name7);
        panelColumnas.add(ci7);

        javax.swing.JLabel name8 = new javax.swing.JLabel("Fernanda Otero", javax.swing.SwingConstants.CENTER);
        name8.setFont(new Font("Verdana", Font.PLAIN, 14));
        name8.setForeground(blancosuave);

        javax.swing.JLabel ci8 = new javax.swing.JLabel("5.690.073", javax.swing.SwingConstants.CENTER);
        ci8.setFont(new Font("Verdana", Font.PLAIN, 14));
        ci8.setForeground(blancosuave);

        panelColumnas.add(name8);
        panelColumnas.add(ci8);

        pantallaDatos.add(panelColumnas, java.awt.BorderLayout.CENTER);

        javax.swing.JPanel panelPie = new javax.swing.JPanel();
        panelPie.setOpaque(false);
        panelPie.setLayout(new javax.swing.BoxLayout(panelPie, javax.swing.BoxLayout.Y_AXIS));
        panelPie.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 25, 0));

        javax.swing.JLabel lblSistema = new javax.swing.JLabel("SISTEMA DE VENTAS");
        lblSistema.setFont(new Font("Verdana", Font.BOLD, 14));
        lblSistema.setForeground(blancosuave);
        lblSistema.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

        javax.swing.JLabel lblGrupo = new javax.swing.JLabel("GRUPO A");
        lblGrupo.setFont(new Font("Verdana", Font.PLAIN, 12));
        lblGrupo.setForeground(blancosuave);
        lblGrupo.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

        panelPie.add(lblSistema);
        panelPie.add(javax.swing.Box.createVerticalStrut(4));
        panelPie.add(lblGrupo);

        pantallaDatos.add(panelPie, java.awt.BorderLayout.SOUTH);

        jDesktopPane1.add(pantallaDatos);
        jDesktopPane1.repaint();
        jDesktopPane1.revalidate();
    }

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
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

    // Variables declaration - do not modify
    private javax.swing.JMenuItem MenuItemNuevoCliente;
    private javax.swing.JMenuItem MenuItemVerClientes;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblBienvenidoUsuario;
    // End of variables declaration
}
