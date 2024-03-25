package co.edu.uniquindio.centroeventos.centroeventos.model;

import java.util.ArrayList;

public class Usuario extends Persona{

    //declaracion de variables

    private String idReservas;
    ArrayList<Reserva> listaReservasAsociado = new ArrayList<Reserva>();


    //contructor
    public Usuario (){

    }


    //getters y setters


    public ArrayList<Reserva> getListaReservasAsociado() {
        return listaReservasAsociado;
    }

    public void setListaReservasAsociado(ArrayList<Reserva> listaReservasAsociado) {
        this.listaReservasAsociado = listaReservasAsociado;
    }

    public String getIdReservas() {
        return idReservas;
    }

    public void setIdReservas(String idReservas) {
        this.idReservas = idReservas;
    }
}
