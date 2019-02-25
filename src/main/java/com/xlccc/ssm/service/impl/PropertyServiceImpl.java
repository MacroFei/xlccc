package com.xlccc.ssm.service.impl;

import com.xlccc.ssm.mapper.PropertyMapper;
import com.xlccc.ssm.pojo.Property;
import com.xlccc.ssm.pojo.PropertyExample;
import com.xlccc.ssm.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyMapper propertyMapper;

    @Override
    public void add(Property property) {
        propertyMapper.insert(property);
    }

    @Override
    public void delete(int id) {
        propertyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Property property) {
        propertyMapper.updateByPrimaryKeySelective(property);
    }

    @Override
    public List<Property> list(int uid) {
        PropertyExample example = new PropertyExample();
        example.createCriteria().andUidEqualTo(uid);
        example.setOrderByClause("id desc"); //设置排序升序或降序
        return propertyMapper.selectByExample(example);
    }

    @Override
    public Property get(int id) {
        return propertyMapper.selectByPrimaryKey(id);
    }
}
