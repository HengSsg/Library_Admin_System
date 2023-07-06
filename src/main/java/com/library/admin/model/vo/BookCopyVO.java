package com.library.admin.model.vo;

import lombok.Data;

@Data
public class BookCopyVO {
    private int book_seq;
    private String book_position;
    private String book_status;
    private String book_isbn;
}
