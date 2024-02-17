package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.BookDisplayService;
import com.example.demo.entity.Book;

@Controller
@RequestMapping("/admin")
public class AdminRouterController {

    @Autowired
    private BookDisplayService bookDisplayService;
    
    //跳转用户管理页面
    @GetMapping("/user_manage")
    public String toUserManage(){
        return "admin/user";
    }

    //跳转书籍管理页面
    @GetMapping({"/","/book_manage"})
    public String toBookManage(Model model){
        
        List<Book> books = bookDisplayService.getAllBooks(null);
        model.addAttribute("books", books);
    
        return "admin/books";
    }

  

    //跳转订单管理页面
    @GetMapping("/order_manage")
    public String toOrderManage(){
        return "admin/order";
    }

    //跳转添加书籍页面
    @GetMapping("/add_book")
    public String AddBook(){
        return "admin/add_book";
    }

    //跳转后台登录页面
    @GetMapping("/login")
    public String toAdminLogin(){
        return "admin/login";
    }

}
