package co.edu.uniquindio.centroeventos.centroeventos.model;

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
}
