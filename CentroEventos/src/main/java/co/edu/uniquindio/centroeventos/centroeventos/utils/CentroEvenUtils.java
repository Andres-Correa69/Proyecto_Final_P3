package co.edu.uniquindio.centroeventos.centroeventos.utils;

import co.edu.uniquindio.centroeventos.centroeventos.model.*;

import java.time.LocalDate;

public class CentroEvenUtils {
    public static CentroEventos inicializarDatos() {

        //empleados utils
        CentroEventos centroEventos = new CentroEventos();
        Empleado empleado = new Empleado();
        empleado.setId("12345");
        empleado.setNombre("juan");
        empleado.setCorreo("awdawd@gmail.com");
        centroEventos.getListaEmpleados().add(empleado);


        //eventos utils
        Evento evento = new Evento();
        evento.setId("10");
        evento.setNombre("Concierto");
        evento.setDescripcion("bandas de rock");
        evento.setFecha(LocalDate.now().toString());
        evento.setCapacidadMax(1000);
        evento.setEmpleado(empleado);

        centroEventos.getListaEventos().add(evento);
        //reserva utils

        Reserva reserva = new Reserva();
        reserva.setId("4566");
        reserva.setEvento(evento);
        reserva.setFechaSolicitud(LocalDate.now().toString());
        reserva.setEstadoReserva(TipoEstadoReserva.PENDIENTE);
        centroEventos.getListaReservas().add(reserva);

        //usuarios utils

        Usuario usuario = new Usuario();
        usuario.setId("12345");
        usuario.setNombre("alberto");
        usuario.setCorreo("alberto494@gmail.com");
        usuario.setReserva(reserva);
        centroEventos.getListaUsuarios().add(usuario);

        //asigno la reserva al evento
        evento.setReserva(reserva);
        //asigno el evento al empleado
        empleado.setEvento(evento);

    // Paso 4: Asignar el usuario a la reserva
        reserva.setUsuario(usuario);







        return centroEventos;

    }

}
