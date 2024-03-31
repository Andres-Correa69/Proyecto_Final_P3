package co.edu.uniquindio.centroeventos.centroeventos.utils;

import co.edu.uniquindio.centroeventos.centroeventos.model.CentroEventos;
import co.edu.uniquindio.centroeventos.centroeventos.model.Empleado;
import co.edu.uniquindio.centroeventos.centroeventos.model.Evento;
import co.edu.uniquindio.centroeventos.centroeventos.model.Usuario;

import java.time.LocalDate;

public class CentroEvenUtils {
    public static CentroEventos inicializarDatos() {

        //empleados utils
        CentroEventos centroEventos = new CentroEventos();
        Empleado empleado = new Empleado();
        empleado.setId("12345");
        empleado.setNombre("juan");
        empleado.setCorreo("awdawd@gmail.com");
        empleado.setListaEventoAsigAsociados("12,13,14,15");
        centroEventos.getListaEmpleados().add(empleado);

        //usuarios utils

        Usuario usuario = new Usuario();
        usuario.setId("12345");
        usuario.setNombre("alberto");
        usuario.setCorreo("alberto494@gmail.com");
        usuario.setIdReservas("65,23,45");
        centroEventos.getListaUsuarios().add(usuario);

        //eventos utils
        Evento evento = new Evento();
        evento.setId("10");
        evento.setNombre("Concierto");
        evento.setDescripcion("bandas de rock");
        evento.setFecha(LocalDate.now());
        evento.setCapacidadMax(1000);
        evento.setIdEmpleadoEncargado("1133");
        evento.setIdReserva("30");
        centroEventos.getListaEventos().add(evento);


        return centroEventos;


    }

}
