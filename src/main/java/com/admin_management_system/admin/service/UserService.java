package com.admin_management_system.admin.service;

import com.admin_management_system.admin.entity.User;
import com.admin_management_system.admin.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserService implements IUSerService {
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
        User updateUser = currentUser.get();
        if (currentUser.isPresent()){
            updateUser.setUserId(user.getUserId());
            updateUser.setUserFirstName(user.getUserFirstName());
            updateUser.setUserLastName(user.getUserLastName());
            updateUser.setUserAddress(user.getUserAddress());
            updateUser.setUserBirthdate(user.getUserBirthdate());
            updateUser.setUserGender(user.getUserGender());
            updateUser.setUserEmail(user.getUserEmail());
            updateUser.setUserContactNum(user.getUserContactNum());
            updateUser.setUserPassword(user.getUserPassword());
        }
        else{
            System.out.println("User not found. ID = " +id);
        }
        return userRepo.save(updateUser);
    }
}
