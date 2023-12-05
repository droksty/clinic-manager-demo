package io.droksty.clinicmanagerdemo.dao;

import io.droksty.clinicmanagerdemo.dao.exceptions.ExamDAOException;
import io.droksty.clinicmanagerdemo.model.Exam;
import io.droksty.clinicmanagerdemo.service.util.DBUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExamDAOImpl implements IExamDAO {
    @Override
    public Exam insert(Exam exam) throws ExamDAOException {
        String sql = "INSERT INTO EXAMS (PATIENT_ID, DATE, RESULT) VALUES (?, ?, ?)";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, exam.getPatientId());
            statement.setString(2, exam.getDate().toString());
            statement.setString(3, exam.getExam());
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                exam.setId(keys.getLong(1));
            }
            return exam;
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new ExamDAOException("SQL error in " + exam + " insert.");
        }
    }

    @Override
    public Exam update(Exam exam) throws ExamDAOException {
        String sql = "UPDATE EXAMS SET PATIENT_ID=?, DATE=?, RESULT=? WHERE ID=?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, exam.getPatientId());
            statement.setString(2, exam.getDate().toString());
            statement.setString(3, exam.getExam());
            statement.setLong(4, exam.getId());
            statement.executeUpdate();
            return exam;
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new ExamDAOException("SQL error in " + exam + " update");
        }
    }

    @Override
    public void delete(long id) throws ExamDAOException {
        String sql = "DELETE FROM EXAMS WHERE ID=?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new ExamDAOException("SQL error in exam with id " + id + " delete.");
        }
    }

    @Override
    public List<Exam> getAll(String citizenID) throws ExamDAOException {
        String sql = "SELECT * FROM EXAMS WHERE citizenID=?";
        ResultSet resultSet;
        List<Exam> examList = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, citizenID);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Exam exam = new Exam(
                        resultSet.getLong("ID"),
                        resultSet.getLong("PATIENT_ID"),
                        LocalDate.parse(resultSet.getString("DATE")),
                        resultSet.getString("RESULT")
                );
                examList.add(exam);
            }
            return examList;
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new ExamDAOException("SQL error in exam with Citizen ID " + citizenID + " select.");
        }
    }

    @Override
    public Exam getById(long id) throws ExamDAOException {
        String sql = "SELECT * FROM EXAMS WHERE ID=?";
        Exam exam = null;
        ResultSet resultSet;
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                exam = new Exam(
                        resultSet.getLong("ID"),
                        resultSet.getLong("PATIENT_ID"),
                        LocalDate.parse(resultSet.getString("DATE")),
                        resultSet.getString("RESULT")
                );
            }
            return exam;
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new ExamDAOException("SQL error in exam with id " + id + " select.");
        }
    }
}
