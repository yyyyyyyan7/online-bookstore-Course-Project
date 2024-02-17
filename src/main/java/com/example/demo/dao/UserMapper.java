package com.example.demo.dao;

import com.example.demo.entity.Admin;
import com.example.demo.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByUserId(Integer userId);

    int insert(User record);

    User selectByUserId(Integer userId);

    int updateByUserId(User record);

    List<User> selectAll();

    User selectByUserName(String userName);

    Admin selectByAdminName(String userName);


    List<User> searchUsers(User user);
}