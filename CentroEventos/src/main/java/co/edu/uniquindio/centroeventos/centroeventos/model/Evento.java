package co.edu.uniquindio.centroeventos.centroeventos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Evento implements Serializable {

    //declaracion variables
    private static final long serialVersionUID = 1L;

    private String id;
    private String nombre;
    private String descripcion;
    private String fecha;
    private Integer capacidadMax;
    private Empleado empleado;
    private Reserva reserva;

    ArrayList<Empleado> listaEmpleadosEnAsociado = new ArrayList<Empleado>();
    ArrayList<Reserva> listaReservasAsociadas = new ArrayList<Reserva>();

    //constructor

    public Evento(){

    }
    public Evento(String id) {
        this.id = id;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(Integer capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
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
