module co.edu.uniquindio.centroeventos.centroeventos {
//    requires javafx.controls;
//    requires javafx.fxml;
//    requires org.mapstruct;

//
//    opens co.edu.uniquindio.centroeventos.centroeventos to javafx.fxml;
//    exports co.edu.uniquindio.centroeventos.centroeventos;
//    exports co.edu.uniquindio.centroeventos.centroeventos.viewController;
//    opens co.edu.uniquindio.centroeventos.centroeventos.viewController to javafx.fxml;
//    opens co.edu.uniquindio.centroeventos.centroeventos.mapping.mappers to org.mapstruct;
//
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires org.mapstruct;

    opens co.edu.uniquindio.centroeventos.centroeventos to javafx.fxml;
    exports co.edu.uniquindio.centroeventos.centroeventos;
    exports co.edu.uniquindio.centroeventos.centroeventos.viewController;
    opens co.edu.uniquindio.centroeventos.centroeventos.viewController to javafx.fxml;
    exports co.edu.uniquindio.centroeventos.centroeventos.controller;
    exports co.edu.uniquindio.centroeventos.centroeventos.mapping.dto;
    exports co.edu.uniquindio.centroeventos.centroeventos.mapping.mappers to org.mapstruct;
    exports co.edu.uniquindio.centroeventos.centroeventos.model;
    opens co.edu.uniquindio.centroeventos.centroeventos.controller to javafx.fxml;

}