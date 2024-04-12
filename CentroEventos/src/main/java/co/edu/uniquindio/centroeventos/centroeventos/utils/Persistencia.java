package co.edu.uniquindio.centroeventos.centroeventos.utils;

import co.edu.uniquindio.centroeventos.centroeventos.model.CentroEventos;
import co.edu.uniquindio.centroeventos.centroeventos.model.Empleado;
import co.edu.uniquindio.centroeventos.centroeventos.model.Usuario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {
    //CentroEventos/src/main/resources/persistencia/archivoEmpleado.txt

    public static final String RUTA_ARCHIVO_USUARIO = "CentroEventos/src/main/resources/persistencia/archivoUsuario.txt";
    public static final String RUTA_ARCHIVO_LOG = "CentroEventos/src/main/resources/persistencia/log/CentroEventosLog.txt";
    public static final String RUTA_ARCHIVO_MODELO_CENTROEVENTOS_BINARIO = "CentroEventos/src/main/resources/persistencia/model.dat";
    public static final String RUTA_ARCHIVO_MODELO_CENTROEVENTOS_XML = "CentroEventos/src/main/resources/persistencia/model.xml";

    public static void cargarDatosArchivos(CentroEventos centroEventos)throws FileNotFoundException, IOException{
        ArrayList<Usuario> usuariosCargados = cargarUsuarios();
        if(usuariosCargados.size()>0)
            centroEventos.getListaUsuarios().addAll(usuariosCargados);
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
        for (int i = 0 ; i < contenido.size(); i++){
            linea = contenido.get(i);
            Usuario usuario = new Usuario();
            usuario.setId(linea.split("@@")[0]);
            usuario.setNombre(linea.split("@@")[1]);
            usuario.setCorreo(linea.split("@@")[2]);
            usuario.getReserva().setId(linea.split("@@")[3]);
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion){
        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     * @param
     * @param
     * @throws IOException
     */

    //METODO GUARDAR OBJETOS SIN USAGES

    //-----------SERIALIZACION Y XML

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
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_CENTROEVENTOS_XML, centroEventos);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}



