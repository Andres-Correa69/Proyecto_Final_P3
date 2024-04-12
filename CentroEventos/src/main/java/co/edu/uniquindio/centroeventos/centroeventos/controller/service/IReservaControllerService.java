package co.edu.uniquindio.centroeventos.centroeventos.controller.service;

import co.edu.uniquindio.centroeventos.centroeventos.controller.ReservaController;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.ReservaDto;

import java.util.List;

public interface IReservaControllerService {

    List<ReservaDto> obtenerReserva();
    boolean agregarReserva(ReservaDto reservaDto);
    boolean eliminarReserva(String id);
    boolean actualizarReserva(String idActual, ReservaDto reservaDto);
}
