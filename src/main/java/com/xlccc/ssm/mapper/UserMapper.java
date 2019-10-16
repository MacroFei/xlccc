package com.xlccc.ssm.mapper;

import com.xlccc.ssm.pojo.User;
<<<<<<< Updated upstream
=======
import com.xlccc.ssm.pojo.UserExample;
import org.apache.ibatis.annotations.Param;
>>>>>>> Stashed changes

import java.util.List;

public interface UserMapper {
<<<<<<< Updated upstream
    List<User> list();
}
=======
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    List<User> selectUserByRole(@Param("category") String category);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User record);

    int selectTotalNumber();

    User login(@Param("name") String name, @Param("password") String password);//登录

    User select(User user);//验证用户是否存在

    int addUser(User user);//用户注册

    List<User> selectName(@Param("name") String name);//通过用户名进行查询


    User existByUuid(User user);//验证用户uuid是否存在也可以通过uuid读取用户信息

    User selectByUuid(User user);

    int updateUUID(@Param("uuid") String uuid,@Param("id") Integer id);

    int updatePassword(User user);
}
>>>>>>> Stashed changes
