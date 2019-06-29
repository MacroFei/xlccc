package com.xlccc.ssm.service;

import com.xlccc.ssm.pojo.Irrigate;

import java.util.List;

public interface IrrigateService {
    List<Irrigate> list();


    void add(Irrigate irrigate);

    void delete(int id);

    Irrigate get(int id);

    void update(Irrigate irrigate);

    int selectTotalNumber();

}
