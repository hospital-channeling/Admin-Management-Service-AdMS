package com.admin_management_system.admin.repository;

import com.admin_management_system.admin.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPatientRepository extends JpaRepository<Patient, Integer> {
    @Query(value = "SELECT * FROM Admin WHERE Id = ?1", nativeQuery = true)
    Patient getPatientById(int patientId);
}
