package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Book;
import com.example.demo.entity.Order;

public interface OrderService {
    int deleteByOrderId(Integer orderId);

    int insert(Order record);

    Order selectByOrderId(Integer orderId);
  
    int updateByOrderId(Order record);
    Book getBookDetails(Integer bookid);
    List<Order> selectAll();
    List<Order> selectByUserName(String userName);
    List<Order> selectByUserId(Integer userId);
   // int orderIsExits(Integer orderId);

   
    List<Order> searchOrders(Order order,Integer page,Integer limit);
}
