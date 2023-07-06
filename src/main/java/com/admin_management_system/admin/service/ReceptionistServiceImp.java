package com.admin_management_system.admin.service;

import com.admin_management_system.admin.entity.Receptionist;
import com.admin_management_system.admin.repository.IReceptionistRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class ReceptionistServiceImp implements IReceptionistService{
    @Autowired
    private IReceptionistRepository receptionistRepo;

    @Override
    public Receptionist addReceptionist(Receptionist receptionist){
        return receptionistRepo.save(receptionist);
    }

    @Override
    public void deleteReceptionist(int id){
        receptionistRepo.deleteById(id);
    }

    @Override
    public List<Receptionist> getAllReceptionist(){
        return (List<Receptionist>) receptionistRepo.findAll();
    }

    @Override
    public Receptionist getReceptionistByID(int id){
        if(receptionistRepo.findById(id).isPresent()){
            return receptionistRepo.findById(id).get();
        }
        else{
            System.out.println("Receptionist not found, " +id);
        }
        return null;
    }

    @Override
    public Receptionist updateReceptionist(int id, Receptionist receptionist){
        Optional<Receptionist> currentRecep = receptionistRepo.findById(id);
        Receptionist updRecep = currentRecep.get();
        if(currentRecep.isPresent()){
            updRecep.setId(receptionist.getId());
            updRecep.setFirst_name(receptionist.getFirst_name());
            updRecep.setLast_name(receptionist.getLast_name());
            updRecep.setAddress(receptionist.getAddress());
            updRecep.setBirthdate(receptionist.getBirthdate());
            updRecep.setGender(receptionist.getGender());
            updRecep.setService_start_date(receptionist.getService_start_date());
            updRecep.setEmail(receptionist.getEmail());
            updRecep.setContact(receptionist.getContact());
            updRecep.setPassword(receptionist.getPassword());
        }
        else{
            System.out.println("Receptionist not found. ID = " +id);
        }
        return receptionistRepo.save(updRecep);
    }
}
