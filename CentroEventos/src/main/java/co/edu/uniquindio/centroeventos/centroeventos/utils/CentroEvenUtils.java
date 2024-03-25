package co.edu.uniquindio.centroeventos.centroeventos.utils;

import co.edu.uniquindio.centroeventos.centroeventos.model.CentroEventos;
import co.edu.uniquindio.centroeventos.centroeventos.model.Empleado;
import co.edu.uniquindio.centroeventos.centroeventos.model.Usuario;

public class CentroEvenUtils {
    public static CentroEventos inicializarDatos() {
        CentroEventos centroEventos = new CentroEventos();
        Empleado empleado = new Empleado();
        empleado.setId("12345");
        empleado.setNombre("juan");
        empleado.setCorreo("awdawd@gmail.com");
        empleado.setListaEventoAsigAsociados("12,13,14,15");
        centroEventos.getListaEmpleados().add(empleado);

        Usuario usuario = new Usuario();
        usuario.setId("12345");
        usuario.setNombre("alberto");
        usuario.setCorreo("alberto494@gmail.com");
        usuario.setIdReservas("65,23,45");
        centroEventos.getListaUsuarios().add(usuario);

        return centroEventos;


    }

}
