package io.droksty.clinicmanagerdemo.view.root;

import io.droksty.clinicmanagerdemo.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class RootController {
    private final Controller controller = new Controller();

    @FXML
    private BorderPane borderPane;


    @FXML
    private void onInsertButtonClick() throws IOException {
        controller.setCenterView(borderPane, "InsertForm");
    }

    @FXML
    private void onListButtonClick() throws IOException {
        controller.setCenterView(borderPane, "PatientList");
    }
}
