package com.xlccc.ssm.mapper;

import com.xlccc.ssm.pojo.Data;
import com.xlccc.ssm.pojo.DataExample;
import java.util.List;

public interface DataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Data record);

    int insertSelective(Data record);

    List<Data> selectByExample(DataExample example);

    Data selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Data record);

    int updateByPrimaryKey(Data record);

    int selectTotalNumber();
}