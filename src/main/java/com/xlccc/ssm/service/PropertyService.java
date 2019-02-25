package com.xlccc.ssm.service;

import com.xlccc.ssm.pojo.Property;

import java.util.List;

public interface PropertyService {
    void add(Property property);

    void delete(int id);

    void update(Property property);

    List<Property> list(int uid);

    Property get(int id);


}
