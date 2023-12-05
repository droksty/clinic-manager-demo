package io.droksty.clinicmanagerdemo.dao;

import io.droksty.clinicmanagerdemo.dao.exceptions.ExamDAOException;
import io.droksty.clinicmanagerdemo.model.Exam;

import java.util.List;

public interface IExamDAO {
    Exam insert(Exam exam) throws ExamDAOException;
    Exam update(Exam exam) throws ExamDAOException;
    void delete(long id) throws ExamDAOException;
    List<Exam> getAll(String citizenID) throws ExamDAOException;
    Exam getById(long id) throws ExamDAOException;
}
