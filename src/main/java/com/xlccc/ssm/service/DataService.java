package com.xlccc.ssm.service;

import com.xlccc.ssm.pojo.Data;

import java.util.List;

public interface DataService {

    List<Data> list();


    void  add(Data data);

    void delete (int id );

    Data get(int id );

    void update(Data data);

    int selectTotalNumber();
}
