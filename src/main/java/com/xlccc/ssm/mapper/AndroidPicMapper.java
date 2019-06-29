package com.xlccc.ssm.mapper;

import com.xlccc.ssm.pojo.AndroidPic;
import com.xlccc.ssm.pojo.AndroidPicExample;
import java.util.List;

public interface AndroidPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AndroidPic record);

    int insertSelective(AndroidPic record);

    List<AndroidPic> selectByExample(AndroidPicExample example);

    AndroidPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AndroidPic record);

    int updateByPrimaryKey(AndroidPic record);
}