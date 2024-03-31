package co.edu.uniquindio.centroeventos.centroeventos.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Evento {

    //declaracion variables

    private String id;
    private String nombre;
    private String descripcion;
    private LocalDate fecha;
    private Integer capacidadMax;
    private String idEmpleadoEncargado;
    private String idReserva;

    ArrayList<Empleado> listaEmpleadosEnAsociado = new ArrayList<Empleado>();
    ArrayList<Reserva> listaReservasAsociadas = new ArrayList<Reserva>();

    //constructor
    public Evento() {
    }

    //getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(Integer capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public String getIdEmpleadoEncargado() {
        return idEmpleadoEncargado;
    }

    public void setIdEmpleadoEncargado(String idEmpleadoEncargado) {
        this.idEmpleadoEncargado = idEmpleadoEncargado;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public ArrayList<Empleado> getListaEmpleadosEnAsociado() {
        return listaEmpleadosEnAsociado;
    }

    public void setListaEmpleadosEnAsociado(ArrayList<Empleado> listaEmpleadosEnAsociado) {
        this.listaEmpleadosEnAsociado = listaEmpleadosEnAsociado;
    }

    public ArrayList<Reserva> getListaReservasAsociadas() {
        return listaReservasAsociadas;
    }

    public void setListaReservasAsociadas(ArrayList<Reserva> listaReservasAsociadas) {
        this.listaReservasAsociadas = listaReservasAsociadas;
    }
}
