package com.admin_management_system.admin.controller;

import com.admin_management_system.admin.entity.User;
import com.admin_management_system.admin.service.UserServiceImp;
import com.admin_management_system.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping(value = "/api/user")

public class UserController {
    @Autowired
    private UserServiceImp userService;

    //creating a new user
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){ return userService.addUser(user); }

    //deleting an user
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    //update an existing user
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user){
        return userService.updateUser(id, user);
    }
}
