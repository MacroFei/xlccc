package com.xlccc.ssm.mapper;

import com.xlccc.ssm.pojo.Equipment;
import com.xlccc.ssm.pojo.EquipmentExample;

import java.util.List;

public interface EquipmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    List<Equipment> selectByExample(EquipmentExample example);

    Equipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);

    int selectTotalNumber();
}