package com.admin_management_system.admin.service;

import com.admin_management_system.admin.entity.User;
import com.admin_management_system.admin.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImp implements IUSerService {
    @Autowired
    private IUserRepository userRepo;

    @Override
    public User addUser(User user){
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(int id){ userRepo.deleteById(id); }

    @Override
    public User updateUser(int id, User user){
        Optional<User> currentUser = userRepo.findById(id);
        User updUser = currentUser.get();
        if (currentUser.isPresent()){
            updUser.setUserId(user.getUserId());
            updUser.setUserFirstName(user.getUserFirstName());
            updUser.setUserLastName(user.getUserLastName());
            updUser.setUserAddress(user.getUserAddress());
            updUser.setUserBirthdate(user.getUserBirthdate());
            updUser.setUserGender(user.getUserGender());
            updUser.setUserEmail(user.getUserEmail());
            updUser.setUserContactNum(user.getUserContactNum());
            updUser.setUserPassword(user.getUserPassword());
        }
        else{
            System.out.println("User not found. ID = " +id);
        }
        return userRepo.save(updUser);
    }
}
