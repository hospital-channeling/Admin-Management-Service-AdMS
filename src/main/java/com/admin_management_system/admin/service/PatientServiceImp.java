package com.admin_management_system.admin.service;

import com.admin_management_system.admin.entity.Patient;
import com.admin_management_system.admin.repository.IPatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientServiceImp implements IPatientService{
    @Autowired
    private IPatientRepository patientRepo;

    @Override
    public Patient addPatient(Patient patient){
        return patientRepo.save(patient);
    }

    @Override
    public void deletePatient(int id){
        patientRepo.deleteById(id);
    }

    @Override
    public List<Patient> getAllPatient(){
        return (List<Patient>) patientRepo.findAll();
    }

    @Override
    public Patient getPatientByID(int id){
        if(patientRepo.findById(id).isPresent()){
            return patientRepo.findById(id).get();
        }
        else{
            System.out.println("Patient not found, " +id);
        }
        return null;
    }

    @Override
    public Patient updatePatient(int id, Patient patient){
        Optional<Patient> currentPatient = patientRepo.findById(id);
        Patient updPatient = currentPatient.get();
        if(currentPatient.isPresent()){
            updPatient.setId(patient.getId());
            updPatient.setFirst_name(patient.getFirst_name());
            updPatient.setLast_name(patient.getLast_name());
            updPatient.setAddress(patient.getAddress());
            updPatient.setBirthdate(patient.getBirthdate());
            updPatient.setGender(patient.getGender());
            updPatient.setEmail(patient.getEmail());
            updPatient.setContact(patient.getContact());
            updPatient.setContact(patient.getContact());
            updPatient.setPassword(patient.getPassword());
        }
        else{
            System.out.println("Patient not found. ID = " +id);
        }
        return patientRepo.save(updPatient);
    }
}
