package com.admin_management_system.admin.service;

import com.admin_management_system.admin.entity.User;

public interface IUSerService {
    User addUser(User user);

    void deleteUser(int id);

    User updateUser(int id, User user);
}
