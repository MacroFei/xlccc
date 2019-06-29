package com.xlccc.ssm.service.impl;



import com.xlccc.ssm.mapper.EquipmentMapper;
import com.xlccc.ssm.pojo.Equipment;
import com.xlccc.ssm.pojo.EquipmentExample;
import com.xlccc.ssm.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    EquipmentMapper equipmentMapper;
    @Override
    public List<Equipment> list() {
        EquipmentExample example = new EquipmentExample();
        example.setOrderByClause("id desc");
        return equipmentMapper.selectByExample(example);
    }

    @Override
    public void add(Equipment equipment) {
        equipmentMapper.insert(equipment);

    }

    @Override
    public void delete(int id) {
        equipmentMapper.deleteByPrimaryKey(id);

    }

    @Override
    public Equipment get(int id) {
        return equipmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Equipment equipment) {
        equipmentMapper.updateByPrimaryKeySelective(equipment);

    }

    @Override
    public int selectTotalNumber() {
        return equipmentMapper.selectTotalNumber();
    }

}
