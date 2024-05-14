package co.edu.uniquindio.centroeventos.centroeventos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



public class RegistroInterfaz extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Registro");

        // Crear los controles de la interfaz
        Label usuarioLabel = new Label("Usuario:");
        TextField usuarioField = new TextField();
        Label contraseñaLabel = new Label("Contraseña:");
        PasswordField contraseñaField = new PasswordField();
        Button registrarButton = new Button("Registrar");

        // Crear el contenedor y configurar su diseño
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Agregar los controles al contenedor
        gridPane.add(usuarioLabel, 0, 0);
        gridPane.add(usuarioField, 1, 0);
        gridPane.add(contraseñaLabel, 0, 1);
        gridPane.add(contraseñaField, 1, 1);
        gridPane.add(registrarButton, 1, 2);

        // Crear la escena y configurarla en el escenario
        Scene scene = new Scene(gridPane, 300, 150);
        primaryStage.setScene(scene);

        // Configurar el evento de clic del botón de registro
        registrarButton.setOnAction(event -> {
            String usuario = usuarioField.getText().trim();
            String contraseña = contraseñaField.getText();

            // Guardar el usuario y la contraseña en un archivo de propiedades
            guardarUsuario(usuario, contraseña);

            LoginOrRegisterInterface login = new LoginOrRegisterInterface();
            try {
                login.start(primaryStage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            // Mostrar un mensaje de éxito en la consola
            System.out.println("Registro exitoso para el usuario: " + usuario);
        });

        // Mostrar la ventana
        primaryStage.show();



    }
    private static final String PROPERTIES_FILE = "CentroEventos/src/main/resources/persistencia/app.properties";
    private void guardarUsuario(String usuario, String contraseña) {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de propiedades: " + e.getMessage());
        }

        try (FileOutputStream fos = new FileOutputStream(PROPERTIES_FILE)) {
            // Agregar el nuevo usuario y contraseña
            properties.setProperty("usuario", usuario);
            properties.setProperty("contrasena", contraseña);

            // Guardar los valores actualizados en el archivo
            properties.store(fos, "Usuarios registrados");
            System.out.println("Usuario y contraseña guardados correctamente en " + PROPERTIES_FILE);
        } catch (IOException e) {
            System.err.println("Error al guardar el usuario: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

}


