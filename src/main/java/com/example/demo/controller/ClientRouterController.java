package com.example.demo.controller;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.Book;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.BookDisplayService;
import com.example.demo.service.OrderHandleService;
import com.example.demo.service.OrderService;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class ClientRouterController {

    @Resource
    private UserMapper userMapper;
    

    @Autowired
    private BookDisplayService bookDisplayService;


    //跳转首页
    @GetMapping({"/","/index"})
    public String books(Model model) {
        List<Book> books = bookDisplayService.getAllBooks(null);
        model.addAttribute("books", books);
        return "login";
    }

    //跳转登录页面
    @GetMapping("/login")
    public String toLogin(HttpSession session){
        if(session.getAttribute("user")!=null){
            return "redirect:/";
        }
        return "login";
    }

    //跳转注册页面
    @GetMapping("/register")
    public String toRegister(){
        return "register";
    }

    @GetMapping("/back")
    public String toBooks(){
        return "books";
    }

   

    //跳转个人订单页面
    @GetMapping("/{userName}/orders")
    public String toOrderCenter(@PathVariable("userName") String userName,HttpSession session){
        User user= (User) session.getAttribute("user");
        if(user!=null && user.getUserName().equals(userName)){
            return "user_orders";
        }
        return "redirect:/login";
    }

    @Autowired
    private OrderService orderService;

    //跳转购物车页面
    @GetMapping("/{userName}/shopping_cart")
    public String toUserShoppingCart(@PathVariable("userName") String userName,HttpSession session,Model model){

        User user= (User) session.getAttribute("user");
        if(user!=null){
            System.out.println("z1111z1221222zzzzz");
            List<Order> orders = orderService.selectByUserName(userName);
          
            model.addAttribute("order", orders);
            
            return "shopping_cart";
        }
        return "redirect:/login";
    }

}
