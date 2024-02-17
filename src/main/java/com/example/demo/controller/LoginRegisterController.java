package com.example.demo.controller;
import com.example.demo.exception.CustomizeException;
import com.example.demo.entity.Admin;
import com.example.demo.entity.User;
import com.example.demo.service.LoginRegisterService;
import com.example.demo.util.ResultVO;
import com.example.demo.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginRegisterController {

    @Autowired
    private LoginRegisterService loginRegisterService;

    
    @PostMapping("/user/login")
    @ResponseBody
    public ResultVO userLoginHandler(@RequestBody @Valid User user, HttpSession session) {
        System.out.println(user.getUserName());
        System.out.println(user.getUserId());
        loginRegisterService.userLogin(user,session);
        System.out.println(session.getAttribute("user").toString());
        return new ResultVO(ResultCode.SUCCESS,"/index/books");
    }

  
    @PostMapping("/user/register")
    @ResponseBody
    public ResultVO userRegisterHandler(@RequestBody @Valid User user) {
        loginRegisterService.userRegister(user);
        return new ResultVO(ResultCode.SUCCESS,"/login");
    }

    /**
     * 管理员登录
     */
    @PostMapping("/admin/login")
    @ResponseBody
    public ResultVO adminLoginHandler(@RequestBody Admin admin, HttpSession session) {
        if(!("admin".equals(admin.getAdminName())&& "123456".equals(admin.getPassword()))){
            throw new CustomizeException(ResultCode.FAILED,"管理员账户或密码错误");
        }
        session.setAttribute("admin",admin);
        return new ResultVO(ResultCode.SUCCESS,"/admin/book_manage");
    }

    /**
     * 用户退出
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String userLogout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/login";
    }

    /**
     * 后台管理退出
     * @param session
     * @return
     */
    @GetMapping("/admin/logout")
    public String adminLogout(HttpSession session){
        session.removeAttribute("admin");
        return "redirect:/";
    }

    @GetMapping("/checkLoggedIn")
    @ResponseBody
    public ResultVO checkUserIsLoggedIn(HttpSession session) {
        if (session.getAttribute("user") == null) {
            throw new CustomizeException(ResultCode.USER_NOT_LOGGED_IN);
        }
        return new ResultVO(ResultCode.SUCCESS);
    }
}
