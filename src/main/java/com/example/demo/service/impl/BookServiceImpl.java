package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.example.demo.dao.BookMapper;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;
	@Override
	public Book bookSearchById(Integer bookId) {
		// TODO Auto-generated method stub
		Book books=bookMapper.selectByBookId(bookId);
		return books;
	}


	@Override
	public int bookDeleteSearchById(Integer bookId) {
		// TODO Auto-generated method stub
		int books=bookMapper.deleteByBookId(bookId);
		return books;
	}

	@Override
	public int bookInsert(Book record) {
		// TODO Auto-generated method stub
		int books=bookMapper.insert(record);
                return books;
	}

	@Override
	public int bookUpdate(Book record) {
		// TODO Auto-generated method stub
		int books=bookMapper.updateByBookId(record);
		return books;

	}


	@Override
	public List<Book> searchBooks(Book book, Integer page, Integer limit) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'searchBooks'");
	}


}
