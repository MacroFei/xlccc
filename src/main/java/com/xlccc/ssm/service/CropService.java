package com.xlccc.ssm.service;

import com.xlccc.ssm.pojo.Crop;

import java.util.List;

public interface CropService {
    List<Crop> list();

    List<Crop> list(String category); //根据分类查询

    void add(Crop crop);

    void delete(int id);

    int delete_1(int id);

    Crop get(int id);

    void update(Crop crop);

    int update_1(Crop crop);

    int selectTotalNumber();

    List<Crop> selectSheng(String category);

    List<Crop> selectShi(String province,String category);

    List<Crop> selectQu(String province, String city,String category);

    List<Crop> selectName(String province, String city, String district,String category);

    List<Crop> selectSSQN(String province, String city, String district, String variety,String category);

    int selectTotalNumber_1(String category);  //根据分类查询总数

    int selectTotalNumber_2(String province, String city, String district, String variety,String category);

    int deleteAll(String id);//根据id批量删除

    List<Crop> searchVariety(String variety,String category);//通过品种名称进行模糊查询
}
