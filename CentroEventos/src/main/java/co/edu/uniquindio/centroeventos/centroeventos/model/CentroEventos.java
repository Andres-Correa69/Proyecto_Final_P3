package co.edu.uniquindio.centroeventos.centroeventos.model;

import co.edu.uniquindio.centroeventos.centroeventos.exceptions.EmpleadoException;
import co.edu.uniquindio.centroeventos.centroeventos.exceptions.UsuarioException;
import co.edu.uniquindio.centroeventos.centroeventos.model.services.ICentroEventosService;

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
            getListaEmpleados().remove(usuario);
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

}