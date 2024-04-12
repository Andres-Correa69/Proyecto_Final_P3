package co.edu.uniquindio.centroeventos.centroeventos.model;

import co.edu.uniquindio.centroeventos.centroeventos.exceptions.EmpleadoException;
import co.edu.uniquindio.centroeventos.centroeventos.exceptions.EventoException;
import co.edu.uniquindio.centroeventos.centroeventos.exceptions.ReservaException;
import co.edu.uniquindio.centroeventos.centroeventos.exceptions.UsuarioException;
import co.edu.uniquindio.centroeventos.centroeventos.model.services.ICentroEventosService;

import java.time.LocalDate;
import java.util.ArrayList;

public class CentroEventos implements ICentroEventosService {

    //declaracion de variables
    private static final long serialVersionUID = 1L;
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    ArrayList<Reserva> listaReservas = new ArrayList<>();
    ArrayList<Evento> listaEventos = new ArrayList<>();

    //constructor
    public CentroEventos() {

    }

    //getter y setters

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public ArrayList<Evento> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(ArrayList<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }


    //metodos implementados

    @Override
    public Empleado crearEmpleado(String id, String nombre, String correo) throws EmpleadoException {
        Empleado nuevoEmpleado = null;
        boolean empleadoExiste = verificarEmpleadoExiste(id);
        if (empleadoExiste) {
            throw new EmpleadoException("El empleado con ID: " + id + " ya existe.");
        } else {
            nuevoEmpleado = new Empleado();
            nuevoEmpleado.setNombre(nombre);
            nuevoEmpleado.setId(id);
            nuevoEmpleado.setCorreo(correo);
            getListaEmpleados().add(nuevoEmpleado);

        }
        return nuevoEmpleado;
    }

    public void agregarEmpleado(Empleado nuevoEmpleado) throws EmpleadoException {
        getListaEmpleados().add(nuevoEmpleado);
    }

    @Override
    public boolean actualizarEmpleado(String idActual, Empleado empleado) throws EmpleadoException {
        Empleado empleadoActual = obtenerEmpleado(idActual);
        if (empleadoActual == null) {
            throw new EmpleadoException("El empleado a actualizar no existe");
        } else {
            empleadoActual.setNombre(empleado.getNombre());
            empleadoActual.setId(empleado.getId());
            empleadoActual.setCorreo(empleado.getCorreo());
            return true;
        }

    }

    @Override
    public Boolean eliminarEmpleado(String id) throws EmpleadoException {
        Empleado empleado = null;
        boolean flagExiste = false;
        empleado = obtenerEmpleado(id);
        if (empleado == null)
            throw new EmpleadoException("El empleado a eliminar no existe");
        else {
            getListaEmpleados().remove(empleado);
            flagExiste = true;
        }
        return flagExiste;
    }


    @Override
    public boolean verificarEmpleadoExiste(String id) throws EmpleadoException {
        if (empleadoExiste(id)) {
            throw new EmpleadoException("El empleado con cedula: " + id + " ya existe");
        } else {
            return false;
        }

    }

    @Override
    public Empleado obtenerEmpleado(String id) {
        Empleado empleadoEncontrado = null;
        for (Empleado empleado : getListaEmpleados()) {
            if (empleado.getId().equalsIgnoreCase(id)) {
                empleadoEncontrado = empleado;
                break;
            }
        }
        return empleadoEncontrado;
    }

    @Override
    public ArrayList<Empleado> obtenerEmpleados() {
        return getListaEmpleados();
    }


    public boolean empleadoExiste(String id) {
        boolean empleadoEncontrado = false;
        for (Empleado empleado : getListaEmpleados()) {
            if (empleado.getId().equalsIgnoreCase(id)) {
                empleadoEncontrado = true;
                break;
            }
        }
        return empleadoEncontrado;
    }

    // creacion usuarios centro eventos

    @Override
    public Usuario crearUsuario(String id, String nombre, String correo)throws UsuarioException {
        Usuario nuevoUsuario = null;
        boolean usuarioExiste = verificarUsuarioExiste(id);
        if (usuarioExiste) {
            throw new UsuarioException("El Usuario con ID: " + id + " ya existe.");
        } else {
            nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(nombre);
            nuevoUsuario.setId(id);
            nuevoUsuario.setCorreo(correo);
            getListaUsuarios().add(nuevoUsuario);

        }
        return nuevoUsuario;
    }

    public void agregarUsuario(Usuario nuevoUsuario) throws UsuarioException {
        getListaUsuarios().add(nuevoUsuario);
    }

    @Override
    public boolean actualizarUsuario(String idActual, Usuario usuario) throws UsuarioException {
        Usuario usuarioActual = obtenerUsuario(idActual);
        if (usuarioActual == null) {
            throw new UsuarioException("El Usuario a actualizar no existe");
        } else {
            usuarioActual.setNombre(usuario.getNombre());
            usuarioActual.setId(usuario.getId());
            usuarioActual.setCorreo(usuario.getCorreo());
            return true;
        }
    }


    @Override
    public Boolean eliminarUsuario(String id)throws UsuarioException {
        Usuario usuario = null;
        boolean flagExiste = false;
        usuario = obtenerUsuario(id);
        if (usuario == null)
            throw new UsuarioException("El Usuario a eliminar no existe");
        else {
            getListaUsuarios().remove(usuario);
            flagExiste = true;
        }
        return flagExiste;
    }



    @Override
    public boolean verificarUsuarioExiste(String id) throws UsuarioException {
        if (usuarioExiste(id)) {
            throw new UsuarioException("El usuario con cedula: " + id + " ya existe");
        } else {
            return false;
        }
    }

