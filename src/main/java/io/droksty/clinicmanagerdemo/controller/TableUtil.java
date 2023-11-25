package io.droksty.clinicmanagerdemo.controller;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class TableUtil {
    private static TableColumn<Object, String> citizenIdCol;
    private static TableColumn<Object, String> lastnameCol;
    private static TableColumn<Object, String> firstnameCol;
    private static TableColumn<Object, String> emailCol;
    private static TableColumn<Object, String> phoneCol;


    private TableUtil() {}


    public static List<TableColumn<Object, String>> fetchColumns() {
        return List.of(getCitizenIdCol(), getLastnameCol(), getFirstnameCol(), getEmailCol(), getPhoneCol());
    }


    public static TableColumn<Object, String> getCitizenIdCol() {
        if (citizenIdCol == null) {
            citizenIdCol = new TableColumn<>("Citizen ID");
            citizenIdCol.setCellValueFactory(new PropertyValueFactory<>("citizenId"));
        }
        return citizenIdCol;
    }

    public static TableColumn<Object, String> getLastnameCol() {
        if (lastnameCol == null) {
            lastnameCol =  new TableColumn<>("Last Name");
            lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        }
        return lastnameCol;
    }

    public static TableColumn<Object, String> getFirstnameCol() {
        if (firstnameCol == null) {
            firstnameCol = new TableColumn<>("First Name");
            firstnameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        }
        return firstnameCol;
    }

    public static TableColumn<Object, String> getEmailCol() {
        if (emailCol == null) {
            emailCol = new TableColumn<>("e-mail");
            emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        }
        return emailCol;
    }

    public static TableColumn<Object, String> getPhoneCol() {
        if (phoneCol == null) {
            phoneCol = new TableColumn<>("Phone");
            phoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        }
        return phoneCol;
    }

}
