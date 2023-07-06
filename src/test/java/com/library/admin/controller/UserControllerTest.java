package com.library.admin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.admin.mapper.UserMapper;
import com.library.admin.model.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserMapper userMapper;

    @Test
    public void testSaveUser() throws Exception {
        // 가짜 UserDTO 객체 생성
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id("testUser");
        userDTO.setUser_pass("password");
        userDTO.setUser_phone_number("01099503964");

        // Mock 객체의 save 메서드가 호출되었을 때 아무 동작도 하지 않도록 설정
        Mockito.doNothing().when(userMapper).save(Mockito.any(UserDTO.class));

        // POST 요청 보내기
        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(userDTO)))
                .andExpect(status().isOk());

        // userMapper의 save 메서드가 1번 호출되었는지 확인
        Mockito.verify(userMapper, Mockito.times(1)).save(Mockito.any(UserDTO.class));
    }

    // 객체를 JSON 문자열로 변환하는 유틸리티 메서드
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
