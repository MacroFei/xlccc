package com.xlccc.ssm.service;

import com.xlccc.ssm.pojo.Android;


import java.util.List;

public interface AndroidService {

    void add(Android android);

    void delete(int id);

    void update(Android android);

    Android get(int id);

    List<Android> list();

    void setFirstProductImage(Android android);
}
