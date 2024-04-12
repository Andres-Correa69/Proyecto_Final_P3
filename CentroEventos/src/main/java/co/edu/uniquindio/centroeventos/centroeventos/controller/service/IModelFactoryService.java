package co.edu.uniquindio.centroeventos.centroeventos.controller.service;

import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EventoDto;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.ReservaDto;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.UsuarioDto;

import java.util.List;

public interface IModelFactoryService {

    //empleado service
    List<EmpleadoDto> obtenerEmpleados();
    boolean agregarEmpleado(EmpleadoDto empleadoDto);
    boolean eliminarEmpleado(String id);
    boolean actualizarEmpleado(String idActual, EmpleadoDto empleadoDto);

    //usuario service

    List<UsuarioDto> obtenerUsuarios();
    boolean agregarUsuario(UsuarioDto usuarioDto);
    boolean eliminarUsuarios(String id);
    boolean actualizarUsuarios(String idActual, UsuarioDto usuarioDto);

    //evento service

    List<EventoDto> obtenerEventos();
    boolean agregarEvento(EventoDto eventoDto);
    boolean eliminarEventos(String id);
    boolean actualizarEventos(String idActual, EventoDto eventoDto);

    //reserva Service

    List<ReservaDto> obtenerReservas();
    boolean agregarReserva(ReservaDto reservaDto);
    boolean eliminarReservas(String id);
    boolean actualizarReservas(String idActual, ReservaDto reservaDto);

}
