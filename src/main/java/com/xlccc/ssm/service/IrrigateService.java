package com.xlccc.ssm.service;

import com.xlccc.ssm.pojo.Irrigate;

import java.util.List;

public interface IrrigateService {
    List<Irrigate> list();

    List<Irrigate> list(String category); //根据分类查询

    void add(Irrigate irrigate);

    void delete(int id);

    int delete_1(int id);

    Irrigate get(int id);

    void update(Irrigate irrigate);

    int update_1(Irrigate irrigate);

    int selectTotalNumber();

    List<Irrigate> selectSheng(String category);

    List<Irrigate> selectShi(String province,String category);

    List<Irrigate> selectQu(String province, String city,String category);

    List<Irrigate> selectName(String province, String city,String district,String category);

    List<Irrigate> selectSSQN(String province, String city,String district,String serial_number,String category);

    int selectTotalNumber_1(String category);  //根据分类查询总数

    int selectTotalNumber_2(String province, String city,String district,String serial_number,String category);

    boolean select(Irrigate irrigate);

    int deleteAll(String id);//根据id批量删除

    List<Irrigate> searchVariety(String serial_number,String category);//通过品种名称进行模糊查询

}
