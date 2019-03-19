package com.xlccc.ssm.mapper;

import com.xlccc.ssm.pojo.User;
import com.xlccc.ssm.pojo.UserExample;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int selectTotalNumber();
}