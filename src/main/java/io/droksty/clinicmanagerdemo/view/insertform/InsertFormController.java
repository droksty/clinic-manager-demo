package io.droksty.clinicmanagerdemo.view.insertform;


import io.droksty.clinicmanagerdemo.controller.Controller;
import io.droksty.clinicmanagerdemo.dto.PatientDTOFactory;
import io.droksty.clinicmanagerdemo.dto.PatientDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private Button submitButton;
    @FXML
    private Button backButton;


    @FXML
    private void onFormSubmit() {
        PatientDTO dto = PatientDTOFactory.createFromUserInput(
                citizenIdField.getText(),
                lastnameField.getText(),
                firstnameField.getText(),
                emailField.getText(),
                phoneField.getText()
        );
        controller.doInsert(dto);
    }
}
