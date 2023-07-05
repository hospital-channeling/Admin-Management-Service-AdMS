package com.admin_management_system.admin.repository;

import com.admin_management_system.admin.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
    @Query(value = "SELECT * FROM Admin WHERE Id = ?1", nativeQuery = true)
    Appointment getAppointmentByAppointmentId(int appointmentId);
}
