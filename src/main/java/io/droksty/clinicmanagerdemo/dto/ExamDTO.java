package io.droksty.clinicmanagerdemo.dto;

import java.time.LocalDate;

public class ExamDTO {
    private long id;
    private long patientId;
    private LocalDate date;
    private String exam;

    public ExamDTO() {}

    public ExamDTO(long id, long patientId, LocalDate date, String exam) {
        this.id = id;
        this.patientId = patientId;
        this.date = date;
        this.exam = exam;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getPatientId() {
        return patientId;
    }
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getExam() {
        return exam;
    }
    public void setExam(String exam) {
        this.exam = exam;
    }

    @Override
    public String toString() {
        return "ExamDTO{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", date=" + date +
                ", exam='" + exam + '\'' +
                '}';
    }
}
