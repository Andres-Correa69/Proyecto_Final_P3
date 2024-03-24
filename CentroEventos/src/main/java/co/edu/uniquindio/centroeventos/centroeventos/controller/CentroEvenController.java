package co.edu.uniquindio.centroeventos.centroeventos.controller;

import co.edu.uniquindio.centroeventos.centroeventos.controller.service.ICentroEvenControllerService;

public class CentroEvenController implements ICentroEvenControllerService {

    ModelFactoryController modelFactoryController;

    public CentroEvenController(){
        System.out.println("Llamando al singleton desde CentroEventosControllerService");
        modelFactoryController = ModelFactoryController.getInstance();

    }


}
