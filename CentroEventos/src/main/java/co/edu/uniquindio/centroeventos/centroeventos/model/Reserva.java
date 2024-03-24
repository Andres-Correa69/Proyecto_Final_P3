package co.edu.uniquindio.centroeventos.centroeventos.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class Reserva {

    //declaracion de variables
    private String codigo;
    ArrayList<Usuario> listaUsuarioAsociado =new ArrayList<Usuario>();
    ArrayList<Evento> listaEventosAsociados = new ArrayList<Evento>();
    private LocalDate fechaSolicitud;
    TipoEstadoReserva EstadoReserva;

    //constructor

    public Reserva(){
    }

    //getters y setters


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
        return EstadoReserva;
    }

    public void setEstadoReserva(TipoEstadoReserva estadoReserva) {
        EstadoReserva = estadoReserva;
    }
}
