package com.example.demo.service.impl;
import com.example.demo.dao.UserMapper;
import com.example.demo.exception.CustomizeException;
import com.example.demo.entity.Admin;
import com.example.demo.entity.User;
import com.example.demo.service.LoginRegisterService;
import com.example.demo.util.ResultCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class LoginRegisterServiceImpl implements LoginRegisterService {

    @Resource
    private UserMapper userMapper;

   
    @Override
    public void userLogin(User record, HttpSession session) {
        User user=userMapper.selectByUserName(record.getUserName());
        if(user==null){
            //用户不存在
            throw new CustomizeException(ResultCode.USER_NOT_FOUND);
        }
        if(!user.getPassword().equals(record.getPassword())){
            //密码错误
            throw new CustomizeException(ResultCode.PASSWORD_ERROR);
        }
        if(user.getUserId()==null){
            
            throw new CustomizeException(ResultCode.PASSWORD_ERROR);
        }
        System.out.println(user.getUserId());
        System.out.println(user.getUserId());
        System.out.println(user.getUserId());
        session.setAttribute("user",user);
        session.setAttribute("userId",user.getUserId());
    }

    /**
     * 用户注册处理
     * @param record
     */
    @Override
    public void userRegister(User record) {
        User user=userMapper.selectByUserName(record.getUserName());
        if(user!=null){
            throw new CustomizeException(ResultCode.FAILED,"用户名已存在");
        }
        userMapper.insert(record);
    }

    @Override
    public void adminLogin(Admin admin, HttpSession session) {

        Admin user=userMapper.selectByAdminName(admin.getAdminName());
        if(user==null){
            //用户不存在
            throw new CustomizeException(ResultCode.USER_NOT_FOUND);
        }
        if(!user.getPassword().equals(admin.getPassword())){
            //密码错误
            throw new CustomizeException(ResultCode.PASSWORD_ERROR);
        }
        session.setAttribute("user",user);
    }
}
