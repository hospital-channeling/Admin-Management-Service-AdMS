package com.admin_management_system.admin.controller;

import com.admin_management_system.admin.entity.Doctor;
import com.admin_management_system.admin.service.DoctorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping(value = "/api/doctor")

public class DoctorController {
    @Autowired
    DoctorServiceImp docService;

    //create a new doctor
    @PostMapping("/saveDoctor")
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return docService.addDoctor(doctor);
    }

    //delete a doctor
    @DeleteMapping("/deleteDoctor/{id}")
    public void deleteDoctor(@PathVariable int id){
        docService.deleteDoctor(id);
    }

    //update an existing doctor
    @PutMapping("/updateDoctor/{id}")
    public Doctor updateDoctor(@PathVariable int id, @RequestBody Doctor doctor){
        return docService.updateDoctor(id, doctor);
    }

    //retrieve a doctor by id
    @GetMapping("/getDoctorByID/{id}")
    public Doctor getDoctorByID(@PathVariable int id){
        return docService.getDoctorByID(id);
    }

    //retrieve all the doctors
    @GetMapping("/getDoctor")
    public List<Doctor> getallDoctors(){
        return docService.getAllDoctor();
    }
}
