package co.edu.uniquindio.centroeventos.centroeventos.model;

public abstract class Persona {

    //declaracion de variables

    private String id;
    private String nombre;
    private String correo;

    //contructor
    public Persona(){
    }


    //declaracion getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
