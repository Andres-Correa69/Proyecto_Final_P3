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
import co.edu.uniquindio.centroeventos.centroeventos.utils.Persistencia;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;



public class ModelFactoryController implements IModelFactoryService, Runnable {

    CentroEventos centroEventos;

    Thread hilo1GuardarXml;
    Thread hilo2GuardarBinario;
    Thread hilo3GuardarDatosUsuario;
    Thread hilo4GuardarDatosEmpleado;
    Thread hilo5GuardarDatosReserva;
    Thread hilo6GuardarDatosEvento;
    Thread hilo7CargarSerializadoBinario;
    Thread hilo8CargarSerializadoXML;
    Thread hilo9guardarReservasCSV;
    String mensaje = "";
    int nivel = 0;
    String accion = "";
    BoundedSemaphore semaphore = new BoundedSemaphore(1);

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
        //3
        guardarRespaldo();
//        cargarDatosBase();
//        salvarDatosPrueba();



        //2. Cargar los datos de los archivos
//         cargarDatosDesdeArchivos();

        //3. Guardar y Cargar el recurso serializable binario
//        cargarResourceBinario();
//        guardarResourceBinario();

        //4. Guardar y Cargar el recurso serializable XML
//        guardarResourceXML();
          cargarResourceXML();

        //Siempre se debe verificar si la raiz del recurso es null

//        if(centroEventos == null){
//            cargarDatosBase();
//            guardarResourceXML();
//        }

