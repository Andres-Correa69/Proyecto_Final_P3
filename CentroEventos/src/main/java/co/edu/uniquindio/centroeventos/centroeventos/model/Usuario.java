package co.edu.uniquindio.centroeventos.centroeventos.model;

import java.util.ArrayList;

public class Usuario extends Persona{

    //declaracion de variables

    private Reserva reserva;
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

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
