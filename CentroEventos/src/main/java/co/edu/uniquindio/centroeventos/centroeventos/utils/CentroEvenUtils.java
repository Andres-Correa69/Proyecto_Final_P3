package co.edu.uniquindio.centroeventos.centroeventos.utils;

import co.edu.uniquindio.centroeventos.centroeventos.model.CentroEventos;
import co.edu.uniquindio.centroeventos.centroeventos.model.Empleado;

public class CentroEvenUtils {
    public static CentroEventos inicializarDatos() {
        CentroEventos centroEventos = new CentroEventos();
        Empleado empleado = new Empleado();
        empleado.setId("12345");
        empleado.setNombre("juan");
        empleado.setCorreo("awdawd@gmail.com");
        empleado.setListaEventoAsigAsociados("12,13,14,15");
        centroEventos.getListaEmpleados().add(empleado);

        return centroEventos;
    }

}
