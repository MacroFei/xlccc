package com.xlccc.ssm.service.impl;



import com.xlccc.ssm.mapper.EquipmentMapper;
import com.xlccc.ssm.pojo.Equipment;
import com.xlccc.ssm.pojo.EquipmentExample;
import com.xlccc.ssm.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Equipment> list(String category) {
        return equipmentMapper.selectEquipmentByRole(category);
    }

    @Override
    public void add(Equipment equipment) {
        equipmentMapper.insert(equipment);

    }

    @Override
    public int deleteAll(String id) {
        List<Integer> list = getList(id);
        return equipmentMapper.deleteAll(list);
    }

    @Override
    public void delete(int id) {
        equipmentMapper.deleteByPrimaryKey(id);

    }

    @Override
    public int delete_1(int id) {
        return equipmentMapper.deleteByPrimaryKey(id);
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
    public int update_1(Equipment equipment) {
        return equipmentMapper.updateByPrimaryKeySelective(equipment);
    }

    @Override
    public int selectTotalNumber() {
        return equipmentMapper.selectTotalNumber();
    }

    @Override
    public List<Equipment> selectSheng(String category) {
        return equipmentMapper.selectSheng(category);
    }

    @Override
    public List<Equipment> selectShi(String province,String category) {
        return equipmentMapper.selectShi(province,category);
    }

    @Override
    public List<Equipment> selectQu(String province, String city,String category) {
        return equipmentMapper.selectQu(province,city,category);
    }

    @Override
    public List<Equipment> selectName(String province, String city, String district,String category) {
        return equipmentMapper.selectName(province,city,district,category);
    }

    @Override
    public List<Equipment> selectSSQN(String province, String city, String district, String serial_number,String category) {
        return equipmentMapper.selectSSQN(province,city,district,serial_number,category);
    }

    @Override
    public int selectTotalNumber_2(String province, String city, String district, String serial_number, String category) {
        return equipmentMapper.selectTotalNumber_2(province,city,district,serial_number,category);
    }

    @Override
    public int selectTotalNumber_1(String category) {
        return equipmentMapper.selectTotalNumber_1(category);
    }

    @Override
    public boolean select(Equipment equipment) {
        Boolean flag = false;
        if (equipmentMapper.select(equipment)!=null) {
            flag = true;
        }
        return flag;
    }
    @Override
    public List<Equipment> searchVariety(String serial_number,String category) {
        return equipmentMapper.searchVariety(serial_number,category);
    }
    /**
     * id放入list
     *
     * @param id
     *            id(多个已逗号分隔)
     * @return List集合
     */
    public List<Integer> getList(String id) {
        List<Integer> list = new ArrayList<Integer>();
        String[] str = id.split(",");
        for (int i = 0; i < str.length; i++) {
            list.add(Integer.parseInt(str[i]));
        }
        return list;
    }

}
