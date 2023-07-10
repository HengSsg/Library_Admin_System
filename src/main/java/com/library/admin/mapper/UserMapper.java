package com.library.admin.mapper;

import com.library.admin.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    // 회원가입
    int save(UserDTO userDTO);

    // book_user max_book 갯수 감소

    // book_user max_book 갯수 증가

    // user_status 상태 변경

    //
}
