package io.droksty.clinicmanagerdemo.dao;


import io.droksty.clinicmanagerdemo.dao.exceptions.PatientDAOException;
import io.droksty.clinicmanagerdemo.model.Patient;
import io.droksty.clinicmanagerdemo.service.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements IPatientDAO {
    @Override
    public Patient insert(Patient patient) throws PatientDAOException {
        String sql = "INSERT INTO PATIENTS (CITIZENID, LASTNAME, FIRSTNAME, EMAIL, PHONE) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, patient.getCitizenId());
            statement.setString(2, patient.getLastname());
            statement.setString(3, patient.getFirstname());
            statement.setString(4, patient.getEmail());
            statement.setString(5, patient.getPhoneNumber());
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                patient.setId(keys.getLong(1));
            }
            return patient;
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new PatientDAOException("SQL error in " + patient + " insert.");
        }
    }

    @Override
    public Patient update(Patient patient) throws PatientDAOException {
        String sql = "UPDATE PATIENTS SET CITIZENID=?, LASTNAME=?, FIRSTNAME=?, EMAIL=?, PHONE=? WHERE ID=?";
        try (Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, patient.getCitizenId());
            statement.setString(2, patient.getLastname());
            statement.setString(3, patient.getFirstname());
            statement.setString(4, patient.getEmail());
            statement.setString(5, patient.getPhoneNumber());
            statement.setLong(6, patient.getId());
            statement.executeUpdate();
            return patient;
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new PatientDAOException("SQL error in " + patient + " update");
        }
    }

    @Override
    public void delete(long id) throws PatientDAOException {
        String sql = "DELETE FROM PATIENTS WHERE ID=?";
        try (Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new PatientDAOException("SQL error in patient with id " + id + " delete.");
        }
    }

    @Override
    public List<Patient> getByLastName(String lastname) throws PatientDAOException {
        String sql = "SELECT * FROM PATIENTS WHERE LASTNAME LIKE ?";
        ResultSet resultSet;
        List<Patient> patients = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lastname + '%');
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Patient patient = new Patient(
                        resultSet.getLong("ID"),
                        resultSet.getString("CITIZENID"),
                        resultSet.getString("LASTNAME"),
                        resultSet.getString("FIRSTNAME"),
                        resultSet.getString("EMAIL"),
                        resultSet.getString("PHONE")
                );
                patients.add(patient);
            }
            return patients;
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new PatientDAOException("SQL error in patient with lastname " + lastname + " select.");
        }
    }

    @Override
    public Patient getById(long id) throws PatientDAOException {
        String sql = "SELECT * FROM PATIENTS WHERE ID=?";
        Patient patient = null;
        ResultSet resultSet;
        try (Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                patient = new Patient(
                        resultSet.getLong("ID"),
                        resultSet.getString("CITIZENID"),
                        resultSet.getString("LASTNAME"),
                        resultSet.getString("FIRSTNAME"),
                        resultSet.getString("EMAIL"),
                        resultSet.getString("PHONE")
                );
            }
            return patient;
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new PatientDAOException("SQL error in patient with id " + id + " select.");
        }
    }

    @Override
    public Patient getByCitizenId(String citizenId) throws PatientDAOException {
        String sql = "SELECT * FROM PATIENTS WHERE CITIZENID=?";
        Patient patient = null;
        ResultSet resultSet;
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, citizenId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                patient = new Patient(
                        resultSet.getLong("ID"),
                        resultSet.getString("CITIZENID"),
                        resultSet.getString("LASTNAME"),
                        resultSet.getString("FIRSTNAME"),
                        resultSet.getString("EMAIL"),
                        resultSet.getString("PHONE")
                );
            }
            return patient;
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new PatientDAOException("SQL error in patient with citizenId " + citizenId + " select.");
        }
    }
}
