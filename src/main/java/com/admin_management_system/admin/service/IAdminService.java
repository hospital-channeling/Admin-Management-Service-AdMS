package com.admin_management_system.admin.service;

import com.admin_management_system.admin.entity.Admin;

import java.util.List;

public interface IAdminService {
    Admin createAdmin(Admin admin);

    Admin updateAdmin(int id, Admin admin);

    void deleteAdmin(int id);

    List<Admin> getAllAdmin();

    Admin getAdminByID(int id);
}
