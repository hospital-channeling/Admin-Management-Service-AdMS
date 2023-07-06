package com.admin_management_system.admin.controller;

import com.admin_management_system.admin.entity.Admin;
import com.admin_management_system.admin.entity.Receptionist;
import com.admin_management_system.admin.service.ReceptionistServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping(value = "/api/receptionist")

public class ReceptionistController {
    @Autowired
    private ReceptionistServiceImp recepService;

    //create a new receptionist
    @PostMapping("/createReceptionist")
    public Receptionist createRecep(@RequestBody Receptionist receptionist){
        return recepService.addReceptionist(receptionist);
    }

    //delete a receptionist
    @DeleteMapping("/receptionist/{id}")
    public void deleteReceptionist(@PathVariable int id){
        recepService.deleteReceptionist(id);
    }

    //update an existing receptionist
    @PutMapping("/receptionist/{id}")
    public Receptionist updateReceptionist(@PathVariable int id, @RequestBody Receptionist receptionist){
        return recepService.updateReceptionist(id, receptionist);
    }

    //retrieve a receptionist by id
    @GetMapping("/receptionist/{id}")
    public Receptionist getReceptionistByID(@PathVariable int id){
        return recepService.getReceptionistByID(id);
    }

    //retrieve all the receptionists
    @GetMapping("/receptionist")
    public List<Receptionist> getallReceptionist(){
        return recepService.getAllReceptionist();
    }
}