    @Override
    public Usuario obtenerUsuario(String id) {
        Usuario usuarioEncontrado = null;
        for (Usuario usuario : getListaUsuarios()) {
            if (usuario.getId().equalsIgnoreCase(id)) {
                usuarioEncontrado = usuario;
                break;
            }
        }
        return usuarioEncontrado;
    }

    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        return getListaUsuarios();
    }

    public boolean usuarioExiste(String id) {
        boolean usuarioEncontrado = false;
        for (Usuario usuario : getListaUsuarios()) {
            if (usuario.getId().equalsIgnoreCase(id)) {
                usuarioEncontrado = true;
                break;
            }
        }
        return usuarioEncontrado;
    }

    // creacion Eventos centro eventos


    @Override
    public Evento crearEvento(String id, String nombre, String descripcion) throws EventoException {
        Evento nuevoEvento = null;
        boolean eventoExiste = verificarEventoExiste(id);
        if (eventoExiste) {
            throw new EventoException("El Evento con ID: " + id + " ya existe.");
        } else {
            nuevoEvento = new Evento();
            nuevoEvento.setNombre(nombre);
            nuevoEvento.setId(id);
            nuevoEvento.setDescripcion(descripcion);
            getListaEventos().add(nuevoEvento);

        }
        return nuevoEvento;
    }

    public void agregarEvento(Evento nuevoEvento) throws EventoException {
        getListaEventos().add(nuevoEvento);
    }

    @Override
    public boolean actualizarEvento(String idActual, Evento evento) throws EventoException {
        Evento eventoActual = obtenerEvento(idActual);
        if (eventoActual == null) {
            throw new EventoException("El Evento a actualizar no existe");
        } else {
            eventoActual.setNombre(evento.getNombre());
            eventoActual.setId(evento.getId());
            eventoActual.setDescripcion(evento.getDescripcion());
            return true;
        }
    }
    @Override
    public Boolean eliminarEvento(String id) throws EventoException {
        Evento evento = null;
        boolean flagExiste = false;
        evento = obtenerEvento(id);
        if (evento == null)
            throw new EventoException("El Evento a eliminar no existe");
        else {
            getListaEventos().remove(evento);
            flagExiste = true;
        }
        return flagExiste;
    }



    @Override
    public boolean verificarEventoExiste(String id) throws EventoException {
        if (eventoExiste(id)) {
            throw new EventoException("El evento con ID: " + id + " ya existe");
        } else {
            return false;
        }
    }

    @Override
    public Evento obtenerEvento(String id) {
        Evento eventoEncontrado = null;
        for (Evento evento : getListaEventos()) {
            if (evento.getId().equalsIgnoreCase(id)) {
                eventoEncontrado = evento;
                break;
            }
        }
        return eventoEncontrado;
    }

    @Override
    public ArrayList<Evento> obtenerEventos() {
        return getListaEventos();
    }

    public boolean eventoExiste(String id) {
        boolean eventoEncontado = false;
        for (Evento evento : getListaEventos()) {
            if (evento.getId().equalsIgnoreCase(id)) {
                eventoEncontado = true;
                break;
            }
        }
        return eventoEncontado;
    }

    // creacion Reservas centro eventos


    @Override
    public Reserva crearReserva(String id) throws ReservaException {
        Reserva nuevaReserva = null;
        boolean reservaExiste = verificarReservaExiste(id);
        if (reservaExiste) {
            throw new ReservaException("la reserva con ID: " + id + " ya existe.");
        } else {
            nuevaReserva = new Reserva();
            nuevaReserva.setId(id);
            getListaReservas().add(nuevaReserva);

        }
        return nuevaReserva;
    }

    public void agregarReserva(Reserva nuevaReserva) throws ReservaException {
        getListaReservas().add(nuevaReserva);
    }

    @Override
    public boolean actualizarReserva(String idActual, Reserva reserva) throws ReservaException {
        Reserva reservaActual = obtenerReserva(idActual);
        if (reservaActual == null) {
            throw new ReservaException("La reserva a actualizar no existe");
        } else {
            reservaActual.setId(reserva.getId());
            return true;
        }
    }

    @Override
    public Boolean eliminarReserva(String id) throws ReservaException {
        Reserva reserva = null;
        boolean flagExiste = false;
        reserva = obtenerReserva(id);
        if (reserva == null)
            throw new ReservaException("La reserva a eliminar no existe");
        else {
            getListaReservas().remove(reserva);
            flagExiste = true;
        }
        return flagExiste;
    }



    @Override
    public boolean verificarReservaExiste(String id) throws ReservaException {
        if (reservaExiste(id)) {
            throw new ReservaException("La Reserva con ID: " + id + " ya existe");
        } else {
            return false;
        }
    }

    @Override
    public Reserva obtenerReserva(String id) {
        Reserva reservaEncontrada = null;
        for (Reserva reserva : getListaReservas()) {
            if (reserva.getId().equalsIgnoreCase(id)) {
                reservaEncontrada = reserva;
                break;
            }
        }
        return reservaEncontrada;
    }

    @Override
    public ArrayList<Reserva> obtenerReserva() {
        return getListaReservas();
    }

    public boolean reservaExiste(String id) {
        boolean reservaEncontrada = false;
        for (Reserva reserva : getListaReservas()) {
            if (reserva.getId().equalsIgnoreCase(id)) {
                reservaEncontrada = true;
                break;
            }
        }
        return reservaEncontrada;
    }
}