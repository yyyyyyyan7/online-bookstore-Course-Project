package com.example.demo.dao;

import com.example.demo.entity.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByOrderId(Integer orderId);

    int insert(Order record);

    Order selectByOrderId(Integer orderId);

    int updateByOrderId(Order record);

    List<Order> selectAll();

    List<Order> selectByUserName(String userName);

    List<Order> selectByUserId(Integer userId);

    List<Order> searchOrders(Order order);
}