package com.admin_management_system.admin.service;

import com.admin_management_system.admin.entity.DoctorAvailability;

public interface IDoctorAvailabilityService {
    DoctorAvailability addDoctorAvb(DoctorAvailability doctor);

    void deleteDoctorAvb(int id);

    DoctorAvailability updateDoctorAvb(int id, DoctorAvailability doctor);

    boolean existsById(int id);
}
