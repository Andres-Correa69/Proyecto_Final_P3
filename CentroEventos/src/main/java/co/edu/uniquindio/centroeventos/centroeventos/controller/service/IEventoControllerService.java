package co.edu.uniquindio.centroeventos.centroeventos.controller.service;

import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EventoDto;

import java.util.List;

public interface IEventoControllerService {

    List<EventoDto> obtenerEventos();
    boolean agregarEvento(EventoDto eventoDto);
    boolean eliminarEvento(String id);
    boolean actualizarEvento(String idActual, EventoDto eventoDto);
}
