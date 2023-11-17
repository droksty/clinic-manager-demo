package io.droksty.clinicmanagerdemo.service;

import io.droksty.clinicmanagerdemo.dao.IPatientDAO;
import io.droksty.clinicmanagerdemo.dao.exceptions.PatientDAOException;
import io.droksty.clinicmanagerdemo.model.Patient;
import io.droksty.clinicmanagerdemo.service.exceptions.PatientNotFoundException;
import io.droksty.clinicmanagerdemo.dto.PatientDTO;

import java.util.ArrayList;
import java.util.List;

public class PatientServiceImpl implements IPatientService {
    private final IPatientDAO patientDAO;

    public PatientServiceImpl(IPatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    // Public API
    @Override
    public Patient insertPatient(PatientDTO patientDTO) throws PatientDAOException {
        if (patientDTO == null) return null;
        try {
            Patient patient = mapToEntity(patientDTO);
            return patientDAO.insert(patient);
        } catch (PatientDAOException exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    @Override
    public Patient updatePatient(PatientDTO patientDTO) throws PatientDAOException, PatientNotFoundException {
        if (patientDTO == null) return null;
        try {
            if (patientDAO.getById(patientDTO.getId()) == null) {
                throw new PatientNotFoundException("Patient with id " + patientDTO.getId() + " was not found.");
            }
            Patient patient = mapToEntity(patientDTO);
            return patientDAO.update(patient);
        } catch (PatientDAOException | PatientNotFoundException exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    @Override
    public void deletePatient(long id) throws PatientDAOException, PatientNotFoundException {
        try {
            if (patientDAO.getById(id) == null) {
                throw new PatientNotFoundException("Patient with id " + id + " was not found.");
            }
            patientDAO.delete(id);
        } catch (PatientDAOException | PatientNotFoundException exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    @Override
    public List<Patient> getPatientsByLastname(String lastname) throws PatientDAOException {
        List<Patient> patients = new ArrayList<>();
        if (lastname == null) return patients;
        try {
            patients = patientDAO.getByLastName(lastname);
            return patients;
        } catch (PatientDAOException exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    @Override
    public Patient getPatientByCitizenID(String citizenID) throws PatientDAOException {
        Patient patient = null;
        if (citizenID == null) return patient;
        try {
            patient = patientDAO.getByCitizenId(citizenID);
            return patient;
        } catch (PatientDAOException exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    private Patient mapToEntity(PatientDTO patientDTO) {
        return new Patient(
                patientDTO.getId(),
                patientDTO.getCitizenId(),
                patientDTO.getLastname(),
                patientDTO.getFirstname(),
                patientDTO.getEmail(),
                patientDTO.getPhoneNumber()
        );
    }
}
