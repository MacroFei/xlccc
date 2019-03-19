package com.xlccc.ssm.mapper;

import com.xlccc.ssm.pojo.Irrigate;
import com.xlccc.ssm.pojo.IrrigateExample;

import java.util.List;

public interface IrrigateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Irrigate record);

    int insertSelective(Irrigate record);

    List<Irrigate> selectByExample(IrrigateExample example);

    Irrigate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Irrigate record);

    int updateByPrimaryKey(Irrigate record);

    int selectTotalNumber();
}