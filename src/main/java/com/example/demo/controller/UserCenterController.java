package com.example.demo.controller;
import com.github.pagehelper.PageInfo;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.service.OrderHandleService;
import com.example.demo.util.ResultCode;
import com.example.demo.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
@RequestMapping("/user_center")
public class UserCenterController {

    @Autowired
    private OrderHandleService orderHandleService;

    /**
     * 根据用户ID,获取用户订单
     * @return
     */
    @GetMapping("/orders")
    @ResponseBody
    public ResultVO getUserOrders(Integer page,Integer limit,HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Order> orders = orderHandleService.getOrdersByUserId(user.getUserId(), page, limit);
        PageInfo pageInfo = new PageInfo(orders);
        return new ResultVO(ResultCode.SUCCESS, (int)pageInfo.getTotal(),orders);
    }

    /**
     * 删除指定orderId的订单
     * @param orderId
     * @return
     */
    @DeleteMapping("/orders/{orderId}")
    @ResponseBody
    public ResultVO deleteOrder(@PathVariable("orderId") Integer orderId) {
        int orders = orderHandleService.deleteOrderById(orderId);
        return new ResultVO(ResultCode.SUCCESS,null);
    }

}
