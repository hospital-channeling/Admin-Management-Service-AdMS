package com.admin_management_system.admin.repository;

import com.admin_management_system.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAdminRepository extends JpaRepository<Admin, Integer> {
    @Query(value = "SELECT * FROM Admin WHERE Id = ?1", nativeQuery = true)
    Admin getAdminById(int adminID);
}
