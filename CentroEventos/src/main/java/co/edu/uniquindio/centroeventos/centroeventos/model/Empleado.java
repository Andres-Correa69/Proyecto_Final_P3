package co.edu.uniquindio.centroeventos.centroeventos.model;

import java.util.ArrayList;

public class Empleado extends Persona {

    //declaracion de variables
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
}
