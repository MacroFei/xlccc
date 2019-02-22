package com.xlccc.ssm.mapper;

import com.xlccc.ssm.pojo.User;
import com.xlccc.ssm.util.Page;

import java.util.List;

public interface UserMapper {
    public List<User> list();

//    public int total();

    void add (User user );

    void delete(int id );

    User get(int id );

    void update(User user);
}
