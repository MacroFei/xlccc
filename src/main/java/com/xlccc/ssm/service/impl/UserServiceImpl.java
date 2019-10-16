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
<<<<<<< Updated upstream
        return userMapper.list();
=======
        UserExample example = new UserExample();
        example.setOrderByClause("id asc");
        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> list(String category) {
        return userMapper.selectUserByRole(category);
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
>>>>>>> Stashed changes
    }

    @Override
    public int selectTotalNumber(int role) {
        return 0;
    }

    @Override
    public User login(User user) {
        return userMapper.login(user.getName(),user.getPassword());
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public boolean select(User user) {
        Boolean flag = false;
        if (userMapper.select(user)!=null) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<User> selectName(String name) {
        return userMapper.selectName(name);
    }

    @Override
    public boolean existByUuid(User user){
        Boolean flag = false;
        if(userMapper.existByUuid(user)!=null){
            flag = true;
        }return flag;
    }

    @Override
    public User selectByUuid(User user) {
        return userMapper.selectByUuid(user);
    }

    @Override
    public int updateUUID(String uuid,Integer id) {
        return userMapper.updateUUID(uuid,id);
    }

    @Override
    public int updatePassword(User user) {
        return userMapper.updatePassword(user);
    }

}
