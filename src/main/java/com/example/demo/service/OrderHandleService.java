package com.example.demo.service;

import com.example.demo.entity.Order;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrderHandleService {

    /**
     * 创建订单
     * @param order
     */
    void createOrder(Order order, HttpSession session);

  
    int deleteOrderById(Integer orderId);


  
   List<Order> getOrdersByUserId(Integer userId,Integer page ,Integer limit);

    /**
     * 通过分页获取所有订单
     * @param page
     * @param limit
     * @return
     */
    List<Order> getAllOrdersByPage(Integer page, Integer limit);

}
