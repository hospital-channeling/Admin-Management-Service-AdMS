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
public class AdminService implements IAdminService{
    @Autowired
    private IAdminRepository adminRepo;

    @Override
    public Admin createAdmin(Admin admin){
        return adminRepo.save(admin);
    }

    @Override
    public Admin updateAdmin(int id, Admin admin){
        Optional<Admin> currentAdmin = adminRepo.findById(id);
        Admin updateAdmin = currentAdmin.get();
        if(currentAdmin.isPresent()){
            updateAdmin.setAdminId(admin.getAdminId());
            updateAdmin.setFirst_name(admin.getFirst_name());
            updateAdmin.setLast_name(admin.getLast_name());
            updateAdmin.setContact_num(admin.getContact_num());
            updateAdmin.setEmail(admin.getEmail());
            updateAdmin.setPassword(admin.getPassword());
        }
        else{
            System.out.println("Admin not found. ID = " +id);
        }
        return adminRepo.save(updateAdmin);
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
