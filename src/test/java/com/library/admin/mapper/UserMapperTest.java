package com.library.admin.mapper;

import com.library.admin.mapper.UserMapper;
import com.library.admin.model.dto.UserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    @DisplayName("회원가입")
    public void testSaveUser() {
        // 테스트용 UserDTO 객체 생성
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id("testUser");
        userDTO.setUser_pass("password");
        userDTO.setUser_phone_number("1234567890");

        // UserDTO 객체 저장
        int result = userMapper.save(userDTO);

        // 저장된 행의 개수 확인
        assertEquals(1, result);
    }

    @Test
    @Transactional
    @DisplayName("중복 회원가입 방지")
    public void testSaveUserWithDuplicateId() {
        // 테스트용 UserDTO 객체 생성
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setUser_id("testUser");
        userDTO1.setUser_pass("password1");
        userDTO1.setUser_phone_number("1234567890");

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setUser_id("testUser");
        userDTO2.setUser_pass("password2");
        userDTO2.setUser_phone_number("9876543210");

        // 첫 번째 UserDTO 객체 저장
        userMapper.save(userDTO1);

        // 중복된 아이디로 저장 시 예외 발생 확인
        assertThrows(org.springframework.dao.DuplicateKeyException.class, () -> {
            userMapper.save(userDTO2);
        });
    }

    @Test
    @Transactional
    @DisplayName("null 일때 에러 발생")
    public void testSaveUserWithNullUserDTO() {
        // null인 UserDTO로 저장 시 예외 발생 확인
        assertThrows(org.springframework.dao.DataAccessException.class, () -> {
            userMapper.save(null);
        });
    }
}
