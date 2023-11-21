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

    public void doInsert(PatientDTO dto) {
        try {
            service.insertPatient(dto);
        } catch (PatientDAOException e) {
            e.printStackTrace();
        }
    }
}
