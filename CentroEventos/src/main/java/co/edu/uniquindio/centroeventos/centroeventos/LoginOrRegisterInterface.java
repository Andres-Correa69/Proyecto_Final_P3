package co.edu.uniquindio.centroeventos.centroeventos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class LoginOrRegisterInterface extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Crear botones para iniciar sesión y registrarse
        Button loginButton = new Button("Iniciar Sesión");
        Button registerButton = new Button("Registrarse");

        // Establecer los eventos de los botones
        loginButton.setOnAction(event -> {
            // Lógica para mostrar la interfaz de inicio de sesión
            CentroEvenApplication login = new CentroEvenApplication();
            try {
                login.start(primaryStage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });

        registerButton.setOnAction(event -> {
            // Lógica para mostrar la interfaz de registro
            RegistroInterfaz registro = new RegistroInterfaz();
            try {
                registro.start(primaryStage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Mostrar interfaz de registro...");
        });

        // Crear un contenedor VBox para colocar los botones
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(loginButton, registerButton);
        root.setAlignment(Pos.CENTER); // Centra los nodos verticalmente

        // Crear la escena y mostrarla en el escenario
        Scene scene = new Scene(root, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login o Registro");

        // Obtener el tamaño de la pantalla y calcular la posición para centrar el Stage
        Screen screen = Screen.getPrimary();
        double screenWidth = screen.getBounds().getWidth();
        double screenHeight = screen.getBounds().getHeight();
        primaryStage.setX((screenWidth - 300) / 2); // Centrar horizontalmente
        primaryStage.setY((screenHeight - 150) / 2); // Centrar verticalmente

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
