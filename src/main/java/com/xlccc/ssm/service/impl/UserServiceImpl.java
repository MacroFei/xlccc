package com.xlccc.ssm.service.impl;

import com.xlccc.ssm.mapper.UserMapper;
import com.xlccc.ssm.pojo.User;
import com.xlccc.ssm.pojo.UserExample;
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
        UserExample example = new UserExample();
        example.setOrderByClause("id asc");
        return userMapper.selectByExample(example);
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);

    }

    @Override
    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);

    }

    @Override
    public User get(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);

    }

    @Override
    public int selectTotalNumber() {
        return userMapper.selectTotalNumber();
    }
}
