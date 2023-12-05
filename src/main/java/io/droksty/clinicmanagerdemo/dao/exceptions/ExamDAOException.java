package io.droksty.clinicmanagerdemo.dao.exceptions;

/**
 * SQLException wrapper.
 */
public class ExamDAOException extends Exception {
    private final static long SerialVersionUID = 1L;

    public ExamDAOException(String s) {
        super(s);
    }
}
