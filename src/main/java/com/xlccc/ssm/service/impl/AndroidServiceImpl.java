package com.xlccc.ssm.service.impl;

import com.xlccc.ssm.mapper.AndroidMapper;
import com.xlccc.ssm.pojo.Android;
import com.xlccc.ssm.pojo.AndroidExample;
import com.xlccc.ssm.service.AndroidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AndroidServiceImpl implements AndroidService {
    @Autowired
    AndroidMapper androidMapper;
    @Override
    public void add(Android android) {
        androidMapper.insert(android);

    }

    @Override
    public void delete(int id) {
        androidMapper.deleteByPrimaryKey(id);

    }

    @Override
    public void update(Android android) {

        androidMapper.updateByPrimaryKeySelective(android);
    }

    @Override
    public Android get(int id) {
        return androidMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Android> list() {
        AndroidExample example = new AndroidExample();
        example.setOrderByClause("id desc");
        return androidMapper.selectByExample(example);
    }

    @Override
    public void setFirstProductImage(Android android) {

    }
}
