package com.example.demo.service.impl;
import com.github.pagehelper.PageHelper;
import com.example.demo.dao.*;
import com.example.demo.dao.OrderMapper;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderHandleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderHandleServiceImpl implements OrderHandleService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
   
   
    private BookMapper bookMapper;
    @Resource
    private UserMapper userMapper;

   
    @Override
    public int deleteOrderById(Integer orderId) {
        orderMapper.deleteByOrderId(orderId);
        return 0;
    }

 
    @Override
    public List<Order> getOrdersByUserId(Integer userId, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Order> orders = orderMapper.selectByUserId(userId);
        return orders;
    }


    @Override
    public void createOrder(Order order, HttpSession session) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOrder'");
    }
}
