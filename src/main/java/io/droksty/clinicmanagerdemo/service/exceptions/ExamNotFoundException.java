package io.droksty.clinicmanagerdemo.service.exceptions;

import io.droksty.clinicmanagerdemo.model.Exam;

public class ExamNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public ExamNotFoundException(Exam exam) {
        super("Exam with id " + exam.getId() + " does not exist.");
    }

    public ExamNotFoundException(String message) {
        super(message);
    }
}
