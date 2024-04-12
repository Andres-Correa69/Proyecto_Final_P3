package co.edu.uniquindio.centroeventos.centroeventos.controller;

import co.edu.uniquindio.centroeventos.centroeventos.controller.service.IReservaControllerService;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.ReservaDto;

import java.util.List;

public class ReservaController implements IReservaControllerService {

    ModelFactoryController modelFactoryController;
    public ReservaController() { modelFactoryController = ModelFactoryController.getInstance();}

    @Override
    public List<ReservaDto> obtenerReserva() {
        return modelFactoryController.obtenerReservas();
    }

    @Override
    public boolean agregarReserva(ReservaDto reservaDto) {
        return modelFactoryController.agregarReserva(reservaDto);
    }

    @Override
    public boolean eliminarReserva(String id) {
        return modelFactoryController.eliminarReservas(id);
    }

    @Override
    public boolean actualizarReserva(String idActual, ReservaDto reservaDto) {
        return modelFactoryController.actualizarReservas(idActual, reservaDto);
    }
}
