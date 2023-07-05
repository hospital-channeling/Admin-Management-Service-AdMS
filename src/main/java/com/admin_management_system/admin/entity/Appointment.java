package com.admin_management_system.admin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "appointment_management")

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "appointment_id", nullable = false)
    private int appointmentId;
    @Column(name = "doctor_id", nullable = false)
    private int doctorId;
    @Column(name = "patient_id", nullable = false)
    private int patientId;
    @Column(name = "app_date", nullable = false)
    private String appDate;
    @Column(name = "start_time", nullable = false)
    private String startTime;
    @Column(name = "end_time", nullable = false)
    private String endTime;
    @Column(name = "status", nullable = false)
    private String status;

    public int getAppointmentId() { return appointmentId; }

    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public int getDoctorId() { return doctorId; }

    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public int getPatientId() { return patientId; }

    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getAppDate() { return appDate; }

    public void setAppDate(String appDate) { this.appDate = appDate; }

    public String getStartTime() { return startTime;}

    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }

    public void setEndTime(String endTime) { this.endTime = endTime; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
