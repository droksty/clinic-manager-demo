module io.droksty.clinicmanagerdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires commons.dbcp2;


    opens io.droksty.clinicmanagerdemo to javafx.fxml;
    exports io.droksty.clinicmanagerdemo;
}