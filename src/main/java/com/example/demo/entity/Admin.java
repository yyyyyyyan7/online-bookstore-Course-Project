package com.example.demo.entity;


import javax.validation.constraints.NotBlank;

public class Admin {
    @NotBlank(message = "管理员账号不能为空")
    private String adminName;
    @NotBlank(message = "密码不能为空")
    private String password;

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
