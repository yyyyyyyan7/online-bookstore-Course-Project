package com.example.demo.entity;


import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class User {
    public Integer userId;

    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = "[0-9A-Za-z_]{3,15}",message = "用户名只能是3~15位字母、数字或者下划线")
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6,message = "密码至少6个字符")
    private String password;


    private Double deposit;

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", deposit=" + deposit
               
                ;
    }

   
}