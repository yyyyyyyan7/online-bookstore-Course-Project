package com.example.demo.controller;
import com.github.pagehelper.PageInfo;
import com.example.demo.service.BookDisplayService;
import com.example.demo.entity.Book;
import com.example.demo.util.ResultCode;
import com.example.demo.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/index")
public class BookDisplayController {

    @Autowired
    private BookDisplayService bookDisplayService;

  
    @GetMapping("/books")

    public String books(Model model) {
        List<Book> books = bookDisplayService.getAllBooks(null);
        model.addAttribute("books", books);
        return "books";
    }

 
}
