package com.xlccc.ssm.service;

import com.xlccc.ssm.pojo.User;
import com.xlccc.ssm.util.Page;

import java.util.List;

public interface UserService {
    List<User> list(Page page);

    int total();

    void add(User user);

    void delete (int id );

    User get(int id );
}
