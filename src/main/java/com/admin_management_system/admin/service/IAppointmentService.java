package com.admin_management_system.admin.service;

import com.admin_management_system.admin.entity.Appointment;

import java.util.List;

public interface IAppointmentService {
    List<Appointment> getAllAppointment();

    Appointment getAppointmentByID(int id);
}
