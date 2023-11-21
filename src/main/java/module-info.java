module io.droksty.clinicmanagerdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires commons.dbcp2;
    requires java.management;

    opens io.droksty.clinicmanagerdemo to javafx.fxml;
    opens io.droksty.clinicmanagerdemo.view to javafx.fxml;
    exports io.droksty.clinicmanagerdemo;
}