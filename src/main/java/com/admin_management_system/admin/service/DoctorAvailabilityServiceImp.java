package com.admin_management_system.admin.service;

import com.admin_management_system.admin.entity.DoctorAvailability;
import com.admin_management_system.admin.repository.IDoctorAvailabilityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class DoctorAvailabilityServiceImp implements IDoctorAvailabilityService {
    @Autowired
    private IDoctorAvailabilityRepository docRepo;

    public DoctorAvailability addDoctorAvb(DoctorAvailability doctor){ return docRepo.save(doctor); }

    @Override
    public void deleteDoctorAvb(int id){ docRepo.deleteById(id);}

    @Override
    public DoctorAvailability updateDoctorAvb(int id, DoctorAvailability doctor){
        Optional<DoctorAvailability> currentDoctor = docRepo.findById(id);
        DoctorAvailability updDoc = currentDoctor.get();
        if(currentDoctor.isPresent()){
            updDoc.setDocId(doctor.getDocId());
            updDoc.setDocDate(doctor.getDocDate());
            updDoc.setStartTime(doctor.getStartTime());
            updDoc.setEndTime(doctor.getEndTime());
            updDoc.setReason(doctor.getReason());
            updDoc.setStatus(doctor.getStatus());
        }
        else{
            System.out.println("Doctor not found. ID = " +id);
        }
        return docRepo.save(updDoc);
    }

    @Override
    public boolean existsById(int id){
        return docRepo.existsById(id);
    }

}
