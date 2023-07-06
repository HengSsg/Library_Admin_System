package com.library.admin.model.vo;

import lombok.Data;

import java.sql.Date;

@Data
public class BookUserVO {
    private int user_seq;
    private String user_id;
    private String user_pass;
    private String user_phone_number;
    private String user_status;
    private String user_grade;
    private int max_book;
    private Date service_stop;
}
