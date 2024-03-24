package co.edu.uniquindio.centroeventos.centroeventos.controller;

import co.edu.uniquindio.centroeventos.centroeventos.controller.service.IModelFactoryService;
import co.edu.uniquindio.centroeventos.centroeventos.exceptions.EmpleadoException;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.mappers.CentroEventosMapper;
import co.edu.uniquindio.centroeventos.centroeventos.model.CentroEventos;
import co.edu.uniquindio.centroeventos.centroeventos.model.Empleado;
import co.edu.uniquindio.centroeventos.centroeventos.utils.CentroEvenUtils;

import java.util.List;

public class ModelFactoryController implements IModelFactoryService {

    CentroEventos centroEventos;

    CentroEventosMapper mapper = CentroEventosMapper.INSTANCE;

    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez

    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    //Metodo para btener la instancia de nuestra clase

    public static ModelFactoryController getInstance() {return SingletonHolder.eINSTANCE;}

    public ModelFactoryController(){
        System.out.println("invocacion clase singleton");
        cargarDatosBase();
    }
    private void cargarDatosBase() {
        centroEventos = CentroEvenUtils.inicializarDatos();
    }

    public CentroEventos getCentroEventos() {return centroEventos;}

    public void setCentroEventos(CentroEventos centroEventos) {this.centroEventos = centroEventos;}

    @Override
    public List<EmpleadoDto> obtenerEmpleados() {
        return mapper.getEmpleadosDto(centroEventos.getListaEmpleados());
    }

    @Override
    public boolean agregarEmpleado(EmpleadoDto empleadoDto) {
        try{
            if (!centroEventos.verificarEmpleadoExiste(empleadoDto.id())){
                Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
                getCentroEventos().agregarEmpleado(empleado);

            }
            return true;
        }catch (EmpleadoException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarEmpleado(String id) {
        boolean flagExiste = false;
        try{
            flagExiste = getCentroEventos().eliminarEmpleado(id);
        }catch (EmpleadoException e){
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarEmpleado(String idActual, EmpleadoDto empleadoDto) {
        try{
            Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
            getCentroEventos().actualizarEmpleado(idActual, empleado);
            return true;
        }catch (EmpleadoException e){
            e.printStackTrace();
            return false;
        }

    }
}
