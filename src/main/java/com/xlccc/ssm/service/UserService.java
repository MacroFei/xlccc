package com.xlccc.ssm.service;

import com.xlccc.ssm.pojo.User;

import java.util.List;

public interface UserService {
<<<<<<< Updated upstream
    List <User> list();
=======
    List<User> list();

    List<User> list(String category); //根据权限查询

    void add(User user);

    void delete(int id);

    User get(int id);

    void update(User user);

    int selectTotalNumber();

    int selectTotalNumber(int role);  //根据权限查询总数

    User login(User user);

    int addUser(User user);

    boolean select(User user);

    List<User> selectName(String name);

    boolean existByUuid(User user); //判断uuid对应的user对象是否存在

    User selectByUuid(User user);  //获取uuid对应的user对象

    int updateUUID(String uuid,Integer id);//根据id修改登陆状态码

    int updatePassword(User user);//修改密码

>>>>>>> Stashed changes
}
