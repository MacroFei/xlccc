package com.xlccc.ssm.service;

import com.xlccc.ssm.pojo.Crop;

import java.util.List;

public interface CropService {
    List<Crop> list();

    void add(Crop crop);

    void delete(int id );

    Crop get(int id );

    void update(Crop crop);

    int selectTotalNumber();
}
