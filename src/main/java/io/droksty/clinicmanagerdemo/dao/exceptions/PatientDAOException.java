package io.droksty.clinicmanagerdemo.dao.exceptions;

/**
 * SQLException wrapper.
 */
public class PatientDAOException extends Exception {
    private final static long SerialVersionUID = 1L;

    public PatientDAOException(String s) {
        super(s);
    }
}
