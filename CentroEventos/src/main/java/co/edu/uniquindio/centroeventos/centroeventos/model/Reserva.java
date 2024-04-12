package co.edu.uniquindio.centroeventos.centroeventos.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class Reserva {

    //declaracion de variables
    private String id;

    private String idEvento;
    private String idUsuario;
    ArrayList<Usuario> listaUsuarioAsociado =new ArrayList<Usuario>();
    ArrayList<Evento> listaEventosAsociados = new ArrayList<Evento>();
    private LocalDate fechaSolicitud;

    private  TipoEstadoReserva estadoReserva;


    //constructor

    public Reserva(){
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

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public TipoEstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(TipoEstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
