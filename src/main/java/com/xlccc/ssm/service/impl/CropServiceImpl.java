package com.xlccc.ssm.service.impl;

import com.xlccc.ssm.mapper.CropMapper;
import com.xlccc.ssm.pojo.Crop;
import com.xlccc.ssm.pojo.CropExample;
import com.xlccc.ssm.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Crop> list(String category) {

        return cropMapper.selectCropByRole(category);
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
    public int delete_1(int id) {
        return cropMapper.deleteByPrimaryKey(id);
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
    public int update_1(Crop crop) {
        return cropMapper.updateByPrimaryKeySelective(crop);
    }

    @Override
    public int selectTotalNumber() {
        return cropMapper.selectTotalNumber();
    }

    @Override
    public List<Crop> selectSheng(String category) {
        return cropMapper.selectSheng(category);
    }

    @Override
    public List<Crop> selectShi(String province,String category) {
        return cropMapper.selectShi(province,category);
    }

    @Override
    public List<Crop> selectQu(String province, String city,String category) {
        return cropMapper.selectQu(province, city,category);
    }

    @Override
    public List<Crop> selectName(String province, String city, String district,String category) {
        return cropMapper.selectName(province, city, district,category);
    }

    @Override
    public List<Crop> selectSSQN(String province, String city, String district, String variety,String category) {
        return cropMapper.selectSSQN(province, city, district, variety,category);
    }

    @Override
    public int selectTotalNumber_1(String category) {
        return cropMapper.selectTotalNumber_1(category);
    }

    @Override
    public int selectTotalNumber_2(String province, String city, String district, String variety, String category) {
        return cropMapper.selectTotalNumber_2(province,city,district,variety,category);
    }

    @Override
    public int deleteAll(String id) {
        List<Integer> list = getList(id);
        return cropMapper.deleteAll(list);
    }

    @Override
    public List<Crop> searchVariety(String variety,String category) {
        return cropMapper.searchVariety(variety,category);
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
