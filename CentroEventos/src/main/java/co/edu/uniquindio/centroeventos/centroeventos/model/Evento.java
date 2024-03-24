package co.edu.uniquindio.centroeventos.centroeventos.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Evento {

    //declaracion variables

    private String Codigo;
    private String nombre;
    private String descripcion;
    private LocalDate fecha;
    private Integer capacidadMax;
    ArrayList<Empleado> listaEmpleadosEnAsociado = new ArrayList<Empleado>();
    ArrayList<Reserva> listaReservasAsociadas = new ArrayList<Reserva>();

    //constructor
    public Evento() {
    }

    //getters y setters

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
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
