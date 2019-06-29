package com.xlccc.ssm.service.impl;

import com.xlccc.ssm.mapper.CropMapper;
import com.xlccc.ssm.pojo.Crop;
import com.xlccc.ssm.pojo.CropExample;
import com.xlccc.ssm.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropServiceImpl implements CropService {
    @Autowired
    CropMapper cropMapper;

    @Override
    public List<Crop> list() {
        CropExample example = new CropExample();
        example.setOrderByClause("id asc");
        return cropMapper.selectByExample(example);
    }

    @Override
    public void add(Crop crop) {
        cropMapper.insert(crop);

    }

    @Override
    public void delete(int id) {
        cropMapper.deleteByPrimaryKey(id);

    }

    @Override
    public Crop get(int id) {
        return cropMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Crop crop) {
        cropMapper.updateByPrimaryKeySelective(crop);
    }

    @Override
    public int selectTotalNumber() {
        return cropMapper.selectTotalNumber();
    }
}
