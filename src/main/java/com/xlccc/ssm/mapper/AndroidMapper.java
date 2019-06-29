package com.xlccc.ssm.mapper;

import com.xlccc.ssm.pojo.Android;
import com.xlccc.ssm.pojo.AndroidExample;
import java.util.List;

public interface AndroidMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Android record);

    int insertSelective(Android record);

    List<Android> selectByExample(AndroidExample example);

    Android selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Android record);

    int updateByPrimaryKey(Android record);
}