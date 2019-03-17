package com.xlccc.ssm.service.impl;

import com.xlccc.ssm.mapper.DataMapper;
import com.xlccc.ssm.pojo.Data;
import com.xlccc.ssm.pojo.DataExample;
import com.xlccc.ssm.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DataServiceImpl implements DataService {

    @Autowired
    DataMapper dataMapper;
    @Override
    public List<Data> list() {
        DataExample example = new DataExample();
        example.setOrderByClause("id asc");
        return dataMapper.selectByExample(example);
    }

    @Override
    public void add(Data data) {
        dataMapper.insert(data);
    }

    @Override
    public void delete(int id) {
        dataMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Data get(int id) {
        return dataMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Data data) {
        dataMapper.updateByPrimaryKeySelective(data);
    }

    @Override
    public int selectTotalNumber() {
        return dataMapper.selectTotalNumber();
    }
}
