package com.admin_management_system.admin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "admin")

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "admin_ID")
    private int adminId;
    @Column(name = "first_name", nullable = false)
    private String adFirstName;
    @Column(name = "last_name", nullable = false)
    private String adLastName;
    @Column(name = "contact_num", nullable = false)
    private String adContactNum;
    @Column(name = "email", nullable = false)
    private String adEmail;
    @Column(name = "password", nullable = false)
    private String adPassword;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int id) {
        this.adminId = id;
    }

    public String getFirst_name() {
        return adFirstName;
    }

    public void setFirst_name(String first_name) {
        this.adFirstName = first_name;
    }

    public String getLast_name() {
        return adLastName;
    }

    public void setLast_name(String last_name) {
        this.adLastName = last_name;
    }

    public String getContact_num() {
        return adContactNum;
    }

    public void setContact_num(String contact_num) {
        this.adContactNum = contact_num;
    }

    public String getEmail() {
        return adEmail;
    }

    public void setEmail(String email) {
        this.adEmail = email;
    }

    public String getPassword() {
        return adPassword;
    }

    public void setPassword(String password) {
        this.adPassword = password;
    }

}
