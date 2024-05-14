package co.edu.uniquindio.centroeventos.centroeventos.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private static final String PROPERTIES_FILE = "CentroEventos/src/main/resources/persistencia/app.properties";

    public static Properties cargarPropiedades() {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(PROPERTIES_FILE)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public static String obtenerPropiedad(String key) {
        Properties prop = cargarPropiedades();
        return prop.getProperty(key);
    }
}
