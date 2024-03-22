module co.ignore.centroeventos {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.ignore.centroeventos to javafx.fxml;
    exports co.ignore.centroeventos;
}