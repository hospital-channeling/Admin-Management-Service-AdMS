package com.admin_management_system.admin.service;

import com.admin_management_system.admin.entity.Receptionist;

import java.util.List;

public interface IReceptionistService {
    Receptionist addReceptionist(Receptionist receptionist);

    void deleteReceptionist(int id);

    List<Receptionist> getAllReceptionist();

    Receptionist getReceptionistByID(int id);

    Receptionist updateReceptionist(int id, Receptionist receptionist);
}
