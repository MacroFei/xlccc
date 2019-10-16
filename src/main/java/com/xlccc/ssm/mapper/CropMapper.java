package com.xlccc.ssm.mapper;

import com.xlccc.ssm.pojo.Crop;
import com.xlccc.ssm.pojo.CropExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CropMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Crop record);

    int insertSelective(Crop record);

    List<Crop> selectByExample(CropExample example);

    List<Crop> selectCropByRole(@Param("category") String category);

    int selectTotalNumber_1(@Param("category") String category);

    Crop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Crop record);

    int updateByPrimaryKey(Crop record);

    int selectTotalNumber();

    List<Crop> selectSheng(@Param("category") String category);//查询省份

    List<Crop> selectShi(@Param("province") String province,@Param("category") String category);//查询市

    List<Crop> selectQu(@Param("province") String province, @Param("city") String city,@Param("category") String category);//查询区/镇

    List<Crop> selectName(@Param("province") String province, @Param("city") String city, @Param("district") String district,@Param("category") String category);//查询品种

    List<Crop> selectSSQN(@Param("province") String province, @Param("city") String city, @Param("district") String district, @Param("variety") String variety,@Param("category") String category);//四项搜索

    int selectTotalNumber_2(@Param("province") String province, @Param("city") String city, @Param("district") String district, @Param("variety") String variety,@Param("category") String category);//筛选条数

    int deleteAll(List<Integer> list);

    List<Crop> searchVariety(@Param("variety") String variety,@Param("category") String category);
}