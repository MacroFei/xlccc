package com.xlccc.ssm.mapper;

import com.xlccc.ssm.pojo.Irrigate;
import com.xlccc.ssm.pojo.IrrigateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IrrigateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Irrigate record);

    int insertSelective(Irrigate record);

    List<Irrigate> selectByExample(IrrigateExample example);

    List<Irrigate> selectIrrigateByRole(@Param("category") String category);

    Irrigate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Irrigate record);

    int updateByPrimaryKey(Irrigate record);

    int selectTotalNumber();

    int selectTotalNumber_1(@Param("category") String category);

    int selectTotalNumber_2(@Param("province") String province, @Param("city") String city, @Param("district") String district, @Param("serial_number") String serial_number,@Param("category") String category);

    List<Irrigate> selectSheng(@Param("category") String category);//查询省份

    List<Irrigate> selectShi(@Param("province") String province,@Param("category") String category);//查询市

    List<Irrigate> selectQu(@Param("province") String province, @Param("city") String city,@Param("category") String category);//查询区/镇

    List<Irrigate> selectName(@Param("province") String province, @Param("city") String city, @Param("district") String district,@Param("category") String category);//查询品种

    List<Irrigate> selectSSQN(@Param("province") String province, @Param("city") String city, @Param("district") String district, @Param("serial_number") String serial_number,@Param("category") String category);//四项搜索

    Irrigate select(Irrigate irrigate);//验证irrigate serial_number是否存在

    int deleteAll(List<Integer> list);

    List<Irrigate> searchVariety(@Param("serial_number") String serial_number,@Param("category") String category);
}