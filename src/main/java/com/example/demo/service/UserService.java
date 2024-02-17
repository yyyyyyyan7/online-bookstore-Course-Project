package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {

    int deleteByUserId(Integer userId);

    int insert(User record);
    /**
	 * 通过用户书籍ID获得用户书籍
	 * @param  userId
	 */
    User selectByUserId(Integer userId);
    /**
	 * 通过用户ID更新用户
	 * @param record
	 */
    int updateByUserId(User record);
   



	

}
