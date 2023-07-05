package com.admin_management_system.admin.controller;

import com.admin_management_system.admin.entity.Appointment;
import com.admin_management_system.admin.repository.IAppointmentRepository;
import com.admin_management_system.admin.service.AppointmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping(value = "/api/appointment")

public class AppointmentController {
    private final IAppointmentRepository appointmentRepo;
    @Autowired
    private AppointmentServiceImp appService;

    public AppointmentController(IAppointmentRepository appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    //retrieve all the appointments
    @GetMapping("/appointment")
    public List<Appointment> getallAppointments(){ return appService.getAllAppointment(); }

    //retrieve an appointment by id
    @GetMapping("/appointment/{id}")
    public Appointment getAppByID(@PathVariable int id){ return appService.getAppointmentByID(id); }

    //approve an appointment
    @PutMapping("/{id}/approve")
    public Appointment approveAppointment(int id){
        Appointment appointment = appointmentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid appointment id : " +id));
        appointment.setStatus("approved");
        return appointmentRepo.save(appointment);
    }

    //reject an appointment
    @PutMapping("/{id}/reject")
    public Appointment rejectAppointment(int id){
        Appointment appointment = appointmentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid appointment id : " +id));
        appointment.setStatus("reject");
        return appointmentRepo.save(appointment);
    }
}
