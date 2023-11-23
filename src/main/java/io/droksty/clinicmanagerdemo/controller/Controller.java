package io.droksty.clinicmanagerdemo.controller;

import io.droksty.clinicmanagerdemo.dao.IPatientDAO;
import io.droksty.clinicmanagerdemo.dao.PatientDAOImpl;
import io.droksty.clinicmanagerdemo.dao.exceptions.PatientDAOException;
import io.droksty.clinicmanagerdemo.dto.PatientDTO;
import io.droksty.clinicmanagerdemo.service.IPatientService;
import io.droksty.clinicmanagerdemo.service.PatientServiceImpl;

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
