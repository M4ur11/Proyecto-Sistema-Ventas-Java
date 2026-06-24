<<<<<<< HEAD
package dao;

import conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.Usuario;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioDAO {

    public boolean registrar(Usuario user) {
        boolean insertado = false;
        String sql = "INSERT INTO usuarios (usuario, contrasenaH, nombre, apellido_paterno, apellido_materno, direccion, email, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String contrasenaHasheada = BCrypt.hashpw(user.getContrasena(), BCrypt.gensalt());
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsuario());
            ps.setString(2, contrasenaHasheada);
            ps.setString(3, user.getNombre());
            ps.setString(4, user.getApellidoPaterno());
            ps.setString(5, user.getApellidoMaterno());
            ps.setString(6, user.getDireccion());
            ps.setString(7, user.getEmail()); 
            ps.setString(8, user.getTelefono());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                insertado = true;
            }
        } catch (Exception e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
        return insertado;
    }
    public boolean login(Usuario user) {
        boolean valido = false;
        String sql = "SELECT contrasenaH FROM usuarios WHERE usuario = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             ps.setString(1, user.getUsuario());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String hashBD = rs.getString("contrasenaH");
                    if (BCrypt.checkpw(user.getContrasena(), hashBD)) {
                        valido = true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error en el login DAO: " + e.getMessage());
        }
        return valido;
    }
=======
package dao;

import conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.Usuario;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioDAO {

    public boolean registrar(Usuario user) {
        boolean insertado = false;
        String sql = "INSERT INTO usuarios (usuario, contrasenaH, nombre, apellido_paterno, apellido_materno, direccion, email, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String contrasenaHasheada = BCrypt.hashpw(user.getContrasena(), BCrypt.gensalt());
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsuario());
            ps.setString(2, contrasenaHasheada);
            ps.setString(3, user.getNombre());
            ps.setString(4, user.getApellidoPaterno());
            ps.setString(5, user.getApellidoMaterno());
            ps.setString(6, user.getDireccion());
            ps.setString(7, user.getEmail()); 
            ps.setString(8, user.getTelefono());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                insertado = true;
            }
        } catch (Exception e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
        return insertado;
    }
    public boolean login(Usuario user) {
        boolean valido = false;
        String sql = "SELECT contrasenaH FROM usuarios WHERE usuario = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             ps.setString(1, user.getUsuario());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String hashBD = rs.getString("contrasenaH");
                    if (BCrypt.checkpw(user.getContrasena(), hashBD)) {
                        valido = true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error en el login DAO: " + e.getMessage());
        }
        return valido;
    }
>>>>>>> origin/master
}