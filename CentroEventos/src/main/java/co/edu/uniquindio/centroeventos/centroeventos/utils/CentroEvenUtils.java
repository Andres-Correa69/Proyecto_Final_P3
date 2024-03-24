package co.edu.uniquindio.centroeventos.centroeventos.utils;

import co.edu.uniquindio.centroeventos.centroeventos.model.CentroEventos;
import co.edu.uniquindio.centroeventos.centroeventos.model.Empleado;

public class CentroEvenUtils {
    public static CentroEventos inicializarDatos() {
        CentroEventos centroEventos = new CentroEventos();
        Empleado empleado = new Empleado();
        empleado.setNombre("juan");
        empleado.setId("12345");
        empleado.setCorreo("awdawd@gmail.com");
        centroEventos.getListaEmpleados().add(empleado);

        return centroEventos;
    }

}
