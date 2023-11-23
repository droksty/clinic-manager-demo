package io.droksty.clinicmanagerdemo.view.insertform;


import io.droksty.clinicmanagerdemo.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class InsertFormController {
    private final Controller controller = new Controller();

    @FXML
    private TextField citizenIdField;
    @FXML
    private TextField lastnameField;
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;


    @FXML
    private void onSubmit() {
        controller.doInsert(citizenIdField.getText(), lastnameField.getText(), firstnameField.getText(), emailField.getText(), phoneField.getText());
    }
}
