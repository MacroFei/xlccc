package com.xlccc.ssm.service;


import com.xlccc.ssm.pojo.Equipment;

import java.util.List;

public interface EquipmentService {
    List<Equipment> list();


    void  add(Equipment equipment);

    void delete (int id );

    Equipment get(int id );

    void update(Equipment equipment);

    int selectTotalNumber();
}
