package com.example.demo.controller;
import com.github.pagehelper.PageInfo;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.ResultCode;
import com.example.demo.util.ResultVO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
   @Autowired
   private UserService userService;
   

   
    @DeleteMapping("/list/{userId}")
    public ResultVO deleteUser(@PathVariable("userId") Integer userId) {
        int users =userService.deleteByUserId(userId);
        return new ResultVO(ResultCode.SUCCESS,null);
    }

    
    @PostMapping("/update")
    public ResultVO updateUser(@RequestBody @Valid User record) {
        int users =userService.updateByUserId(record);
        return new ResultVO(ResultCode.SUCCESS,null);
    }


}
