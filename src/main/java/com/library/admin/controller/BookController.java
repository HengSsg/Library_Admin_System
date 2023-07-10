package com.library.admin.controller;

import com.library.admin.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/rent")
public class BookController {
    BookMapper bookMapper;


    @Autowired
    public BookController(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @PostMapping("/{id}")
    public void rentBook() { // 대출하기

    }
}
