package com.admin_management_system.admin.repository;

import com.admin_management_system.admin.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
    @Query(value = "SELECT * FROM Admin WHERE Id = ?1", nativeQuery = true)
    Doctor getDoctorById(int docId);
}
