package co.edu.uniquindio.centroeventos.centroeventos.model.services;

import co.edu.uniquindio.centroeventos.centroeventos.exceptions.EmpleadoException;
import co.edu.uniquindio.centroeventos.centroeventos.exceptions.EventoException;
import co.edu.uniquindio.centroeventos.centroeventos.exceptions.ReservaException;
import co.edu.uniquindio.centroeventos.centroeventos.exceptions.UsuarioException;
import co.edu.uniquindio.centroeventos.centroeventos.model.Empleado;
import co.edu.uniquindio.centroeventos.centroeventos.model.Evento;
import co.edu.uniquindio.centroeventos.centroeventos.model.Reserva;
import co.edu.uniquindio.centroeventos.centroeventos.model.Usuario;
import javafx.event.Event;

import java.util.ArrayList;

public interface ICentroEventosService {

    //empleados service

    public Empleado crearEmpleado(String id, String nombre, String correo)throws EmpleadoException;
    public Boolean eliminarEmpleado(String  id)throws EmpleadoException;
    boolean actualizarEmpleado(String idActual, Empleado empleado)throws EmpleadoException;
    public boolean verificarEmpleadoExiste(String id) throws EmpleadoException;
    public Empleado obtenerEmpleado(String id);
    public ArrayList<Empleado> obtenerEmpleados();

    //usuarios service

    public Usuario crearUsuario(String id, String nombre, String correo)throws UsuarioException;
    public Boolean eliminarUsuario(String  id)throws UsuarioException;
    boolean actualizarUsuario(String idActual, Usuario usuario)throws UsuarioException;
    public boolean verificarUsuarioExiste(String id)throws UsuarioException;
    public Usuario obtenerUsuario(String id);
    public ArrayList<Usuario> obtenerUsuarios();

    // eventos service

    public Evento crearEvento(String id, String nombre, String descripcion)throws EventoException;
    public Boolean eliminarEvento(String id) throws EventoException;
    boolean actualizarEvento(String idActual, Evento evento)throws EventoException;
    public boolean verificarEventoExiste(String id)throws EventoException;
    public Evento obtenerEvento(String id);
    public ArrayList<Evento> obtenerEventos();


    // reservas service

    public Reserva crearReserva(String id)throws ReservaException;
    public Boolean eliminarReserva(String id) throws ReservaException;
    boolean actualizarReserva(String idActual, Reserva reserva)throws ReservaException;
    public boolean verificarReservaExiste(String id)throws ReservaException;
    public Reserva obtenerReserva(String id);
    public ArrayList<Reserva> obtenerReserva();


}
