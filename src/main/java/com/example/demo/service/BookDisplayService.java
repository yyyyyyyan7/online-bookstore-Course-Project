package com.example.demo.service;

import com.example.demo.entity.Book;


import java.util.List;

public interface BookDisplayService {

   
    List<Book> getAllBooks(Integer limit);

 
    List<Book> searchBooksByBookName(Integer page, Integer limit,String bookName);
}

