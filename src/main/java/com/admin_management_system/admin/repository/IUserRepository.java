package com.admin_management_system.admin.repository;

import com.admin_management_system.admin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM Patient WHERE id = ?1", nativeQuery = true)
    User getUserByUserId(int userID);
}
