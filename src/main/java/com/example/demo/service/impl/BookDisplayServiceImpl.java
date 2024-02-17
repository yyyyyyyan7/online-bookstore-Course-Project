package com.example.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.example.demo.dao.BookDisplayMapper;
import com.example.demo.dao.BookMapper;
import com.example.demo.entity.Book;

import com.example.demo.service.BookDisplayService;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookDisplayServiceImpl implements BookDisplayService {
  

    @Resource
    private BookDisplayMapper bookDisplayMapper;


    

    @Override
    public List<Book> getAllBooks( Integer limit) {

        List<Book> books = bookDisplayMapper.getAllBooks();
        return books;
    }

   
    
}
