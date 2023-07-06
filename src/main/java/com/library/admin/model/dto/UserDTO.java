package com.library.admin.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String user_id;
    private String user_pass;
    private String user_phone_number;

    public UserDTO() {
        // 기본 생성자 내용
    }

}
