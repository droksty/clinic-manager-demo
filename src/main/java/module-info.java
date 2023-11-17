module io.droksty.clinicmanagerdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens io.droksty.clinicmanagerdemo to javafx.fxml;
    exports io.droksty.clinicmanagerdemo;
}