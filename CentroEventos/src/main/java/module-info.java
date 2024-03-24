module co.edu.uniquindio.centroeventos.centroeventos {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mapstruct;


    opens co.edu.uniquindio.centroeventos.centroeventos to javafx.fxml;
    exports co.edu.uniquindio.centroeventos.centroeventos;
}