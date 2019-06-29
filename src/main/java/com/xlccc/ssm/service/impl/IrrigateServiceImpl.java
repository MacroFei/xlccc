package com.xlccc.ssm.service.impl;

import com.xlccc.ssm.mapper.IrrigateMapper;
import com.xlccc.ssm.pojo.Irrigate;
import com.xlccc.ssm.pojo.IrrigateExample;
import com.xlccc.ssm.service.IrrigateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IrrigateServiceImpl  implements IrrigateService{
    @Autowired
    IrrigateMapper irrigateMapper;

    @Override
    public List<Irrigate> list() {
        IrrigateExample example = new IrrigateExample();
        example.setOrderByClause("id asc");
        return irrigateMapper.selectByExample(example);
    }

    @Override
    public void add(Irrigate irrigate) {
        irrigateMapper.insert(irrigate);

    }

    @Override
    public void delete(int id) {
        irrigateMapper.deleteByPrimaryKey(id);

    }

    @Override
    public Irrigate get(int id) {
        return irrigateMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Irrigate irrigate) {
        irrigateMapper.updateByPrimaryKeySelective(irrigate);

    }

    @Override
    public int selectTotalNumber() {
        return irrigateMapper.selectTotalNumber();
    }
}
