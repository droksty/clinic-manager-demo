package io.droksty.clinicmanagerdemo.model;

public class Patient {
    private long id;
    private String citizenId;
    private String lastname;
    private String firstname;
    private String email;
    private String phoneNumber;

    public Patient() {}

    public Patient(long id, String citizenId, String lastname, String firstname, String email, String phoneNumber) {
        this.id = id;
        this.citizenId = citizenId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCitizenId() {
        return citizenId;
    }
    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
