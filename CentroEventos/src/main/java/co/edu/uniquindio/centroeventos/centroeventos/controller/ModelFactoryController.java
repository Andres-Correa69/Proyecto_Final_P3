package co.edu.uniquindio.centroeventos.centroeventos.controller;

import co.edu.uniquindio.centroeventos.centroeventos.controller.service.IModelFactoryService;
import co.edu.uniquindio.centroeventos.centroeventos.exceptions.EmpleadoException;
import co.edu.uniquindio.centroeventos.centroeventos.exceptions.EventoException;
import co.edu.uniquindio.centroeventos.centroeventos.exceptions.ReservaException;
import co.edu.uniquindio.centroeventos.centroeventos.exceptions.UsuarioException;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.EventoDto;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.ReservaDto;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.dto.UsuarioDto;
import co.edu.uniquindio.centroeventos.centroeventos.model.*;
import co.edu.uniquindio.centroeventos.centroeventos.utils.CentroEvenUtils;
import co.edu.uniquindio.centroeventos.centroeventos.mapping.mappers.CentroEvenMapper;


import java.util.List;

public class ModelFactoryController implements IModelFactoryService {

    CentroEventos centroEventos;

    CentroEvenMapper mapper = CentroEvenMapper.INSTANCE;

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

    //EMPLEADO

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


    //USUARIO
    @Override
    public List<UsuarioDto> obtenerUsuarios() {
        return mapper.getUsuarioDto(centroEventos.getListaUsuarios());
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        try{
            if (!centroEventos.verificarUsuarioExiste(usuarioDto.id())){
                Usuario usuario = mapper.usuarioDtoToUsuario(usuarioDto);
                getCentroEventos().agregarUsuario(usuario);

            }
            return true;
        }catch (UsuarioException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarUsuarios(String id) {
        boolean flagExiste = false;
        try{
            flagExiste = getCentroEventos().eliminarUsuario(id);
        }catch (UsuarioException e){
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarUsuarios(String idActual, UsuarioDto usuarioDto) {
        try{
            Usuario usuario = mapper.usuarioDtoToUsuario(usuarioDto);
            getCentroEventos().actualizarUsuario(idActual, usuario);
            return true;
        }catch (UsuarioException e){
            e.printStackTrace();
            return false;
        }
    }

    //EVENTOS


    @Override
    public List<EventoDto> obtenerEventos() {
        return mapper.getEventoDto(centroEventos.getListaEventos());
    }

    @Override
    public boolean agregarEvento(EventoDto eventoDto) {
        try{
            if (!centroEventos.verificarEventoExiste(eventoDto.id())){
                Evento evento = mapper.eventoDtoToEvento(eventoDto);
                getCentroEventos().agregarEvento(evento);

            }
            return true;
        }catch (EventoException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarEventos(String id) {
        boolean flagExiste = false;
        try{
            flagExiste = getCentroEventos().eliminarEvento(id);
        }catch (EventoException e){
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarEventos(String idActual, EventoDto eventoDto) {
        try{
            Evento evento = mapper.eventoDtoToEvento(eventoDto);
            getCentroEventos().actualizarEvento(idActual, evento);
            return true;
        }catch (EventoException e){
            e.printStackTrace();
            return false;
        }
    }

    //RESERVA


    @Override
    public List<ReservaDto> obtenerReservas() {
        return mapper.getReservaDto(centroEventos.getListaReservas());
    }

    @Override
    public boolean agregarReserva(ReservaDto reservaDto) {
        try{
            if (!centroEventos.verificarReservaExiste(reservaDto.id())){
                Reserva reserva = mapper.reservaDtoToReserva(reservaDto);
                getCentroEventos().agregarReserva(reserva);

            }
            return true;
        }catch (ReservaException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarReservas(String id) {
        boolean flagExiste = false;
        try{
            flagExiste = getCentroEventos().eliminarReserva(id);
        }catch (ReservaException e){
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarReservas(String idActual, ReservaDto reservaDto) {
        try{
            Reserva reserva = mapper.reservaDtoToReserva(reservaDto);
            getCentroEventos().actualizarReserva(idActual, reserva);
            return true;
        }catch (ReservaException e){
            e.printStackTrace();
            return false;
        }
    }
}
