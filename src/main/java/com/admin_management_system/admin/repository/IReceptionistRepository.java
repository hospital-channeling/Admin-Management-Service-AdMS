package com.admin_management_system.admin.repository;

import com.admin_management_system.admin.entity.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReceptionistRepository extends JpaRepository<Receptionist, Integer> {
    Receptionist getReceptionistById(int receptionistId);
}
