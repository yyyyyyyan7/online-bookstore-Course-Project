package com.example.demo.service.impl;
import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
	@Override
	public int deleteByUserId(Integer userId) {
		// TODO Auto-generated method stub
		int users= userMapper.deleteByUserId(userId);
		return users;
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		int users = userMapper.insert(record);
		return users;
	}

	@Override
	public User selectByUserId(Integer userId) {
		// TODO Auto-generated method stub
		User users = userMapper.selectByUserId(userId);
		return users;
	}

	@Override
	public int updateByUserId(User record) {
		// TODO Auto-generated method stub
		int users= userMapper.updateByUserId(record);
		return users;
	}



}
