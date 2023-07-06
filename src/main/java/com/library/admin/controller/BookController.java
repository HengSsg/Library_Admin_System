package com.library.admin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/rent")
public class BookController {



    @PostMapping("/{id}")
    public void rentBook() { // 대출하기

    }
}
