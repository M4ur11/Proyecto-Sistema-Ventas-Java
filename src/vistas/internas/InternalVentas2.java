/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas.internas;
import dao.VentaDAO;
import modelos.DetalleVenta;
import modelos.Ventas;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author m4uri
 */
public class InternalVentas2 extends javax.swing.JInternalFrame {
    
    private void limpiarFormularioCompleto() {
    idClienteSeleccionado = -1;
    idProductoSeleccionado = -1;
    totalAcumulado = 0.0;
    txtCI.setText("");
    txtNombre.setText("");
    txtTelefono.setText("");
    txtCodigo.setText("");
    txtDescripcion.setText("");
    txtPrecio.setText("");
    lblStock.setText("");
    txtCantidad.setText("");
    modeloDetalle.setRowCount(0);
    lblTotal.setText("0.0");
    txtCI.requestFocus();
};
    
    public void generarFacturaPDF(Ventas v) {
    JFileChooser chooser = new JFileChooser();
    chooser.setSelectedFile(new File("Factura_" + v.getNroFactura().replace("-", "_") + ".pdf"));
    int returnVal = chooser.showSaveDialog(this);
    if (returnVal != JFileChooser.APPROVE_OPTION) {
        return;
    }
    String rutaArchivo = chooser.getSelectedFile().getAbsolutePath();
    Document documento = new Document();
    try {
        PdfWriter.getInstance(documento, new FileOutputStream(rutaArchivo));
        documento.open();
        Font tituloFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
        Font subtituloFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
        Font negritaFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
        Font normalFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
        
        Paragraph localNombre = new Paragraph("MI NEGOCIO S.A.", tituloFont);
        localNombre.setAlignment(Element.ALIGN_CENTER);
        documento.add(localNombre);
        Paragraph localDatos = new Paragraph("RUC: 80000000-1\nCasa Central: Asunción, Paraguay\nTeléfono: 0981-123456", subtituloFont);
        localDatos.setAlignment(Element.ALIGN_CENTER);
        documento.add(localDatos);
        documento.add(new Paragraph(" \n"));
        PdfPTable tablaInfo = new PdfPTable(2);
        tablaInfo.setWidthPercentage(100);
        PdfPCell celdaFactura = new PdfPCell(new Phrase("FACTURA CONTADO", negritaFont));
        celdaFactura.setBorder(PdfPCell.NO_BORDER);
        PdfPCell celdaNro = new PdfPCell(new Phrase("Nro: " + v.getNroFactura(), tituloFont));
        celdaNro.setBorder(PdfPCell.NO_BORDER);
        celdaNro.setHorizontalAlignment(Element.ALIGN_RIGHT);
        tablaInfo.addCell(celdaFactura);
        tablaInfo.addCell(celdaNro);
        documento.add(tablaInfo);
        documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------", normalFont));
        
        
        String fechaActual = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
        documento.add(new Paragraph("Fecha de Emisión: " + fechaActual, normalFont));
        documento.add(new Paragraph("Cliente: " + txtNombre.getText(), normalFont)); // O de v.getCliente()
        documento.add(new Paragraph("RUC / C.I.: " + txtCI.getText(), normalFont));
        documento.add(new Paragraph(" \n"));

        PdfPTable tablaDetallePDF = new PdfPTable(4); 
        tablaDetallePDF.setWidthPercentage(100);
        tablaDetallePDF.setWidths(new float[]{15f, 45f, 20f, 20f}); 

String[] headers = {"Código", "Descripción", "Precio Unit.", "Cant."};
for (String header : headers) {
    PdfPCell cell = new PdfPCell(new Phrase(header, negritaFont));
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    tablaDetallePDF.addCell(cell);
}
double totalGeneral = 0.0;
for (int i = 0; i < tablaDetalle.getRowCount(); i++) {
    String codigo = tablaDetalle.getValueAt(i, 0).toString();
    String descripcion = tablaDetalle.getValueAt(i, 1).toString();
    String precio = tablaDetalle.getValueAt(i, 2).toString();
    String cantidad = tablaDetalle.getValueAt(i, 3).toString();
    tablaDetallePDF.addCell(new PdfPCell(new Phrase(codigo, normalFont)));
    tablaDetallePDF.addCell(new PdfPCell(new Phrase(descripcion, normalFont))); 
    tablaDetallePDF.addCell(new PdfPCell(new Phrase(precio, normalFont)));
    tablaDetallePDF.addCell(new PdfPCell(new Phrase(cantidad, normalFont)));
    totalGeneral += (Double.parseDouble(precio) * Integer.parseInt(cantidad));
        }
        
        documento.add(tablaDetallePDF);
        documento.add(new Paragraph(" \n"));
        Paragraph totalP = new Paragraph("TOTAL GENERAL: Gs. " + totalGeneral, tituloFont);
        totalP.setAlignment(Element.ALIGN_RIGHT);
        documento.add(totalP);
        JOptionPane.showMessageDialog(this, "Documento PDF generado de forma exitosa.");
        
    } catch (DocumentException | java.io.FileNotFoundException e) {
        JOptionPane.showMessageDialog(this, "Error crítico al generar PDF: " + e.getMessage());
    } finally {
        documento.close();
    }
}
    private int idClienteSeleccionado = -1;
    private int idProductoSeleccionado = -1;
    private double totalAcumulado = 0.0;
    private javax.swing.table.DefaultTableModel modeloDetalle;
    private void agregarProductoAlDetalle() {
    if (idProductoSeleccionado == -1 || txtDescripcion.getText().isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, busca un producto por su código primero.");
        return;
    }
    String cantStr = txtCantidad.getText().trim();
    if (cantStr.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Ingresa una cantidad.");
        return;
    }
    
    try {
        int cantidad = Integer.parseInt(cantStr);
        int stockDisponible = Integer.parseInt(lblStock.getText()); 
        double precio = Double.parseDouble(txtPrecio.getText());
        
        if (cantidad <= 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero.");
            return;
        }
        
        if (cantidad > stockDisponible) {
            javax.swing.JOptionPane.showMessageDialog(this, "Stock insuficiente. Saldo disponible en BD: " + stockDisponible);
            return;
        }
        Object[] fila = new Object[4];
        fila[0] = idProductoSeleccionado;
        fila[1] = txtDescripcion.getText();
        fila[2] = precio;
        fila[3] = cantidad;
        modeloDetalle.addRow(fila);
        calcularTotalFactura();
        idProductoSeleccionado = -1;
        txtCodigo.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        lblStock.setText("");
        txtCantidad.setText("");
        txtCodigo.requestFocus(); 
        
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero válido.");
    }
}
    private void calcularTotalFactura() {
    totalAcumulado = 0.0;  
    for (int i = 0; i < tablaDetalle.getRowCount(); i++) {
        double precio = Double.parseDouble(tablaDetalle.getValueAt(i, 2).toString());
        int cantidad = Integer.parseInt(tablaDetalle.getValueAt(i, 3).toString());
        
        totalAcumulado += (precio * cantidad);
    }
    lblTotal.setText("TOTAL: " + totalAcumulado); 
}
    public InternalVentas2() {
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
        modeloDetalle = (javax.swing.table.DefaultTableModel) tablaDetalle.getModel();
        modeloDetalle.setRowCount(0);

        for (javax.swing.JLabel lbl : new javax.swing.JLabel[]{jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, jLabel10, jLabel11, jLabel12, lblStock, lblTotal}) {
            lbl.setFont(fuenteLabel);
            lbl.setForeground(blancosuave);
        }

        for (javax.swing.JTextField txt : new javax.swing.JTextField[]{txtCI, txtNombre, txtTelefono, txtCodigo, txtDescripcion, txtPrecio, txtCantidad}) {
            txt.setFont(fuenteCampo);
            txt.setBackground(fondocampo);
            txt.setForeground(blancosuave);
            txt.setCaretColor(blancosuave);
            txt.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(rosa),
                javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8)
            ));
        }

        tablaDetalle.setBackground(fondocampo);
        tablaDetalle.setForeground(blancosuave);
        tablaDetalle.setGridColor(rosa);
        tablaDetalle.getTableHeader().setBackground(marronoscuro);
        tablaDetalle.getTableHeader().setForeground(blancosuave);
        tablaDetalle.getTableHeader().setFont(fuenteBoton);
        jScrollPane.getViewport().setBackground(fondocampo);

        for (javax.swing.JButton btn : new javax.swing.JButton[]{btnBuscar, btnBuscar2, jButton1, jButton3, jButton4}) {
            btn.setFont(fuenteBoton);
            btn.setBackground(ambar);
            btn.setForeground(java.awt.Color.BLACK);
            btn.setFocusPainted(false);
            btn.setOpaque(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCI = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnBuscar2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblStock = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        tablaDetalle = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Datos del Cliente");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jLabel3.setText("CI/RUC");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 30));

        txtCI.addActionListener(this::txtCIActionPerformed);
        getContentPane().add(txtCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 101, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        jLabel4.setText("Nombre");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, 30));

        txtNombre.addActionListener(this::txtNombreActionPerformed);
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 150, -1));

        jLabel5.setText("Telefono");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, 30));

        txtTelefono.addActionListener(this::txtTelefonoActionPerformed);
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 151, -1));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 97, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 768, 10));

        jLabel7.setText("Agregar Productos");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 160, 30));

        jLabel8.setText("Codigo");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, 30));

        txtCodigo.addActionListener(this::txtCodigoActionPerformed);
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 100, -1));

        btnBuscar2.setText("Buscar");
        btnBuscar2.addActionListener(this::btnBuscar2ActionPerformed);
        getContentPane().add(btnBuscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        jLabel9.setText("Descripcion");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, -1, 30));

        jLabel10.setText("Precio");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 40, -1));

        txtDescripcion.addActionListener(this::txtDescripcionActionPerformed);
        getContentPane().add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 190, -1));

        txtPrecio.addActionListener(this::txtPrecioActionPerformed);
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 100, -1));

        jLabel11.setText("Cantidad");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 100, -1));

        lblStock.setText("Stock: ");
        getContentPane().add(lblStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        tablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Precio", "Cantidad"
            }
        ));
        jScrollPane.setViewportView(tablaDetalle);

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 740, 190));

        jButton3.setText("Cancelar");
        jButton3.addActionListener(this::jButton3ActionPerformed);
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 130, 30));

        jButton4.setText("Guardar");
        jButton4.addActionListener(this::jButton4ActionPerformed);
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, 130, 30));

        jLabel12.setText("TOTAL : ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, -1, 30));

        lblTotal.setText("0");
        getContentPane().add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 40, 30));

        jButton1.setText("Agregar");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, -1, -1));

        pack();
    }// </editor-fold>                        

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        String ruc = txtCI.getText().trim();
if (ruc.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(this, "Ingresá un CI/RUC válido.");
    return;
}
dao.ClienteDAO cDao = new dao.ClienteDAO();
modelos.Cliente c = cDao.buscarPorCedulaRuc(ruc);

