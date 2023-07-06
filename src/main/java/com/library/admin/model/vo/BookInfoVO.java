package com.library.admin.model.vo;

import lombok.Data;

import java.sql.Date;

@Data
public class BookInfoVO {
    private String book_isbn;
    private String book_title;
    private String book_author;
    private Date book_published_date;
}
