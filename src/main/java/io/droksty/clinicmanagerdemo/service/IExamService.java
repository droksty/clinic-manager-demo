package io.droksty.clinicmanagerdemo.service;



import io.droksty.clinicmanagerdemo.dao.exceptions.ExamDAOException;
import io.droksty.clinicmanagerdemo.dto.ExamDTO;
import io.droksty.clinicmanagerdemo.model.Exam;
import io.droksty.clinicmanagerdemo.service.exceptions.ExamNotFoundException;

import java.util.List;

public interface IExamService {
    Exam insertExam(ExamDTO examDTO) throws ExamDAOException;
    Exam updateExam(ExamDTO examDTO) throws ExamDAOException, ExamNotFoundException;
    void deleteExam(long id) throws ExamDAOException, ExamNotFoundException;
    List<Exam> getExamsByCitizenID(String citizenID) throws ExamDAOException;
    Exam getExamById(long id) throws ExamDAOException;
}
