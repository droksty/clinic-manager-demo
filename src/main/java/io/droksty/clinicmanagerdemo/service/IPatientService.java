package io.droksty.clinicmanagerdemo.service;

import io.droksty.clinicmanagerdemo.dao.exceptions.PatientDAOException;
import io.droksty.clinicmanagerdemo.model.Patient;
import io.droksty.clinicmanagerdemo.service.exceptions.PatientNotFoundException;
import io.droksty.clinicmanagerdemo.dto.PatientDTO;

import java.util.List;

public interface IPatientService {
    Patient insertPatient(PatientDTO patientDTO) throws PatientDAOException;
    Patient updatePatient(PatientDTO patientDTO) throws PatientDAOException, PatientNotFoundException;
    void deletePatient(long id) throws PatientDAOException, PatientNotFoundException;
    List<Patient> getPatientsByLastname(String lastname) throws PatientDAOException;
    Patient getPatientByCitizenID(String citizenID) throws PatientDAOException;
}
