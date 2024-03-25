package co.edu.uniquindio.centroeventos.centroeventos.controller;

import co.edu.uniquindio.centroeventos.centroeventos.controller.service.IUsuarioControllerService;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.UsuarioDto;

import java.util.List;

public class UsuarioController implements IUsuarioControllerService {
    ModelFactoryController modelFactoryController;
    public UsuarioController(){ modelFactoryController = ModelFactoryController.getInstance();}

    @Override
    public List<UsuarioDto> obtenerUsuarios() {
        return modelFactoryController.obtenerUsuarios();
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        return modelFactoryController.agregarUsuario(usuarioDto);
    }

    @Override
    public boolean eliminarUsuario(String id) {
        return modelFactoryController.eliminarUsuarios(id);
    }

    @Override
    public boolean actualizarUsuario(String idActual, UsuarioDto usuarioDto) {
        return modelFactoryController.actualizarUsuarios(idActual, usuarioDto);
    }
}
