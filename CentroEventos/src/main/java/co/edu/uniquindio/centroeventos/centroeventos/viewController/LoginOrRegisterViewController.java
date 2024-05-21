package co.edu.uniquindio.centroeventos.centroeventos.viewController;


import co.edu.uniquindio.centroeventos.centroeventos.CentroEvenApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginOrRegisterViewController {

    @FXML
    private Button btmIngresar;

    @FXML
    private Button btmRegistrarse;

    Boolean estadoIngresar = false;
    Boolean estadoRegistrar = false;
    @FXML
    Boolean ingresarActionEvent(ActionEvent event) throws Exception {
        estadoIngresar = true;
        CentroEvenApplication c = new CentroEvenApplication();
        Stage primaryStage = new Stage();
        c.startIngresar(primaryStage);
        return estadoIngresar;


    }

    @FXML
    Boolean registrarseActionEvent(ActionEvent event) {
        estadoRegistrar = true;
        CentroEvenApplication c = new CentroEvenApplication();
        Stage primaryStage = new Stage();
        c.startRegistro(primaryStage);
        return estadoRegistrar;
    }

}
