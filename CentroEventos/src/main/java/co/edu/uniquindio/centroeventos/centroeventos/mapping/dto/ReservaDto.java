package co.edu.uniquindio.centroeventos.centroeventos.mapping.dto;

import co.edu.uniquindio.centroeventos.centroeventos.model.Evento;
import co.edu.uniquindio.centroeventos.centroeventos.model.Reserva;
import co.edu.uniquindio.centroeventos.centroeventos.model.TipoEstadoReserva;
import co.edu.uniquindio.centroeventos.centroeventos.model.Usuario;

public record ReservaDto(

        String id,
        Usuario usuario,
        Evento evento,

        String fechaSolicitud,
        TipoEstadoReserva estadoReserva

) {
}
