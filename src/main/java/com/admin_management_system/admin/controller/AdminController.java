package com.admin_management_system.admin.controller;

import com.admin_management_system.admin.entity.Admin;
import com.admin_management_system.admin.service.AdminServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping(value = "/api/admin")

public class AdminController {
    @Autowired
    private AdminServiceImp adminService;

    //create a new admin
    @PostMapping("/createAdmin")
    public Admin createAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }

    //delete an admin
    @DeleteMapping("/admin/{id}")
    public void deleteAdmin(@PathVariable int id){
        adminService.deleteAdmin(id);
    }

    //update an existing admin
    @PutMapping("/admin/{id}")
    public Admin updateAdmin(@PathVariable int id, @RequestBody Admin admin){
        return adminService.updateAdmin(id, admin);
    }

    //retrieve an admin by id
    @GetMapping("/admin/{id}")
    public Admin getAdminByID(@PathVariable int id){
        return adminService.getAdminByID(id);
    }

    //retrieve all the admins
    @GetMapping("/admin")
    public List<Admin> getallAdmins(){
        return adminService.getAllAdmin();
    }

}
