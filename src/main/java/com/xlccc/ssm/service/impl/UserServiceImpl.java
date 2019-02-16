package com.xlccc.ssm.service.impl;

import com.xlccc.ssm.mapper.UserMapper;
import com.xlccc.ssm.pojo.User;
import com.xlccc.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> list() {
        return userMapper.list();
    }
}
