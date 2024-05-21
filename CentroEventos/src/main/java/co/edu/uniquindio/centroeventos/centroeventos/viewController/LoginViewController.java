package co.edu.uniquindio.centroeventos.centroeventos.viewController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import co.edu.uniquindio.centroeventos.centroeventos.CentroEvenApplication;
import co.edu.uniquindio.centroeventos.centroeventos.utils.Persistencia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController {

    @FXML
    private Button btmIngresarAction;

    @FXML
    private TextField txtContrasena;

    @FXML
    private TextField txtTipo;

    @FXML
    private TextField txtUsuario;

    public Boolean ingresoUsuario = false;

    private CentroEvenViewController centroEvenViewController;



    @FXML
    Boolean IngresarActionEvent(ActionEvent event) {
        // Obtener los datos ingresados por el usuario
        String usuario = txtUsuario.getText();
        String contrasena = txtContrasena.getText();
        String tipo = txtTipo.getText();

        // Ruta del archivo de texto
        String rutaArchivo = "CentroEventos/src/main/resources/persistencia/registros.txt"; // Reemplaza esto con la ruta de tu archivo

        // Intentar leer el archivo y validar los datos
        boolean usuarioValido = false;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            usuarioValido = false;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en campos (usuario, contraseña, tipo) usando coma como separador
                String[] campos = linea.split(",");
                if (campos.length == 3 && campos[0].equals(usuario) && campos[1].equals(contrasena) && campos[2].equals(tipo)) {
                    usuarioValido = true;
                    break;
                }
            }
            if (usuarioValido) {
                // Usuario válido, mostrar mensaje de éxito o realizar alguna acción adicional
                mostrarMensaje("Ingreso exitoso", "Bienvenido, " + usuario + "!");
                Persistencia.guardaRegistroLog("entro el  " + txtTipo.getText() + " " + txtUsuario.getText(), 1, "Se logeo un  " + txtTipo.getText());
                CentroEvenApplication c = new CentroEvenApplication();
                Stage primaryStage = new Stage();




                FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/centroeventos/centroeventos/CentroEvenView.fxml"));
                Parent root = loader.load();
                centroEvenViewController = loader.getController();
                if ("usuario".equals(tipo)) {
                    ingresoUsuario = true;
                }
                centroEvenViewController.ingresoUsuario = ingresoUsuario;
                centroEvenViewController.deshabilitarTabs();

                primaryStage.setScene(new Scene(root));
                primaryStage.show();

                Stage stage = (Stage) txtUsuario.getScene().getWindow(); // Obtener el Stage asociado a cualquier nodo en la escena
                stage.close();



//                c.mostrarVentanaPrincipal(primaryStage);
//                Stage stage = (Stage) txtUsuario.getScene().getWindow(); // Obtener el Stage asociado a cualquier nodo en la escena
//                stage.close();

                return ingresoUsuario;
            } else {
                // Usuario inválido, mostrar mensaje de error
                mostrarMensaje("Error de ingreso", "Usuario o contraseña incorrectos.");
            }
        } catch (IOException e) {
            // Manejar cualquier excepción de E/S (por ejemplo, archivo no encontrado)
            e.printStackTrace();
            mostrarMensaje("Error", "Error al intentar ingresar.");
        }

        return usuarioValido;
    }

    // Método para mostrar un mensaje de alerta
    private void mostrarMensaje(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    public TextField getTxtUsuario() {
        return txtUsuario;
    }
}