/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.ConexionDB;
import modelos.Ventas;
import modelos.DetalleVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class VentaDAO {
    public int obtenerUltimoIdVenta() {
    String sql = "SELECT MAX(id_venta) FROM ventas";
    try (Connection con = ConexionDB.conectar();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        if (rs.next()) {
            return rs.getInt(1);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener último ID de venta: " + e.getMessage());
    }
    return 0;
}
    public boolean registrarVentaCompleta(Ventas venta) {
        Connection con = null;
        PreparedStatement psVenta = null;
        PreparedStatement psDetalle = null;
        PreparedStatement psStock = null;
        ResultSet rs = null;
        String sqlVenta = "INSERT INTO ventas (id_cliente, nro_factura, total) VALUES (?, ?, ?)";
        String sqlDetalle = "INSERT INTO detalle_ventas (id_venta, id_producto, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";
        String sqlStock = "UPDATE productos SET stock = stock - ? WHERE id_producto = ?";

        try {
            con = ConexionDB.conectar();
            con.setAutoCommit(false); // Iniciamos la transacción segura
            psVenta = con.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS);
            psVenta.setInt(1, venta.getIdCliente());
            psVenta.setString(2, venta.getNroFactura());
            psVenta.setDouble(3, venta.getTotal());
            psVenta.executeUpdate();
            rs = psVenta.getGeneratedKeys();
            int idVentaGenerado = 0;
            if (rs.next()) {
                idVentaGenerado = rs.getInt(1);
            }
            psDetalle = con.prepareStatement(sqlDetalle);
            psStock = con.prepareStatement(sqlStock);

            for (DetalleVenta det : venta.getDetalles()) {
                psDetalle.setInt(1, idVentaGenerado);
                psDetalle.setInt(2, det.getIdProducto());
                psDetalle.setInt(3, det.getCantidad());
                psDetalle.setDouble(4, det.getPrecioUnitario());
                psDetalle.addBatch();
                psStock.setInt(1, det.getCantidad());
                psStock.setInt(2, det.getIdProducto());
                psStock.addBatch();
            }
            psDetalle.executeBatch();
            psStock.executeBatch();
            con.commit();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en transacción de Venta: " + e.getMessage());
            if (con != null) {
                try {
                    con.rollback();
                    System.out.println("Rollback ejecutado con éxito.");
                } catch (SQLException ex) {
                    System.out.println("Error en Rollback: " + ex.getMessage());
                }
            }
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (psVenta != null) psVenta.close();
                if (psDetalle != null) psDetalle.close();
                if (psStock != null) psStock.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexiones: " + e.getMessage());
            }
        }
    }
}
