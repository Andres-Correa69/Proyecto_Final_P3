package co.edu.uniquindio.centroeventos.centroeventos.model;

import co.edu.uniquindio.centroeventos.centroeventos.exceptions.EmpleadoException;

import java.util.ArrayList;

public class Empleado extends Persona {

    //declaracion de variables
    private String listaEventoAsigAsociados;

    ArrayList<Evento> listaEventosAsigAsociados = new ArrayList<Evento>();

    //constructor
    public Empleado() {
    }


    //getters y setters
    public ArrayList<Evento> getListaEventosAsigAsociados() {
        return listaEventosAsigAsociados;
    }

    public void setListaEventosAsigAsociados(ArrayList<Evento> listaEventosAsigAsociados) {
        this.listaEventosAsigAsociados = listaEventosAsigAsociados;
    }

    public String getListaEventoAsigAsociados() {
        return listaEventoAsigAsociados;
    }

    public void setListaEventoAsigAsociados(String listaEventoAsigAsociados) {
        this.listaEventoAsigAsociados = listaEventoAsigAsociados;
    }

    public void datosListaEventosAsig(String listaEventoAsigAsociados) throws EmpleadoException {
        try {
            // Validación de datos
            if (listaEventoAsigAsociados != null && !listaEventoAsigAsociados.isEmpty()) {
                this.listaEventoAsigAsociados = listaEventoAsigAsociados;
            } else {
                throw new NullPointerException("La lista de eventos asignados es nula o vacía.");
            }
        } catch (NullPointerException e) {
            throw new EmpleadoException("Error: " + e.getMessage());
        }
    }
}
