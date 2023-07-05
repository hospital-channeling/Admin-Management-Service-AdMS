package com.admin_management_system.admin.service;

import com.admin_management_system.admin.entity.Appointment;
import com.admin_management_system.admin.repository.IAppointmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AppointmentServiceImp implements IAppointmentService{
    @Autowired
    private IAppointmentRepository appointmentRepo;

    @Override
    public List<Appointment> getAllAppointment(){
        return (List<Appointment>) appointmentRepo.findAll();
    }

    @Override
    public Appointment getAppointmentByID(int id){
        if(appointmentRepo.findById(id).isPresent()){
            return appointmentRepo.findById(id).get();
        }
        else {
            System.out.println("Appointment not found. ID = "+id);
        }
        return null;
    }

}
