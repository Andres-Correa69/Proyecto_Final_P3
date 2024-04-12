package co.edu.uniquindio.centroeventos.centroeventos.mapping.dto;

import co.edu.uniquindio.centroeventos.centroeventos.model.Reserva;

public record UsuarioDto(

        String id,
        String nombre,
        String correo,
        Reserva reserva
) {

}
