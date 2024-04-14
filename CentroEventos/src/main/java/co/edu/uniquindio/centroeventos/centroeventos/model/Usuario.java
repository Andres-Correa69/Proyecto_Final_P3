package co.edu.uniquindio.centroeventos.centroeventos.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario extends Persona implements Serializable {

    //declaracion de variables

    private static final long serialVersionUID = 1L;
    private Reserva reserva;
    ArrayList<Reserva> listaReservasAsociado = new ArrayList<Reserva>();


    //contructor
    public Usuario (){}


    public Usuario(String id) {
        super(id);
        this.setId(id);

    }
    public Usuario(Reserva reserva){
        this.reserva = reserva;
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
