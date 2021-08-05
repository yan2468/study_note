package com.seehope.dao;

import com.seehope.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public List<User> selectOne(@Param("username") String username, @Param("password") String password);
}
