package io.droksty.clinicmanagerdemo.controller;

import io.droksty.clinicmanagerdemo.dao.IPatientDAO;
import io.droksty.clinicmanagerdemo.dao.PatientDAOImpl;
import io.droksty.clinicmanagerdemo.dao.exceptions.PatientDAOException;
import io.droksty.clinicmanagerdemo.dto.PatientDTO;
import io.droksty.clinicmanagerdemo.model.Patient;
import io.droksty.clinicmanagerdemo.service.IPatientService;
import io.droksty.clinicmanagerdemo.service.PatientServiceImpl;
import io.droksty.clinicmanagerdemo.service.exceptions.PatientNotFoundException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.List;

public class Controller {
    private final IPatientDAO dao = new PatientDAOImpl();
    private final IPatientService service = new PatientServiceImpl(dao);


    /**
     *     Section - View related API
     */

    public void setCenterView(BorderPane borderPane, String view) throws IOException {
        if (view.equals("InsertForm")) {
            borderPane.setCenter(new FXMLLoader(getClass()
                    .getResource("/io/droksty/clinicmanagerdemo/view/insertform/InsertForm.fxml")).load());
        } else {
            borderPane.setCenter(new FXMLLoader(getClass()
                    .getResource("/io/droksty/clinicmanagerdemo/view/patientlist/PatientList.fxml")).load());
        }
    }


    /**
     *     Section - Domain related API
     */

    public void doInsert(String citizenId, String lastname, String firstname, String email, String phoneNum) {
        PatientDTO dto = createFromUserInput(citizenId, lastname, firstname, email, phoneNum);
        try {
            service.insertPatient(dto);
        } catch (PatientDAOException e) {
            e.printStackTrace();
        }
    }

    public void doSearchAll(TableView<Object> tableView, String lastname) {
        List<Patient> patientList;
        try {
            patientList = service.getPatientsByLastname(lastname);
        } catch (PatientDAOException e) {
            throw new RuntimeException(e);
        }
        tableView.getColumns().setAll(TableUtil.fetchColumns());
        tableView.getItems().setAll(patientList);
    }

    public void doSearchOne(TableView<Object> tableView, String citizenId) {
        Patient patient;
        try {
            patient = service.getPatientByCitizenID(citizenId);
        } catch (PatientDAOException e) {
            throw new RuntimeException(e);
        }

        if (patient != null) {
            tableView.getColumns().setAll(TableUtil.fetchColumns());
            tableView.getItems().setAll(patient);
        } else {
            tableView.getColumns().clear();
        }
    }

    public void doDelete(TableView<?> tableView) {
        try {
            service.deletePatient(getIdFromObject(tableView));
            tableView.getItems().remove(tableView.getSelectionModel().getSelectedItem());
        } catch (PatientDAOException | PatientNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *     Section - Helped methods
     */

    private PatientDTO createFromUserInput(String citizenId, String lastname, String firstname, String email, String phoneNum) {
        PatientDTO dto = new PatientDTO();
        dto.setCitizenId(citizenId);
        dto.setLastname(lastname);
        dto.setFirstname(firstname);
        dto.setEmail(email);
        dto.setPhoneNumber(phoneNum);
        return dto;
    }

    private long getIdFromObject(TableView<?> tableView) {
        Patient patient = (Patient) tableView.getSelectionModel().getSelectedItem();
        return patient.getId();
    }
}
