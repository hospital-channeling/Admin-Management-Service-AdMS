package com.admin_management_system.admin.controller;

import com.admin_management_system.admin.entity.Patient;
import com.admin_management_system.admin.service.PatientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping(value = "/api/patient")

public class PatientController {
    @Autowired
    private PatientServiceImp patientService;

    //create a new patient
    @PostMapping("/saveUser")
    public Patient createPatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }

    //delete a patient
    @DeleteMapping("/deleteUser/{id}")
    public void deletePatient(@PathVariable int id){
        patientService.deletePatient(id);
    }

    //update an existing patient
    @PutMapping("/updateUser/{id}")
    public Patient updatePatient(@PathVariable int id, @RequestBody Patient patient){
        return patientService.updatePatient(id, patient);
    }

    //retrieve a patient by id
    @GetMapping("/getUSerById/{id}")
    public Patient getUserByID(@PathVariable int id){
        return patientService.getPatientByID(id);
    }

    //retrieve all the patients
    @GetMapping("/getUser")
    public List<Patient> getallPatients(){
        return patientService.getAllPatient();
    }
}
