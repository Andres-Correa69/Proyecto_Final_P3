package co.edu.uniquindio.centroeventos.centroeventos.viewController;

import co.edu.uniquindio.centroeventos.centroeventos.controller.CentroEvenController;
import co.edu.uniquindio.centroeventos.centroeventos.controller.service.ICentroEvenControllerService;
import javafx.fxml.FXML;

public class CentroEvenViewController {
    ICentroEvenControllerService centroEvenControllerService;

    @FXML
    void initialize() {centroEvenControllerService = new CentroEvenController();
    }
}
