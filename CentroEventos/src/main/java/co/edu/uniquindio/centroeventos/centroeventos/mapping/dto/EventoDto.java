package co.edu.uniquindio.centroeventos.centroeventos.mapping.dto;

import co.edu.uniquindio.centroeventos.centroeventos.model.Empleado;
import co.edu.uniquindio.centroeventos.centroeventos.model.Reserva;

import java.time.LocalDate;

public record EventoDto(

        String id,
        String nombre,
        String descripcion,
        String fecha,
        String capacidadMax,
        Empleado empleado,
        Reserva reserva

) {
}
