package com.example.demo.service.impl;
import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.example.demo.dao.BookMapper;
import com.example.demo.dao.OrderMapper;
import com.example.demo.entity.Book;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

	
	@Resource
    private BookMapper bookMapper;
	@Override
	public int deleteByOrderId(Integer orderId) {
		// TODO Auto-generated method stub
		int orders = orderMapper.deleteByOrderId(orderId);
		return 0;
	}

	@Override
	@Deprecated
	public int insert(Order record) {             //插入订单
		orderMapper.insert(record);
		return 0;
	}

	@Override
	public Order selectByOrderId(Integer orderId) {
		// TODO Auto-generated method stub
		Order orders = orderMapper.selectByOrderId(orderId);
		if(orders!=null)
		return orders;
		else
		return null;
	}

	@Override
	public int updateByOrderId(Order record) {
		// TODO Auto-generated method stub
		int orders = orderMapper.updateByOrderId(record);
		
		return orders;
	}

	@Override
	public List<Order> selectAll() {
		// TODO Auto-generated method stub
		List<Order> orders = orderMapper.selectAll(); 
		return orders;
	}

	@Override
	 public List<Order> selectByUserName(String userName){
		List<Order> orders = orderMapper.selectByUserName(userName);
		return orders;
	}

	@Override
	public Book getBookDetails(Integer bookid){
		Book book  = bookMapper.selectByBookId(bookid);
		return book;
	}

	

	@Override
	public List<Order> selectByUserId(Integer userId) {
		// TODO Auto-generated method stub
		List<Order> orders = orderMapper.selectByUserId(userId);
		return orders;
	}
	/**
	 * @param order
	 * @param page
	 * @param limit
	 * @return
	 */
	@Override
	public List<Order> searchOrders(Order order, Integer page, Integer limit) {
		PageHelper.startPage(page, limit);
		List<Order> orders = orderMapper.searchOrders(order);
		return orders;
	}

	
}
