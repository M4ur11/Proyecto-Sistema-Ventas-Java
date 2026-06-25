package dao;
import conexion.ConexionDB;
import modelos.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {
    
        public Cliente buscarPorCedulaRuc(String cedulaRuc) {
        String sql = "SELECT id_cliente, nombre, apellido, telefono, direccion, email FROM clientes WHERE cedula_ruc = ?";
        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cedulaRuc);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cliente c = new Cliente();
                    c.setId(rs.getInt("id_cliente"));
                    c.setNombre(rs.getString("nombre"));
                    c.setApellido(rs.getString("apellido"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setDireccion(rs.getString("direccion"));
                    c.setEmail(rs.getString("email"));
                    return c;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en ClienteDAO.buscarPorCedulaRuc: " + e.getMessage());
        }
        return null;
    }
    
    public boolean actualizar(Cliente c) {
    String sql = "UPDATE clientes SET nombre = ?, apellido = ?, telefono = ?, direccion = ?, email = ? WHERE cedula_ruc = ?";
    try (Connection con = ConexionDB.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getApellido());
        ps.setString(3, c.getTelefono());
        ps.setString(4, c.getDireccion());
        ps.setString(5, c.getEmail());
        ps.setString(6, c.getCiRuc());
        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;
    } catch (SQLException e) {
        System.out.println("Error en ClienteDAO.actualizar: " + e.getMessage());
        return false;
    }
}
    public boolean eliminar(String ciRuc) {
    String sql = "DELETE FROM clientes WHERE cedula_ruc = ?";
    
    try (Connection con = ConexionDB.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, ciRuc);
        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;
        
    } catch (SQLException e) {
        System.out.println("Error en ClienteDAO.eliminar: " + e.getMessage());
        return false;
    }
}
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT id_cliente, nombre, apellido, cedula_ruc, telefono, direccion,email FROM clientes ORDER BY id_cliente ASC";
        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (con != null) {
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setId(rs.getInt("id_cliente"));
                    c.setNombre(rs.getString("nombre"));
                    c.setApellido(rs.getString("apellido"));
                    c.setCiRuc(rs.getString("cedula_ruc"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setDireccion(rs.getString("direccion"));
                    c.setEmail(rs.getString("email"));
                    lista.add(c);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en ClienteDAO.listar: " + e.getMessage());
        }
        return lista;
    }
    
    public List<Cliente> buscarFiltrado(String nombre, String apellido, String ciRuc) {
        List<Cliente> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT nombre, apellido, cedula_ruc, telefono, direccion, email FROM clientes WHERE 1=1");
        if (!nombre.trim().isEmpty())   sql.append(" AND nombre ILIKE ?");
        if (!apellido.trim().isEmpty()) sql.append(" AND apellido ILIKE ?");
        if (!ciRuc.trim().isEmpty())    sql.append(" AND cedula_ruc LIKE ?");
        sql.append(" ORDER BY id_cliente ASC");
        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql.toString())) {
            int index = 1;
            if (!nombre.trim().isEmpty())   ps.setString(index++, "%" + nombre.trim() + "%");
            if (!apellido.trim().isEmpty()) ps.setString(index++, "%" + apellido.trim() + "%");
            if (!ciRuc.trim().isEmpty())    ps.setString(index++, "%" + ciRuc.trim() + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setNombre(rs.getString("nombre"));
                    c.setApellido(rs.getString("apellido"));
                    c.setCiRuc(rs.getString("cedula_ruc"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setDireccion(rs.getString("direccion"));
                    c.setEmail(rs.getString("email"));
                    lista.add(c);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en ClienteDAO.buscarFiltrado: " + e.getMessage());
        }
        return lista;
    }
    
    public boolean guardar(Cliente cliente) {
        boolean resultado = false;
        try {
            Connection conn = ConexionDB.conectar();
            String sql = "INSERT INTO clientes(cedula_ruc, nombre, apellido, telefono, email, direccion)VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getCiRuc());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getEmail());
            ps.setString(6, cliente.getDireccion());
            ps.executeUpdate();
            resultado = true;
        } catch (Exception e) {
            System.out.println("Error al guardar: " +
    e.getMessage());
            }
            return resultado;
        }
public ResultSet buscar(String nombre) {
    ResultSet rs = null;
    try {
        Connection conn = ConexionDB.conectar();
        String sql = "SELECT id_cliente, nombre, ci_ruc FROM clientes WHERE nombre ILIKE ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + nombre + "%");
        rs = ps.executeQuery();
        } 
    catch (Exception e) {
        System.out.println("Error al buscar: " +
        e.getMessage());
    }
    return rs;
}
public boolean borrar(int id) {
    boolean resultado = false;
    try {
    Connection conn = ConexionDB.conectar();
    String sql = "DELETE FROM clientes WHERE id_cliente=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, id);
    ps.executeUpdate();
    resultado = true;
    }
    catch (Exception e) {
        System.out.println("Error al borrar: " +
        e.getMessage());
    }
return resultado;
}
}