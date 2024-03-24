package co.edu.uniquindio.centroeventos.centroeventos.controller.service;

import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EmpleadoDto;

import java.util.List;

public interface IEmpleadoControllerService {

    List<EmpleadoDto> obtenerEmpleados();
    boolean agregarEmpleado(EmpleadoDto empleadoDto);
    boolean eliminarEmpleado(String id);
    boolean actualizarEmpleado(String idActual, EmpleadoDto empleadoDto);
}
