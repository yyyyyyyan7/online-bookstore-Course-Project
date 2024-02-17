package com.example.demo.dao;

import com.example.demo.entity.Book;

import java.util.List;

public interface BookMapper {
    int deleteByBookId(Integer bookId);

    int insert(Book record);

    Book selectByBookId(Integer bookId);

    int updateByBookId(Book record);

    List<Book> selectAllByCategoryCode(String categoryCode);

    List<Book> selectByBooks(Book book);


}