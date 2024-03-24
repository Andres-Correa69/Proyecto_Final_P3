package co.edu.uniquindio.centroeventos.centroeventos.controller;

import co.edu.uniquindio.centroeventos.centroeventos.controller.service.IEmpleadoControllerService;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EmpleadoDto;

import java.util.List;

public class EmpleadoController implements IEmpleadoControllerService {

    ModelFactoryController modelFactoryController;
    public EmpleadoController(){ modelFactoryController = ModelFactoryController.getInstance();}
    @Override
    public List<EmpleadoDto> obtenerEmpleados() {
        return modelFactoryController.obtenerEmpleados();
    }

    @Override
    public boolean agregarEmpleado(EmpleadoDto empleadoDto) {
        return modelFactoryController.agregarEmpleado(empleadoDto);
    }

    @Override
    public boolean eliminarEmpleado(String id) {
        return modelFactoryController.eliminarEmpleado(id);
    }

    @Override
    public boolean actualizarEmpleado(String idActual, EmpleadoDto empleadoDto) {
        return modelFactoryController.actualizarEmpleado(idActual,empleadoDto);
    }
}
