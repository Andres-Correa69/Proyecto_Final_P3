package co.edu.uniquindio.centroeventos.centroeventos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva implements Serializable {

    //declaracion de variables
    private static final long serialVersionUID = 1L;
    private String id;

    private Evento evento;

    private Usuario usuario;


    ArrayList<Usuario> listaUsuarioAsociado =new ArrayList<Usuario>();
    ArrayList<Evento> listaEventosAsociados = new ArrayList<Evento>();
    private String fechaSolicitud;

    private  TipoEstadoReserva estadoReserva;


    //constructor

    public Reserva(){
    }

    public Reserva(String id) {
        this.id = id;
    }
    //getters y setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Usuario> getListaUsuarioAsociado() {
        return listaUsuarioAsociado;
    }

    public void setListaUsuarioAsociado(ArrayList<Usuario> listaUsuarioAsociado) {
        this.listaUsuarioAsociado = listaUsuarioAsociado;
    }

    public ArrayList<Evento> getListaEventosAsociados() {
        return listaEventosAsociados;
    }

    public void setListaEventosAsociados(ArrayList<Evento> listaEventosAsociados) {
        this.listaEventosAsociados = listaEventosAsociados;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public TipoEstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(TipoEstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }


    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
