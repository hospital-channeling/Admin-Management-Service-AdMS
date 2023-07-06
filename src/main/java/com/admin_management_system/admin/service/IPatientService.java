package com.admin_management_system.admin.service;

import com.admin_management_system.admin.entity.Patient;

import java.util.List;

public interface IPatientService {
    Patient addPatient(Patient patient);

    void deletePatient(int id);

    List<Patient> getAllPatient();

    Patient getPatientByID(int id);

    Patient updatePatient(int id, Patient patient);
}
