package co.edu.uniquindio.centroeventos.centroeventos.utils;

import co.edu.uniquindio.centroeventos.centroeventos.model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Persistencia {
    //CentroEventos/src/main/resources/persistencia/archivoEmpleado.txt

    public static final String RUTA_ARCHIVO_USUARIO = "CentroEventos/src/main/resources/persistencia/archivoUsuario.txt";
    public static final String RUTA_ARCHIVO_RESERVA = "CentroEventos/src/main/resources/persistencia/archivoReserva.txt";
    public static final String RUTA_ARCHIVO_EVENTO = "CentroEventos/src/main/resources/persistencia/archivoEvento.txt";
    public static final String RUTA_ARCHIVO_EMPLEADO ="CentroEventos/src/main/resources/persistencia/archivoEmpleado.txt";
    public static final String RUTA_ARCHIVO_LOG = "CentroEventos/src/main/resources/persistencia/log/CentroEventosLog.txt";
    public static final String RUTA_ARCHIVO_MODELO_CENTROEVENTOS_BINARIO = "CentroEventos/src/main/resources/persistencia/model.dat";
    public static final String RUTA_ARCHIVO_MODELO_CENTROEVENTOS_XML = "CentroEventos/src/main/resources/persistencia/model.xml";
    public static final String RUTA_RESPALDO_ARCHIVO_EMPLEADOS ="CentroEventos/src/main/resources/persistencia/respaldo/respladoEmpleados.txt";
    public static final String RUTA_RESPALDO_ARCHIVO_USUARIOS ="CentroEventos/src/main/resources/persistencia/respaldo/respladoUsuarios.txt";
    public static final String RUTA_RESPALDO_ARCHIVO_RESERVAS ="CentroEventos/src/main/resources/persistencia/respaldo/respladoReservas.txt";
    public static final String RUTA_RESPALDO_ARCHIVO_EVENTOS ="CentroEventos/src/main/resources/persistencia/respaldo/respladoEventos.txt";

    public static void cargarDatosArchivos(CentroEventos centroEventos)throws FileNotFoundException, IOException{
        ArrayList<Usuario> usuariosCargados = cargarUsuarios();
        if(usuariosCargados.size()>0)
            centroEventos.getListaUsuarios().addAll(usuariosCargados);

        ArrayList<Reserva> reservasCargados = cargarReservas();
        if(reservasCargados.size()>0)
            centroEventos.getListaReservas().addAll(reservasCargados);

        ArrayList<Evento> eventosCargados = cargarEventos();
        if(eventosCargados.size()>0)
            centroEventos.getListaEventos().addAll(eventosCargados);

        ArrayList<Empleado> empleadosCargados = cargarEmpleados();
        if (empleadosCargados.size()>0)
            centroEventos.getListaEmpleados().addAll(empleadosCargados);
    }

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     * @param
     * @param
     * @throws IOException
     */

    public static void guardarUsuarios(ArrayList<Usuario> listaUsuarios) throws IOException{
        String contenido = "";
        for(Usuario usuario: listaUsuarios){
            contenido += usuario.getId() + "@@" + usuario.getNombre() + "@@" + usuario.getCorreo() + "@@" +
                    usuario.getReserva().getId() + "\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_USUARIO, contenido,  false);
    }

    public static void guardarReservas(ArrayList<Reserva> listaReservas)throws IOException{
        String contenido = "";
        for(Reserva reserva: listaReservas){
            contenido += reserva.getId() + "@@" + reserva.getUsuario().getId() + "@@" + reserva.getEvento().getId() +"@@"
                    + reserva.getFechaSolicitud() + "@@" + reserva.getEstadoReserva() + "\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_RESERVA, contenido, false);
    }

    public  static void guardarEventos(ArrayList<Evento> listaEventos)throws IOException{
        String contenido = "";
        for (Evento evento: listaEventos){
            contenido += evento.getId() + "@@" + evento.getNombre() + "@@" + evento.getDescripcion() + "@@" +
                    evento.getFecha() + "@@" + evento.getCapacidadMax() + "@@" + evento.getEmpleado().getId() +
                    "@@" + evento.getReserva().getId() + "\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EVENTO, contenido, false);
    }

    public static void guardarEmpleados(ArrayList<Empleado> listaEmpleados)throws  IOException{
        String contenido = "";
        for (Empleado empleado: listaEmpleados){
            contenido += empleado.getId() + "@@" + empleado.getNombre() + "@@" + empleado.getCorreo() + "@@" +
                    empleado.getEvento().getId() + "\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADO, contenido, false);
    }

    /**
     *
     * @param
     * @param
     * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
     * @throws FileNotFoundException
     * @throws IOException
     */



    public static ArrayList<Usuario> cargarUsuarios() throws FileNotFoundException, IOException{
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_USUARIO);
        String linea = "";
        Reserva reserva = new Reserva();
        for (int i = 0 ; i < contenido.size(); i++){
            linea = contenido.get(i);
            Usuario usuario = new Usuario();
            usuario.setId(linea.split("@@")[0]);
            usuario.setNombre(linea.split("@@")[1]);
            usuario.setCorreo(linea.split("@@")[2]);
            reserva.setId((linea.split("@@"))[3]);
            usuario.setReserva(reserva);
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public  static ArrayList<Reserva> cargarReservas() throws FileNotFoundException, IOException{
        ArrayList<Reserva> reservas = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_RESERVA);
        String linea = "";
        Usuario usuario = new Usuario();
        Evento evento = new Evento();
        for (int i = 0; i < contenido.size(); i++){
            linea = contenido.get(i);
            Reserva reserva = new Reserva();
            reserva.setId(linea.split("@@")[0]);
            usuario.setId(linea.split("@@")[1]);
            evento.setId(linea.split("@@")[2]);
            reserva.setUsuario(usuario);
            reserva.setEvento(evento);
            reserva.setFechaSolicitud(LocalDate.parse(linea.split("@@")[3]).toString());
            reserva.setEstadoReserva(TipoEstadoReserva.valueOf(linea.split("@@")[4]));
            reservas.add(reserva);
        }
        return  reservas;
    }

    public static ArrayList<Evento> cargarEventos()throws FileNotFoundException, IOException{
        ArrayList<Evento> eventos = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_EVENTO);
        String linea = "";
        Empleado empleado = new Empleado();
        Reserva reserva = new Reserva();
        for (int i = 0; i<contenido.size(); i++){
            linea = contenido.get(i);
            Evento evento = new Evento();
            evento.setId(linea.split("@@")[0]);
            evento.setNombre(linea.split("@@")[1]);
            evento.setDescripcion(linea.split("@@")[2]);
            evento.setFecha(linea.split("@@")[3]);
            evento.setCapacidadMax(Integer.valueOf(linea.split("@@")[4]));
            empleado.setId(linea.split("@@")[5]);
            reserva.setId(linea.split("@@")[6]);
            evento.setEmpleado(empleado);
            evento.setReserva(reserva);
            eventos.add(evento);

        }

        return eventos;
    }

    public static ArrayList<Empleado> cargarEmpleados()throws FileNotFoundException, IOException{
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_EMPLEADO);
        String linea = "";
        Evento evento = new Evento();
        for(int i = 0; i<contenido.size(); i++){
            linea = contenido.get(i);
            Empleado empleado = new Empleado();
            empleado.setId(linea.split("@@")[0]);
            empleado.setNombre(linea.split("@@")[1]);
            empleado.setCorreo(linea.split("@@")[2]);
            evento.setId(linea.split("@@")[3]);
            empleado.setEvento(evento);
            empleados.add(empleado);

        }
        return empleados;

    }

    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion){
        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     * @param
     * @param ruta
     * @throws IOException
     */


    public static void guardarObjetos(ArrayList<Usuario> listaUsuarios,ArrayList<Reserva> listaReservas, ArrayList<Evento> listaEventos,ArrayList<Empleado> listaEmpleados,  String ruta) throws IOException  {
        String contenido = "";

        for(Usuario usuarioAux:listaUsuarios) {
            contenido += usuarioAux.getId() + "@@" + usuarioAux.getNombre() + "@@" + usuarioAux.getCorreo() + "@@" +
                    usuarioAux.getReserva().getId() + "\n";
        }
        ArchivoUtil.guardarArchivo(ruta, contenido, true);

        for(Reserva reservaAux:listaReservas){
            contenido += reservaAux.getId() + "@@" + reservaAux.getUsuario().getId() + "@@" + reservaAux.getEvento().getId() +"@@"
                    + reservaAux.getFechaSolicitud() + "@@" + reservaAux.getEstadoReserva() + "\n";
        }
        ArchivoUtil.guardarArchivo(ruta, contenido, true);

        for(Evento eventoAux:listaEventos){
            contenido += eventoAux.getId() + "@@" + eventoAux.getNombre() + "@@" + eventoAux.getDescripcion() + "@@" +
                    eventoAux.getFecha() + "@@" + eventoAux.getCapacidadMax() + "@@" + eventoAux.getEmpleado().getId() +
                    "@@" + eventoAux.getReserva().getId() + "\n";
        }
        ArchivoUtil.guardarArchivo(ruta, contenido, true);

        for(Empleado empleadoAux: listaEmpleados){
            contenido += empleadoAux.getId() + "@@" + empleadoAux.getNombre() + "@@" + empleadoAux.getCorreo() + "@@" +
                    empleadoAux.getEvento().getId() + "\n";
        }
    }



    //METODO GUARDAR OBJETOS SIN USAGES

    //-----------SERIALIZACION Y XML

    public static void guardarCopiaSeguridad(){
        try {
            // Convertir las rutas de cadena a objetos de Path
            Path archivoEmpleados = Paths.get(RUTA_ARCHIVO_EMPLEADO);
            Path archivoRespaldo = Paths.get(RUTA_RESPALDO_ARCHIVO_EMPLEADOS);
            Path archivoUsuarios = Paths.get(RUTA_ARCHIVO_USUARIO);
            Path archivoRespaldoUsuarios = Paths.get(RUTA_RESPALDO_ARCHIVO_USUARIOS);
            Path archivoReservas = Paths.get(RUTA_ARCHIVO_RESERVA);
            Path archivoRespaldoReservas = Paths.get(RUTA_RESPALDO_ARCHIVO_RESERVAS);
            Path archivoEventos = Paths.get(RUTA_ARCHIVO_EVENTO);
            Path archivosRespaldoEventos = Paths.get(RUTA_RESPALDO_ARCHIVO_EVENTOS);


            // Copiar el archivo
            Files.copy(archivoEmpleados, archivoRespaldo);
            Files.copy(archivoUsuarios, archivoRespaldoUsuarios);
            Files.copy(archivoReservas, archivoRespaldoReservas);
            Files.copy(archivoEventos, archivosRespaldoEventos);

            System.out.println("¡Copia de seguridad creada exitosamente!");
        } catch (IOException e) {
            System.err.println("Error al crear la copia de seguridad: " + e.getMessage());
        }
    }

    public static CentroEventos cargarRecursoCentroEventosBinario(){

        CentroEventos centroEventos = null;

        try{
            centroEventos = (CentroEventos) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_CENTROEVENTOS_BINARIO);
        } catch (Exception e){
            e.printStackTrace();
        }
        return centroEventos;
    }

    public static void guardarRecursoCentroEventosBinario(CentroEventos centroEventos){
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_CENTROEVENTOS_BINARIO, centroEventos);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static CentroEventos cargarRecursoCentroEventosXML(){
        CentroEventos centroEventos = null;

        try{
            centroEventos = (CentroEventos) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_CENTROEVENTOS_XML);
        } catch (Exception e){
            e.printStackTrace();
        }
        return centroEventos;
    }


    public static void guardarRecursoCentroEventosXML(CentroEventos centroEventos){
        try {

            System.out.println(centroEventos.getListaEventos());
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_CENTROEVENTOS_XML, centroEventos);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}



