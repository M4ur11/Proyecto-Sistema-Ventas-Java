package dao;

import conexion.ConexionDB;
import modelos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ProductoDAO {
    public Producto buscarPorId(int idProducto) {
        String sql = "SELECT id_producto, nombre_producto, descripcion, precio_venta, stock FROM productos WHERE id_producto = ? AND estado = true";
        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Producto p = new Producto();
                    p.setIdProducto(rs.getInt("id_producto"));
                    p.setNombreProducto(rs.getString("nombre_producto")); 
                    p.setDescripcion(rs.getString("descripcion"));
                    p.setPrecioVenta(rs.getDouble("precio_venta"));
                    p.setStock(rs.getInt("stock"));
                    return p;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en ProductoDAO.buscarPorId: " + e.getMessage());
        }
        return null;
    }
}