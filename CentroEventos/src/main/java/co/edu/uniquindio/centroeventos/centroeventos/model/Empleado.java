package co.edu.uniquindio.centroeventos.centroeventos.model;

import co.edu.uniquindio.centroeventos.centroeventos.exceptions.EmpleadoException;

import java.io.Serializable;
import java.util.ArrayList;

public class Empleado extends Persona implements Serializable {


    //declaracion de variables
    private static final long serialVersionUID = 1L;
    private Evento evento;

    ArrayList<Evento> listaEventosAsigAsociados = new ArrayList<Evento>();

    //constructor
    public Empleado() {

    }

    public Empleado(String id){
        super(id);
        this.setId(id);

    }




    //getters y setters
    public ArrayList<Evento> getListaEventosAsigAsociados() {
        return listaEventosAsigAsociados;
    }

    public void setListaEventosAsigAsociados(ArrayList<Evento> listaEventosAsigAsociados) {
        this.listaEventosAsigAsociados = listaEventosAsigAsociados;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void datosListaEventosAsig(Evento evento) throws EmpleadoException {
        try {
            // Validación de datos
            if (evento.getId() != null && !evento.getId().isEmpty()) {
                this.evento = evento;
            } else {
                throw new NullPointerException("La lista de eventos asignados es nula o vacía.");
            }
        } catch (NullPointerException e) {
            throw new EmpleadoException("Error: " + e.getMessage());
        }
    }
}
