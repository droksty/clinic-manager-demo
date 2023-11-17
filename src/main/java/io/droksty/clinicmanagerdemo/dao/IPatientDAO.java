package io.droksty.clinicmanagerdemo.dao;

import io.droksty.clinicmanagerdemo.dao.exceptions.PatientDAOException;
import io.droksty.clinicmanagerdemo.model.Patient;

import java.util.List;

public interface IPatientDAO {
    Patient insert(Patient patient) throws PatientDAOException;
    Patient update(Patient patient) throws PatientDAOException;
    void delete(long id) throws PatientDAOException;
    List<Patient> getByLastName(String lastname) throws PatientDAOException;
    Patient getById(long id) throws PatientDAOException;
    Patient getByCitizenId(String citizenId) throws PatientDAOException;
}
