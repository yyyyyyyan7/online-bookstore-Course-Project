package com.example.demo.controller;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.service.OrderHandleService;
import com.example.demo.service.OrderService;
import com.example.demo.util.ResultVO;
import com.example.demo.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/order")
public class OrderController {
     @Autowired
     private OrderService orderService;

    @Autowired
    private OrderHandleService orderHandleService;


  
    @PostMapping("/submit")
    public ResultVO orderSubmit(@RequestBody @Valid Order order, HttpSession session) {
        User user = (User) session.getAttribute("user");
        order.setUserId(user.getUserId());
        orderHandleService.createOrder(order,session);
        return new ResultVO(ResultCode.SUCCESS,"/"+user.getUserName()+"/orders");
    }

 
    @PutMapping("/list/{orderId}")
    public ResultVO updateOrder(@PathVariable("orderId") Integer orderId,@RequestBody Order order) {
           Order orders1 = orderService.selectByOrderId(orderId);
           if(orders1!=null)
           {
        	order.setOrderId(orderId);
        	int orders = orderService.updateByOrderId(order);
        	return new ResultVO(ResultCode.SUCCESS,null);
           }
           else
        	return new ResultVO(ResultCode.RECORD_NOT_FOUND,null);
    }

 

}
