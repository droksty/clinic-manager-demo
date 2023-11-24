package io.droksty.clinicmanagerdemo.controller;

import io.droksty.clinicmanagerdemo.dao.IPatientDAO;
import io.droksty.clinicmanagerdemo.dao.PatientDAOImpl;
import io.droksty.clinicmanagerdemo.dao.exceptions.PatientDAOException;
import io.droksty.clinicmanagerdemo.dto.PatientDTO;
import io.droksty.clinicmanagerdemo.model.Patient;
import io.droksty.clinicmanagerdemo.service.IPatientService;
import io.droksty.clinicmanagerdemo.service.PatientServiceImpl;
import javafx.scene.control.TableView;

import java.util.List;

public class Controller {
    private final IPatientDAO dao = new PatientDAOImpl();
    private final IPatientService service = new PatientServiceImpl(dao);


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

    // Helper
    private PatientDTO createFromUserInput(String citizenId, String lastname, String firstname, String email, String phoneNum) {
        PatientDTO dto = new PatientDTO();
        dto.setCitizenId(citizenId);
        dto.setLastname(lastname);
        dto.setFirstname(firstname);
        dto.setEmail(email);
        dto.setPhoneNumber(phoneNum);
        return dto;
    }
}
