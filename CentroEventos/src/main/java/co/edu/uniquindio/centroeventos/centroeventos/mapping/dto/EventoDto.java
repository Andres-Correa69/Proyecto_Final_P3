package co.edu.uniquindio.centroeventos.centroeventos.mapping.dto;

import java.time.LocalDate;

public record EventoDto(

        String id,
        String nombre,
        String descripcion,
        String fecha,
        String capacidadMax,
        String idEmpleadoEncargado,
        String idReserva
) {
}
