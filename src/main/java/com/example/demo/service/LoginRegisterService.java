package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.User;

import javax.servlet.http.HttpSession;

public interface LoginRegisterService {

   
    void userLogin(User record, HttpSession session);

    void userRegister(User record);

    void adminLogin(Admin admin, HttpSession session);
}
