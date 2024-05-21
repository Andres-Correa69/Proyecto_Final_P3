package co.edu.uniquindio.centroeventos.centroeventos.viewController;

import co.edu.uniquindio.centroeventos.centroeventos.CentroEvenApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegistroControllerView {

    private static final String RUTA_ARCHIVO = "CentroEventos/src/main/resources/persistencia/registros.txt";

    @FXML
    private TextField txtContrasena;

    @FXML
    private TextField txtTipo;

    @FXML
    private TextField txtUsuario;

    @FXML
    void registrarseActionEvent(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String contrasena = txtContrasena.getText();
        String tipo = txtTipo.getText();

        // Comprobar si algún campo está vacío
        if (usuario.isEmpty() || contrasena.isEmpty() || tipo.isEmpty()) {
            System.out.println("Por favor, complete todos los campos.");
            return;
        }

        // Guardar los datos en el archivo de texto
        guardarRegistro(usuario, contrasena, tipo);

        // Limpiar los campos después de guardar los datos
        txtUsuario.clear();
        txtContrasena.clear();
        txtTipo.clear();




        Stage stage = (Stage) txtUsuario.getScene().getWindow(); // Obtener el Stage asociado a cualquier nodo en la escena
        stage.close();



    }


    private void guardarRegistro(String usuario, String contrasena, String tipo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, true))) {
            // Escribir los datos del registro en el archivo de texto
            writer.write(usuario + "," + contrasena + "," + tipo + "\n");
            System.out.println("Registro guardado exitosamente en: " + RUTA_ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al guardar el registro: " + e.getMessage());
        }
    }
}