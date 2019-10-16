package com.xlccc.ssm.service.impl;

import com.xlccc.ssm.mapper.IrrigateMapper;
import com.xlccc.ssm.pojo.Irrigate;
import com.xlccc.ssm.pojo.IrrigateExample;
import com.xlccc.ssm.service.IrrigateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Irrigate> list(String category) {
        return irrigateMapper.selectIrrigateByRole(category);
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
    public int delete_1(int id) {
        return irrigateMapper.deleteByPrimaryKey(id);
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
    public int update_1(Irrigate irrigate) {
        return irrigateMapper.updateByPrimaryKeySelective(irrigate);
    }
    @Override
    public int selectTotalNumber() {
        return irrigateMapper.selectTotalNumber();
    }

    @Override
    public List<Irrigate> selectSheng(String category) {
        return irrigateMapper.selectSheng(category);
    }

    @Override
    public List<Irrigate> selectShi(String province,String category) {
        return irrigateMapper.selectShi(province,category);
    }

    @Override
    public List<Irrigate> selectQu(String province, String city,String category) {
        return irrigateMapper.selectQu(province,city,category);
    }

    @Override
    public List<Irrigate> selectName(String province, String city, String district,String category) {
        return irrigateMapper.selectName(province,city,district,category);
    }

    @Override
    public List<Irrigate> selectSSQN(String province, String city, String district, String serial_number,String category) {
        return irrigateMapper.selectSSQN(province,city,district,serial_number,category);
    }

    @Override
    public int selectTotalNumber_1(String category) {
        return irrigateMapper.selectTotalNumber_1(category);
    }

    @Override
    public int selectTotalNumber_2(String province, String city, String district, String serial_number, String category) {
        return irrigateMapper.selectTotalNumber_2(province,city,district,serial_number,category);
    }

    @Override
    public int deleteAll(String id) {
        List<Integer> list = getList(id);
        return irrigateMapper.deleteAll(list);
    }
    @Override
    public List<Irrigate> searchVariety(String serial_number,String category) {
        return irrigateMapper.searchVariety(serial_number,category);
    }

    @Override
    public boolean select(Irrigate irrigate) {
        Boolean flag = false;
        if (irrigateMapper.select(irrigate)!=null){
            flag = true;
        }
        return flag;
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
