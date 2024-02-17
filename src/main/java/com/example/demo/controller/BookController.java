package com.example.demo.controller;
import java.util.List;


import com.github.pagehelper.PageInfo;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import com.example.demo.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.util.ResultCode;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/searchid")
    public ResultVO bookSearchByBookId(Integer bookId) {
        // Book books=bookMapper.selectByBookId(bookIde);
        Book books = bookService.bookSearchById(bookId);
        if (books != null)
            return new ResultVO(ResultCode.SUCCESS,books);
        else
            return new ResultVO(ResultCode.RECORD_NOT_FOUND, null);
    }


    @PostMapping("/delete/{bookId}")
    public ResultVO bookDelete(@PathVariable Integer bookId) {
        System.out.println("yesyesyyyyyyyyyyyyyyyyyyes");
        int books = bookService.bookDeleteSearchById(bookId);
        return new ResultVO(ResultCode.SUCCESS, null);
    }

   
    @PostMapping("/insert")
    public ResultVO bookInsert(@Valid Book record) {
        int books = bookService.bookInsert(record);
        return new ResultVO(ResultCode.SUCCESS, null);
    }


}
