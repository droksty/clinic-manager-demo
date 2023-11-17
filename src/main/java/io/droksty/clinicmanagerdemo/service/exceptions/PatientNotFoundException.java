package io.droksty.clinicmanagerdemo.service.exceptions;

import io.droksty.clinicmanagerdemo.model.Patient;

public class PatientNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public PatientNotFoundException(Patient patient) {
        super("Patient with id " + patient.getId() + " does not exist.");
    }

    public PatientNotFoundException(String message) {
        super(message);
    }
}
