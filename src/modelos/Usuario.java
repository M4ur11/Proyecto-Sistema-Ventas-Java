package modelos;

public class Usuario {
    private String usuario;
    private String contrasena;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private String email;
    private String telefono;

    
    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    
    public Usuario(String usuario, String contrasena, String nombre, String apellidoPaterno, String apellidoMaterno, String direccion, String email, String telefono) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    public String getUsuario() { return usuario; }
    public String getContrasena() { return contrasena; }
    public String getNombre() { return nombre; }
    public String getApellidoPaterno() { return apellidoPaterno; }
    public String getApellidoMaterno() { return apellidoMaterno; }
    public String getDireccion() { return direccion; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
}