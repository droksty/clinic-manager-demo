package io.droksty.clinicmanagerdemo.view.patientlist;

import io.droksty.clinicmanagerdemo.controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class PatientListController {
    private final Controller controller = new Controller();

    @FXML private TextField lastnameField;
    @FXML private TextField citizenIdField;
    @FXML private TableView<Object> tableView;


    @FXML
    private void initialize() {
        tableView.setPlaceholder(new Label(""));
    }


    // Event Handlers
    @FXML
    private void onSearchWithLastnameButtonClick() {
        controller.doSearchAll(tableView, lastnameField.getText());
    }

    @FXML
    private void onSearchWithCitizenIdButtonClick() {
        controller.doSearchOne(tableView, citizenIdField.getText());
    }

    @FXML
    private void onUpdateButtonClick(ActionEvent actionEvent) {
        System.out.println("Not implemented yet");
    }

    @FXML
    private void onDeleteButtonClick() {
        controller.doDelete(tableView);
    }
}
