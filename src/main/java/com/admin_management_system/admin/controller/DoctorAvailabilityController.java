package com.admin_management_system.admin.controller;

import com.admin_management_system.admin.entity.DoctorAvailability;
import com.admin_management_system.admin.service.DoctorAvailabilityServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/doctors/{doctorId}/availability")

public class DoctorAvailabilityController {
    @Autowired
    private DoctorAvailabilityServiceImp docAvbService;

    //creating a new doctor availability
    @PostMapping("/createDocAvailability/{id}")
    public DoctorAvailability createDocAvb(@PathVariable int docId, @RequestBody DoctorAvailability doctorAvb){
        doctorAvb.setDocId(docId);
        return docAvbService.addDoctorAvb(doctorAvb);
    }

    //delete a doctor availability
    @DeleteMapping("/deleteDocAvailability/{id}")
    public void deleteDocAvb(@PathVariable int id){
        if(docAvbService.existsById(id)){
            docAvbService.deleteDoctorAvb(id);
        }
        else{
            System.out.printf("Doctor Availability ID not found");
        }
    }

    //update an existing doctor availability
    @PutMapping("/updateDocAvailability/{id}")
    public DoctorAvailability updateDocAvb(@PathVariable int docId, @PathVariable int availabilityID, @RequestBody DoctorAvailability docAvb){
        if(docAvbService.existsById(availabilityID)){
            docAvb.setDocId(docId);
            docAvb.setId(availabilityID);
        }
        return docAvbService.updateDoctorAvb(docId, docAvb);
    }

}
