package com.xlccc.ssm.service.impl;


import com.xlccc.ssm.mapper.AndroidPicMapper;
import com.xlccc.ssm.pojo.AndroidPic;
import com.xlccc.ssm.pojo.AndroidPicExample;
import com.xlccc.ssm.service.AndroidPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AndroidPicServiceImpl implements AndroidPicService {
    @Autowired
    AndroidPicMapper androidPicMapper;
    @Override
    public void add(AndroidPic androidPic) {
        androidPicMapper.insert(androidPic);
    }

    @Override
    public void delete(int id) {

        androidPicMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(AndroidPic androidPic) {
        androidPicMapper.updateByPrimaryKeySelective(androidPic);
    }

    @Override
    public AndroidPic get(int id) {
        return androidPicMapper.selectByPrimaryKey(id);
    }

    @Override
    public List list( int androidId , String type) {
        AndroidPicExample example = new AndroidPicExample();
        example.createCriteria()
                .andAndroid_idEqualTo(androidId)
                .andTypeEqualTo(type);
        example.setOrderByClause("id desc");
        return androidPicMapper.selectByExample(example);
    }
    @Override
    public List<AndroidPic> listByIdAndType(int androidId, String type) {
        AndroidPicExample example = new AndroidPicExample();
        example.createCriteria()
                .andAndroid_idEqualTo(androidId)
                .andTypeEqualTo(type);
        example.setOrderByClause("id desc");
        return androidPicMapper.selectByExample(example);
    }
}
