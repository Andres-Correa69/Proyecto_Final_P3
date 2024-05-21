package co.edu.uniquindio.centroeventos.centroeventos;

import co.edu.uniquindio.centroeventos.centroeventos.viewController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CentroEvenApplication extends Application {

    Boolean estadoIngresar = false;
    Boolean estadoRegistro = false;
    Boolean usuarioValido = false;
    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Centro Eventos");
//
//        LoginUI loginUI = new LoginUI();
//        loginUI.mostrar();
        startLogin(primaryStage);

        if(estadoIngresar == true){
            startIngresar(primaryStage);

        }


        if(estadoRegistro == true){
            startRegistro(primaryStage);
        }

        if(usuarioValido == true){
            mostrarVentanaPrincipal(primaryStage);
        }
        //startIngresar();
        //startRegistro();
        // Verificar la autenticación y cargar la interfaz de asignación de materias si es exitosa
//        if (loginUI.autenticacionExitosa()) {
       //mostrarVentanaPrincipal();
//        } else {
//            System.out.println("La autenticación falló. La aplicación se cerrará.");
//            stage.close();
//        }



    }




    public void startLogin(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(CentroEvenApplication.class.getResource("LoginOrRegisterView.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            LoginOrRegisterViewController loginOrRegisterViewController = loader.getController();
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

    public void startIngresar(Stage primaryStage){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(CentroEvenApplication.class.getResource("LoginView.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            LoginViewController loginViewController = loader.getController();
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



    public void startRegistro(Stage primaryStage){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(CentroEvenApplication.class.getResource("RegistroView.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            RegistroControllerView registroViewController = loader.getController();
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



    public void mostrarVentanaPrincipal(Stage primaryStage){
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


