package co.edu.uniquindio.centroeventos.centroeventos.model.services;

import co.edu.uniquindio.centroeventos.centroeventos.exceptions.EmpleadoException;
import co.edu.uniquindio.centroeventos.centroeventos.model.Empleado;

import java.util.ArrayList;

public interface ICentroEventosService {

    public Empleado crearEmpleado(String id, String nombre, String correo)throws EmpleadoException;
    public Boolean eliminarEmpleado(String  id)throws EmpleadoException;
    boolean actualizarEmpleado(String idActual, Empleado empleado)throws EmpleadoException;
    public boolean verificarEmpleadoExiste(String id) throws EmpleadoException;
    public Empleado obtenerEmpleado(String id);
    public ArrayList<Empleado> obtenerEmpleados();
}
