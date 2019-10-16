package com.xlccc.ssm.mapper;

import com.xlccc.ssm.pojo.Equipment;
import com.xlccc.ssm.pojo.EquipmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EquipmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    List<Equipment> selectByExample(EquipmentExample example);

    List<Equipment> selectEquipmentByRole(@Param("category") String category);

    Equipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);

    int selectTotalNumber();

    int selectTotalNumber_1(@Param("category") String category);

    List<Equipment> selectSheng(@Param("category") String category);//查询省份

    List<Equipment> selectShi(@Param("province") String province,@Param("category") String category);//查询市

    List<Equipment> selectQu(@Param("province") String province, @Param("city") String city,@Param("category") String category);//查询区/镇

    List<Equipment> selectName(@Param("province") String province, @Param("city") String city, @Param("district") String district,@Param("category") String category);//查询品种

    List<Equipment> selectSSQN(@Param("province") String province, @Param("city") String city, @Param("district") String district, @Param("serial_number") String serial_number,@Param("category") String category);//四项搜索

    int selectTotalNumber_2(@Param("province") String province, @Param("city") String city, @Param("district") String district, @Param("serial_number") String serial_number,@Param("category") String category);//筛选条数

    Equipment select(Equipment equipment);//验证Equiment serial_number是否存在

    int deleteAll(List<Integer> list);

    List<Equipment> searchVariety(@Param("serial_number") String serial_number,@Param("category") String category);
}