package com.admin_management_system.admin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "user_id", nullable = false)
    private int userId;
    @Column(name = "first_name", nullable = false)
    private String userFirstName;
    @Column(name = "last_name", nullable = false)
    private String userLastName;
    @Column(name = "address", nullable = false)
    private String userAddress;
    @Column(name = "birthdate", nullable = false)
    private String userBirthdate;
    @Column(name = "gender", nullable = false)
    private String userGender;
    @Column(name = "email", nullable = false)
    private String userEmail;
    @Column(name = "contact", nullable = false)
    private String userContactNum;
    @Column(name = "password", nullable = false)
    private String userPassword;

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public String getUserFirstName() { return userFirstName; }

    public void setUserFirstName(String userFirstName) { this.userFirstName = userFirstName; }

    public String getUserLastName() { return userLastName; }

    public void setUserLastName(String userLastName) { this.userLastName = userLastName; }

    public String getUserAddress() { return userAddress; }

    public void setUserAddress(String userAddress) { this.userAddress = userAddress; }

    public String getUserBirthdate() { return userBirthdate; }

    public void setUserBirthdate(String userBirthdate) { this.userBirthdate = userBirthdate; }

    public String getUserGender() { return userGender; }

    public void setUserGender(String userGender) { this.userGender = userGender; }

    public String getUserEmail() { return userEmail; }

    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getUserContactNum() { return userContactNum; }

    public void setUserContactNum(String userContactNum) { this.userContactNum = userContactNum; }

    public String getUserPassword() { return userPassword; }

    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

}