        registrarAccionesSistema("Inicio de sesión", 1, "inicioSesión");
        Runtime.getRuntime().addShutdownHook(new Thread(Persistencia::guardarCopiaSeguridad));
    }
    private void guardarRespaldo(){
        centroEventos = new CentroEventos();
        Persistencia.guardarCopiaSeguridad();
    }



    private void cargarDatosDesdeArchivos() {
        centroEventos = new CentroEventos();
        try {
            Persistencia.cargarDatosArchivos(centroEventos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void salvarDatosPrueba() {
        try {
            Persistencia.guardarUsuarios(getCentroEventos().getListaUsuarios());
            Persistencia.guardarReservas(getCentroEventos().getListaReservas());
            Persistencia.guardarEventos(getCentroEventos().getListaEventos());
            Persistencia.guardarEmpleados(getCentroEventos().getListaEmpleados());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
            Persistencia.guardaRegistroLog("Agregar empleado", 1, "se agrego un empleado");
            guardarDatosEmpleados();
            guardarResourceXML();
            guardarResourceBinario();
            return true;
        }catch (EmpleadoException e){
            e.getMessage();
            Persistencia.guardaRegistroLog(e.getMessage(), 3, "fallo al agregar el empleado");
            return false;
        }
    }

    @Override
    public boolean eliminarEmpleado(String id) {
        boolean flagExiste = false;
        try{
            flagExiste = getCentroEventos().eliminarEmpleado(id);
            guardarDatosEmpleados();
            guardarResourceXML();
            guardarResourceBinario();
            Persistencia.guardaRegistroLog("Eliminar empleado", 1, "se elimino el empleado" );
        }catch (EmpleadoException e){
            e.printStackTrace();
            Persistencia.guardaRegistroLog(e.getMessage(), 3, "fallo al eliminar el empleado");

        }
        return flagExiste;
    }

    @Override
    public boolean actualizarEmpleado(String idActual, EmpleadoDto empleadoDto) {
        try{
            Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
            getCentroEventos().actualizarEmpleado(idActual, empleado);
            guardarDatosEmpleados();
            guardarResourceXML();
            guardarResourceBinario();
            Persistencia.guardaRegistroLog("Actualizar empleado",  1 ,  "se actualizo el empleado");
            return true;
        }catch (EmpleadoException e){
            e.printStackTrace();
            Persistencia.guardaRegistroLog(e.getMessage(), 3, "fallo al actualizar empleado");
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
            Persistencia.guardaRegistroLog("Agregar usuario", 1, "se agrego un usuario");
            guardarDatosUsuarios();
            guardarResourceXML();
            guardarResourceBinario();

            return true;
        }catch (UsuarioException e){
            e.getMessage();
            Persistencia.guardaRegistroLog(e.getMessage(), 3, "fallo al agregar usuario");
            return false;
        }
    }
    @Override
    public boolean eliminarUsuarios(String id) {
        boolean flagExiste = false;
        try{
            flagExiste = getCentroEventos().eliminarUsuario(id);
            guardarDatosUsuarios();
            guardarResourceXML();
            guardarResourceBinario();
            Persistencia.guardaRegistroLog("Eliminar usuario", 1, "se elimina al usuario");
        }catch (UsuarioException e){
            e.printStackTrace();
            Persistencia.guardaRegistroLog(e.getMessage(), 3, "fallo al eliminar al usuario" );
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarUsuarios(String idActual, UsuarioDto usuarioDto) {
        try{
            Usuario usuario = mapper.usuarioDtoToUsuario(usuarioDto);
            getCentroEventos().actualizarUsuario(idActual, usuario);
            guardarDatosUsuarios();
            guardarResourceXML();
            guardarResourceBinario();
            Persistencia.guardaRegistroLog("Actualizar usuario", 1, "se actualizo la informacion del usuario");
            return true;
        }catch (UsuarioException e){
            e.printStackTrace();
            Persistencia.guardaRegistroLog(e.getMessage(), 3, "fallo al actualizar el usuario");
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
            Persistencia.guardaRegistroLog("Agregar evento", 1, "se agrego el evento");
            guardarResourceXML();
            guardarResourceBinario();
            guardarDatosEventos();
            return true;
        }catch (EventoException e){
            e.getMessage();
            Persistencia.guardaRegistroLog(e.getMessage(), 3, "fallo al agregar evento");
            return false;
        }
    }

    @Override
    public boolean eliminarEventos(String id) {
        boolean flagExiste = false;
        try{
            flagExiste = getCentroEventos().eliminarEvento(id);
            guardarResourceXML();
            guardarResourceBinario();
            guardarDatosEventos();
            Persistencia.guardaRegistroLog("Eliminar evento", 1 , "se elimino un evento");
        }catch (EventoException e){
            e.printStackTrace();
            Persistencia.guardaRegistroLog(e.getMessage(), 3 , "fallo al eliminar evento");
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarEventos(String idActual, EventoDto eventoDto) {
        try{
            Evento evento = mapper.eventoDtoToEvento(eventoDto);
            getCentroEventos().actualizarEvento(idActual, evento);
            guardarResourceXML();
            guardarResourceBinario();
            guardarDatosEventos();
            Persistencia.guardaRegistroLog("Actualizar evento", 1, "se actualizo el evento");
            return true;
        }catch (EventoException e){
            e.printStackTrace();
            Persistencia.guardaRegistroLog(e.getMessage(), 3, "fallo al actualizar el evento");
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
            Persistencia.guardaRegistroLog("Agregar reserva", 1 , "se agrego la reserva");
            guardarResourceXML();
            guardarResourceBinario();
            guardarDatosReservas();
            guardarArchivoReservasCSV();
            return true;
        }catch (ReservaException e){
            e.getMessage();
            Persistencia.guardaRegistroLog(e.getMessage(), 3, "fallo al agregar reserva");
            return false;
        }
    }

    @Override
    public boolean eliminarReservas(String id) {
        boolean flagExiste = false;
        try{
            flagExiste = getCentroEventos().eliminarReserva(id);
            guardarResourceXML();
            guardarResourceBinario();
            guardarDatosReservas();
            guardarArchivoReservasCSV();
            Persistencia.guardaRegistroLog("Eliminar reserva", 1, "se elimino la reserva");
        }catch (ReservaException e){
            e.printStackTrace();
            Persistencia.guardaRegistroLog(e.getMessage(), 3, "fallo al eliminar reserva");
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarReservas(String idActual, ReservaDto reservaDto) {
        try{
            Reserva reserva = mapper.reservaDtoToReserva(reservaDto);
            getCentroEventos().actualizarReserva(idActual, reserva);
            guardarResourceXML();
            guardarResourceBinario();
            guardarDatosReservas();
            guardarArchivoReservasCSV();
            Persistencia.guardaRegistroLog("Actualizar reserva", 1 , "se actualizo la reserva");
            return true;
        }catch (ReservaException e){
            e.printStackTrace();
            Persistencia.guardaRegistroLog(e.getMessage(), 3, "fallo al agregar la reserva");
            return false;
        }
    }

    private void cargarResourceXML() {
//        hilo8CargarSerializadoXML = new Thread(this);
//        hilo8CargarSerializadoXML.start();
        centroEventos = Persistencia.cargarRecursoCentroEventosXML();
    }

    private void guardarResourceXML() {
        hilo1GuardarXml = new Thread(this);
        hilo1GuardarXml.start();
    }

    private void cargarResourceBinario() {
//        hilo7CargarSerializadoBinario = new Thread(this);
//        hilo7CargarSerializadoBinario.start();
        centroEventos = Persistencia.cargarRecursoCentroEventosBinario();
    }

    private void guardarResourceBinario() {
        hilo2GuardarBinario = new Thread(this);
        hilo2GuardarBinario.start();

    }

    private void guardarDatosUsuarios(){
        hilo3GuardarDatosUsuario = new Thread(this);
        hilo3GuardarDatosUsuario.start();
//            Persistencia.guardarUsuarios(getCentroEventos().getListaUsuarios());

    }

    private void guardarDatosEmpleados(){
        hilo4GuardarDatosEmpleado = new Thread(this);
        hilo4GuardarDatosEmpleado.start();

    }

    private void guardarDatosEventos(){
        hilo6GuardarDatosEvento = new Thread(this);
        hilo6GuardarDatosEvento.start();

    }

    private void guardarDatosReservas(){
        hilo5GuardarDatosReserva = new Thread(this);
        hilo5GuardarDatosReserva.start();

    }

    private void guardarArchivoReservasCSV(){
        hilo9guardarReservasCSV = new Thread(this);
        hilo9guardarReservasCSV.start();
    }



    public void registrarAccionesSistema(String mensaje, int nivel, String accion) {
        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }

    @Override
    public void run() {
        Thread hiloActual = Thread.currentThread();
        ocupar();

        if(hiloActual == hilo1GuardarXml){
            Persistencia.guardarRecursoCentroEventosXML(centroEventos);
            liberar();
        }
        if(hiloActual == hilo2GuardarBinario){
            Persistencia.guardarRecursoCentroEventosBinario(centroEventos);
            liberar();
        }
        if(hiloActual == hilo3GuardarDatosUsuario){
            try {
                Persistencia.guardarUsuarios(getCentroEventos().getListaUsuarios());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            liberar();
        }
        if(hiloActual == hilo4GuardarDatosEmpleado){
            try{
                Persistencia.guardarEmpleados(getCentroEventos().getListaEmpleados());
            }catch (IOException e){
                throw new RuntimeException(e);
            }
            liberar();
        }
       if(hiloActual == hilo6GuardarDatosEvento){
           try{
               Persistencia.guardarEventos(getCentroEventos().getListaEventos());
           }catch (IOException e){
               throw new RuntimeException(e);
           }
           liberar();
       }
       if(hiloActual == hilo5GuardarDatosReserva){
           try{
               Persistencia.guardarReservas(getCentroEventos().getListaReservas());
           }catch(IOException e){
               throw new RuntimeException(e);
           }
           liberar();
       }
       if(hiloActual == hilo7CargarSerializadoBinario){
           Persistencia.cargarRecursoCentroEventosBinario();
           liberar();
       }
        if(hiloActual == hilo8CargarSerializadoXML){
            centroEventos = Persistencia.cargarRecursoCentroEventosXML();
            liberar();
        }
        if(hiloActual == hilo9guardarReservasCSV){
            try {
                Persistencia.guardarReservasCSV(getCentroEventos().getListaReservas());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }


    private void liberar() {
        try {
            semaphore.liberar();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void ocupar() {
        try {
            semaphore.ocupar();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
