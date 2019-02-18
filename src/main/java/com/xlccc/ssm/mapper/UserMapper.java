package com.xlccc.ssm.mapper;

import com.xlccc.ssm.pojo.User;
import com.xlccc.ssm.util.Page;

import java.util.List;

public interface UserMapper {
    public List<User> list(Page page);

    public int total();

    void add (User user );
}
