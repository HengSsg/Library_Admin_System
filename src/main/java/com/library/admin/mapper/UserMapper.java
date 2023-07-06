package com.library.admin.mapper;

import com.library.admin.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int save(UserDTO userDTO);
}
