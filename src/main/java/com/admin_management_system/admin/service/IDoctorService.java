package com.admin_management_system.admin.service;

import com.admin_management_system.admin.entity.Doctor;

import java.util.List;

public interface IDoctorService {
    Doctor addDoctor(Doctor doctor);

    void deleteDoctor(int id);

    List<Doctor> getAllDoctor();

    Doctor getDoctorByID(int id);

    Doctor updateDoctor(int id, Doctor doctor);
}
