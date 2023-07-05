package com.admin_management_system.admin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "doctor_availability")

public class DoctorAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "doctor_id", nullable = false)
    private int docId;
    @Column(name = "doc_date", nullable = false)
    private String docDate;
    @Column(name = "start_time", nullable = false)
    private String startTime;
    @Column(name = "end_time", nullable = false)
    private String endTime;
    @Column(name = "reason", nullable = false)
    private String reason;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    public enum Status{
        AVAIALBLE,
        UNAVAILABLE
    }

    public int getDocId() { return docId; }

    public void setDocId(int docId) { this.docId = docId; }

    public String getDocDate() { return docDate; }

    public void setDocDate(String docDate) { this.docDate = docDate; }

    public String getStartTime() { return startTime; }

    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }

    public void setEndTime(String endTime) { this.endTime = endTime; }

    public String getReason() { return reason; }

    public void setReason(String reason) { this.reason = reason; }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

}
