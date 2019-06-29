package com.xlccc.ssm.mapper;

import com.xlccc.ssm.pojo.Crop;
import com.xlccc.ssm.pojo.CropExample;

import java.util.List;

public interface CropMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Crop record);

    int insertSelective(Crop record);

    List<Crop> selectByExample(CropExample example);

    Crop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Crop record);

    int updateByPrimaryKey(Crop record);

    int selectTotalNumber();
}