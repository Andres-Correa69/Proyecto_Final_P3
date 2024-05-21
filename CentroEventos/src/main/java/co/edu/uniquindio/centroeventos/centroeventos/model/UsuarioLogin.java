package co.edu.uniquindio.centroeventos.centroeventos.model;

public class UsuarioLogin {

    private String usuario;
    private String contrasena;
    private String tipo;

    public UsuarioLogin(){
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
