package io.droksty.clinicmanagerdemo.service;

import io.droksty.clinicmanagerdemo.dao.IExamDAO;
import io.droksty.clinicmanagerdemo.dao.exceptions.ExamDAOException;
import io.droksty.clinicmanagerdemo.dto.ExamDTO;
import io.droksty.clinicmanagerdemo.model.Exam;
import io.droksty.clinicmanagerdemo.service.exceptions.ExamNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ExamServiceImpl implements IExamService {
    private final IExamDAO examDAO;

    public ExamServiceImpl(IExamDAO examDAO) {
        this.examDAO = examDAO;
    }


    /*                                              */
    /*                  Public API                  */
    /*                                              */

    @Override
    public Exam insertExam(ExamDTO examDTO) throws ExamDAOException {
        if (examDTO == null) return null;
        try {
            Exam exam = mapToEntity(examDTO);
            return examDAO.insert(exam);
        } catch (ExamDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Exam updateExam(ExamDTO examDTO) throws ExamDAOException, ExamNotFoundException {
        if (examDTO == null) return null;
        try {
            if (examDAO.getById(examDTO.getId()) == null) {
                throw new ExamNotFoundException("Exam with id " + examDTO.getId() + " was not found.");
            }
            Exam exam = mapToEntity(examDTO);
            return examDAO.update(exam);
        } catch (ExamDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteExam(long id) throws ExamDAOException, ExamNotFoundException {
        try {
            if (examDAO.getById(id) == null) {
                throw new ExamNotFoundException("Exam with id " + id + " was not found.");
            }
            examDAO.delete(id);
        } catch (ExamDAOException | ExamNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Exam> getExamsByCitizenID(String citizenID) throws ExamDAOException {
        List<Exam> exams = new ArrayList<>();
        try {
            exams = citizenID == null ? examDAO.getAll("") : examDAO.getAll(citizenID);
            return exams;
        } catch (ExamDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Exam getExamById(long id) throws ExamDAOException {
        Exam exam;
        try {
            exam = examDAO.getById(id);
            return exam;
        } catch (ExamDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }


    /*                                              */
    /*                 Helper Methods               */
    /*                                              */

    private Exam mapToEntity(ExamDTO examDTO) {
        return new Exam(
                examDTO.getId(),
                examDTO.getPatientId(),
                examDTO.getDate(),
                examDTO.getExam()
        );
    }
}