if (c != null) {
    idClienteSeleccionado = c.getId();
    String nombre = (c.getNombre() != null) ? c.getNombre() : "";
    String apellido = (c.getApellido() != null) ? c.getApellido() : "";
    txtNombre.setText((nombre + " " + apellido).trim());
    txtTelefono.setText(c.getTelefono());
} else {
    javax.swing.JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
    idClienteSeleccionado = -1;
    txtNombre.setText("");
    txtTelefono.setText("");
}
    }                                         

    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        String codigoStr = txtCodigo.getText().trim();
    if (codigoStr.isEmpty()) return;
    
    try {
        int idProd = Integer.parseInt(codigoStr);
        dao.ProductoDAO pDao = new dao.ProductoDAO();
        modelos.Producto p = pDao.buscarPorId(idProd);
        
        if (p != null) {
            idProductoSeleccionado = p.getIdProducto();
            txtDescripcion.setText(p.getNombreProducto()); 
            txtPrecio.setText(String.valueOf(p.getPrecioVenta()));
            lblStock.setText(String.valueOf(p.getStock()));
            txtCantidad.requestFocus();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Producto no encontrado o inactivo.");
            idProductoSeleccionado = -1;
            txtDescripcion.setText("");
            txtPrecio.setText("");
            lblStock.setText("");
        }
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "El código del producto debe ser un número entero.");
    }
    }                                          

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        if (idClienteSeleccionado == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, busca y selecciona un cliente primero.");
        return;
    }
    if (tablaDetalle.getRowCount() == 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "No hay productos agregados al detalle.");
        return;
    }
    Ventas v = new Ventas();
    v.setIdCliente(idClienteSeleccionado);
    v.setTotal(totalAcumulado);
    VentaDAO vDao = new VentaDAO();
    int siguienteNumero = vDao.obtenerUltimoIdVenta() + 1;
    String nroFactura = "001-001-" + String.format("%07d", siguienteNumero);
    v.setNroFactura(nroFactura);
    java.util.ArrayList<DetalleVenta> listaDetalles = new java.util.ArrayList<>();
    for (int i = 0; i < tablaDetalle.getRowCount(); i++) {
    DetalleVenta dv = new DetalleVenta();
    dv.setIdProducto(Integer.parseInt(tablaDetalle.getValueAt(i, 0).toString()));
    int cantidad = Integer.parseInt(tablaDetalle.getValueAt(i, 3).toString());
    dv.setCantidad(cantidad);
    double precioUnitario = Double.parseDouble(tablaDetalle.getValueAt(i, 2).toString());
    dv.setPrecioUnitario(precioUnitario);
    double subtotalCalculado = cantidad * precioUnitario;
    dv.setSubtotal(subtotalCalculado);
    listaDetalles.add(dv);
}
    v.setDetalles(listaDetalles);
    
    if (vDao.registrarVentaCompleta(v)) {
        javax.swing.JOptionPane.showMessageDialog(this, "¡Venta procesada exitosamente!\nFactura Nro: " + nroFactura);
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea exportar e imprimir el comprobante en PDF?", "Confirmar Impresión", JOptionPane.YES_NO_OPTION);
    if (respuesta == JOptionPane.YES_OPTION) {
        generarFacturaPDF(v);
    }
        limpiarFormularioCompleto();
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Error crítico: No se pudo registrar la venta.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        agregarProductoAlDetalle();
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        limpiarFormularioCompleto();
    }                                        

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void txtCIActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tablaDetalle;
    private javax.swing.JTextField txtCI;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration                   
}
