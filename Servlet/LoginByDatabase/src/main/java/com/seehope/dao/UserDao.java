package com.seehope.dao;

import com.seehope.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> selectOne(@Param("username") String username, @Param("password") String password);

    public  int insertUser(User user);//添加一个用户

    public List<User> findUserByUserName(User user);

}

