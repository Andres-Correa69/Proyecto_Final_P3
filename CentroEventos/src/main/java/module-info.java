module co.edu.uniquindio.centroeventos.centroeventos {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.centroeventos.centroeventos to javafx.fxml;
    exports co.edu.uniquindio.centroeventos.centroeventos;
}