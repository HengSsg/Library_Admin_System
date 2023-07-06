package com.library.admin.model.vo;

import lombok.Data;

import java.sql.Date;

@Data
public class BookUseStatusVO {
    private int book_seq;
    private String user_id;
    private Date borrow_start;
    private Date borrow_end;
    private Date return_date;
}
