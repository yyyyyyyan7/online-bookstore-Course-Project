package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Book;

   public interface BookService {
	
    Book bookSearchById(Integer bookId);
   
    int bookDeleteSearchById(Integer bookId);
   
    int bookInsert(Book record);
  
    int bookUpdate(Book record);

    List<Book> searchBooks(Book book,Integer page,Integer limit);
}
