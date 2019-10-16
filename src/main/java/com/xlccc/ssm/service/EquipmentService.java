package com.xlccc.ssm.service;


import com.xlccc.ssm.pojo.Equipment;

import java.util.List;

public interface EquipmentService {
    List<Equipment> list();

    List<Equipment> list(String category); //根据权限查询

    void add(Equipment equipment);

    void delete(int id);

    int deleteAll(String id);//根据id批量删除

    int delete_1(int id);

    Equipment get(int id);

    void update(Equipment equipment);

    int update_1(Equipment equipment);

    int selectTotalNumber();

    List<Equipment> selectSheng(String category);

    List<Equipment> selectShi(String province,String category);

    List<Equipment> selectQu(String province, String city,String category);

    List<Equipment> selectName(String province, String city, String district,String category);

    List<Equipment> selectSSQN(String province, String city, String district, String serial_number,String category);

    int selectTotalNumber_1(String category);  //根据分类查询总数

    int selectTotalNumber_2(String province, String city, String district, String serial_number,String category);

    boolean select(Equipment equipment);

    List<Equipment> searchVariety(String serial_number,String category);//通过品种名称进行模糊查询
}
