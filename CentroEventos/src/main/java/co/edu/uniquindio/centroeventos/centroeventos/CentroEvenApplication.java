package co.edu.uniquindio.centroeventos.centroeventos;

import co.edu.uniquindio.centroeventos.centroeventos.viewController.CentroEvenViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CentroEvenApplication extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Centro Eventos");

        LoginUI loginUI = new LoginUI();
        loginUI.mostrar();


        // Verificar la autenticación y cargar la interfaz de asignación de materias si es exitosa
        if (loginUI.autenticacionExitosa()) {
            mostrarVentanaPrincipal();
        } else {
            System.out.println("La autenticación falló. La aplicación se cerrará.");
            stage.close();
        }



    }

    public void mostrarVentanaPrincipal(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(CentroEvenApplication.class.getResource("CentroEvenView.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            CentroEvenViewController centroEvenViewController = loader.getController();
//            bancoViewController.setAplicacion(this);
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            //scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        launch(args);
    }

}


