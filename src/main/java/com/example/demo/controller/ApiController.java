package com.example.demo.controller;
import com.example.demo.entity.Order;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.example.demo.service.BookDisplayService;
import com.example.demo.entity.Book;
import com.example.demo.exception.CustomizeException;
import com.example.demo.exception.CustomizeException;
import com.example.demo.util.ResultCode;
import com.example.demo.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import com.example.demo.service.BookService;
import com.example.demo.dao.UserMapper;
@RestController
@RequestMapping("/api")
public class ApiController {
      @Resource
    private UserMapper userMapper;

    @Autowired
    private OrderService bookService;  // Assuming you have a BookService
    @Autowired
    private UserService userService;  // Assuming you have a BookService
    @Autowired
    private BookService bookService2;  // Assuming you have a PurchaseService

    @GetMapping("/books/{bookId}")
    public Book getBookDetails(@PathVariable Integer bookId) {
        // Implement this method to fetch book details from your service
        Book book = bookService2.bookSearchById(bookId);
        if (book != null) {
            System.out.println(book);
           // System.out.println(book);System.out.println(book);System.out.println(book);System.out.println(book);System.out.println(book);System.out.println(book);
            return book;
        } else {
            return null;
        }
    }

    @PostMapping("/purchase")
    public ResponseEntity<String> handlePurchase(HttpServletRequest request) {
        // Implement this method to handle the purchase logic in your service
        int orderId = Integer.valueOf(request.getParameter("orderId"));
        int userId = Integer.valueOf(request.getParameter("userId"));
        int bookId = Integer.valueOf(request.getParameter("bookId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        // Check if the user's balance is sufficient
        
        boolean balanceSufficient;
        User user=userService.selectByUserId(userId);
        System.out.println(user);
        System.out.println(user);System.out.println(user);System.out.println(user);System.out.println(user);
        if(user.getDeposit()>=totalPrice)
           balanceSufficient = true;
        else balanceSufficient = false;

        if (balanceSufficient) {
           user.setDeposit(user.getDeposit()-totalPrice);
           userService.updateByUserId(user);
            Book book = bookService2.bookSearchById(bookId);
            book.setStock(book.getStock()-quantity);
            bookService2.bookUpdate(book);
            Order order = bookService.selectByOrderId(orderId);
            System.out.println(order);
            order.setStatus();
            System.out.println(order); System.out.println(order); System.out.println(order); System.out.println(order); System.out.println(order);

            bookService.updateByOrderId(order);

            return ResponseEntity.ok("买好咯！");
        } else {
            // Return an error response if the balance is insufficient
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient balance.");
        }
    }

   
    @PostMapping("/addToCart/{bookId}")
    public ResponseEntity<String> addToCart(@PathVariable Integer bookId,HttpServletRequest request) {
        System.out.println("neworde");
        System.out.println("newossssssssssssssssrder");
        System.out.println("neworder");
        // Extract parameters directly from the request
         String userName = request.getParameter("userName");
         User user=userMapper.selectByUserName(userName);
        Integer userId = user.getUserId();
        
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double totalPrice = Double.parseDouble(request.getParameter("bookPrice"));
        totalPrice=totalPrice*quantity;
       
        Order neworder = new Order();
        neworder.setUesrName(userName);
        neworder.setUserId(userId);
        neworder.setbookid(bookId);
        neworder.setBookNum(quantity);
        neworder.setprice(totalPrice);
        System.out.println(neworder);
        bookService.insert(neworder);

        System.out.println(neworder);
        System.out.println(neworder);
        System.out.println(neworder);
        return ResponseEntity.ok("Order added to the cart successfully.");
    }

     @PostMapping("/orders/delete/{orderId}")
     public void handleDelete(@PathVariable("orderId") Integer orderId) {
        System.out.println(orderId);
        System.out.println(orderId);
        System.out.println(orderId);
        System.out.println(orderId);
        int orders = bookService.deleteByOrderId(orderId);
        
    }
}
