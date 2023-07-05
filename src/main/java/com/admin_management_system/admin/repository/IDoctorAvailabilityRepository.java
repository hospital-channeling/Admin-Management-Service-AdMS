package com.admin_management_system.admin.repository;

import com.admin_management_system.admin.entity.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IDoctorAvailabilityRepository extends JpaRepository<DoctorAvailability, Integer> {
    @Query(value = "SELECT * FROM Admin WHERE Id = ?1", nativeQuery = true)
    DoctorAvailability getDoctorByDocId(int docID);
}
