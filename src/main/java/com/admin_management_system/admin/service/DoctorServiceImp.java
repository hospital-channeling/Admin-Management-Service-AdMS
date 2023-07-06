package com.admin_management_system.admin.service;

import com.admin_management_system.admin.entity.Doctor;
import com.admin_management_system.admin.repository.IDoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DoctorServiceImp implements IDoctorService{
    @Autowired
    private IDoctorRepository docRepo;

    @Override
    public Doctor addDoctor(Doctor doctor){
        return docRepo.save(doctor);
    }

    @Override
    public void deleteDoctor(int id){
        docRepo.deleteById(id);
    }

    @Override
    public List<Doctor> getAllDoctor(){
        return (List<Doctor>) docRepo.findAll();
    }

    @Override
    public Doctor getDoctorByID(int id){
        if(docRepo.findById(id).isPresent()){
            return docRepo.findById(id).get();
        }
        else{
            System.out.println("Doctor not found, " +id);
        }
        return null;
    }

    @Override
    public Doctor updateDoctor(int id, Doctor doctor){
        Optional<Doctor> currentDoc = docRepo.findById(id);
        Doctor updDoc = currentDoc.get();
        if(currentDoc.isPresent()){
            updDoc.setId(doctor.getId());
            updDoc.setFirst_name(doctor.getFirst_name());
            updDoc.setLast_name(doctor.getLast_name());
            updDoc.setSpecialization(doctor.getSpecialization());
            updDoc.setService_start_date(doctor.getService_start_date());
            updDoc.setAvailable_days_of_week(doctor.getAvailable_days_of_week());
            updDoc.setAvailable_time(doctor.getAvailable_time());
            updDoc.setGender(doctor.getGender());
            updDoc.setEmail(doctor.getEmail());
            updDoc.setContact(doctor.getContact());
            updDoc.setPassword(doctor.getPassword());
        }
        else{
            System.out.println("Doctor not found. ID = " +id);
        }
        return docRepo.save(updDoc);
    }
}
