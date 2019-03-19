package com.xlccc.ssm.service;

import com.xlccc.ssm.pojo.User;

import java.util.List;

public interface UserService {
    List<User> list();


    void  add(User user);

    void delete (int id );

    User get(int id );

    void update(User user);

    int selectTotalNumber();

}
