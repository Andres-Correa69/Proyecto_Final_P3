package co.edu.uniquindio.centroeventos.centroeventos.mapping.dto;

import co.edu.uniquindio.centroeventos.centroeventos.model.Reserva;
import co.edu.uniquindio.centroeventos.centroeventos.model.TipoEstadoReserva;

public record ReservaDto(

        String id,
        String idEvento,
        String idUsuario,
        String fechaSolicitud,
        TipoEstadoReserva estadoReserva

) {
}
