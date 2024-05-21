package co.edu.uniquindio.centroeventos.centroeventos.viewController;

import co.edu.uniquindio.centroeventos.centroeventos.controller.CentroEvenController;
import co.edu.uniquindio.centroeventos.centroeventos.controller.service.ICentroEvenControllerService;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.util.Objects;

public class CentroEvenViewController {
    ICentroEvenControllerService centroEvenControllerService;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab usuarioTab;

    @FXML
    private Tab empleadoTab;

    @FXML
    private Tab eventoTab;

    @FXML
    private Tab reservaTab;

    public Boolean ingresoUsuario;





    public CentroEvenViewController() {
    }

    @FXML
    void initialize() {centroEvenControllerService = new CentroEvenController();



    }
    public void deshabilitarTabs() {
        if (ingresoUsuario != null && ingresoUsuario) {
            eventoTab.setDisable(true);
            usuarioTab.setDisable(true);
            empleadoTab.setDisable(true);
        }
    }
}


