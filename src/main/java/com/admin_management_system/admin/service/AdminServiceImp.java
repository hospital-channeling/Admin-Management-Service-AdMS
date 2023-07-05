package com.admin_management_system.admin.service;

import com.admin_management_system.admin.entity.Admin;
import com.admin_management_system.admin.repository.IAdminRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminServiceImp implements IAdminService{
    @Autowired
    private IAdminRepository adminRepo;

    public Admin addAdmin(Admin admin){
        return adminRepo.save(admin);
    }

    @Override
    public Admin updateAdmin(int id, Admin admin){
        Optional<Admin> currentAdmin = adminRepo.findById(id);
        Admin updAdmin = currentAdmin.get();
        if(currentAdmin.isPresent()){
            updAdmin.setAdminId(admin.getAdminId());
            updAdmin.setFirst_name(admin.getFirst_name());
            updAdmin.setLast_name(admin.getLast_name());
            updAdmin.setContact_num(admin.getContact_num());
            updAdmin.setEmail(admin.getEmail());
            updAdmin.setPassword(admin.getPassword());
        }
        else{
            System.out.println("Admin not found. ID = " +id);
        }
        return adminRepo.save(updAdmin);
    }

    @Override
    public void deleteAdmin(int id){
        adminRepo.deleteById(id);
    }

    @Override
    public List<Admin> getAllAdmin(){
        return (List<Admin>) adminRepo.findAll();
    }

    @Override
    public Admin getAdminByID(int id){
        if(adminRepo.findById(id).isPresent()){
            return adminRepo.findById(id).get();
        }
        else{
            System.out.println("Admin not found, " +id);
        }
        return null;
    }
}
