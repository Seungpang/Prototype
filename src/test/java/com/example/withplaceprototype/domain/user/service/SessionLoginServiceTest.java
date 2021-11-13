package com.example.withplaceprototype.domain.user.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.withplaceprototype.domain.user.domain.entity.User;
import com.example.withplaceprototype.domain.user.exception.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpSession;

@ExtendWith(MockitoExtension.class)
class SessionLoginServiceTest {

    private SessionLoginService loginService;

    @Mock
    private UserService userService;

    private MockHttpSession mockHttpSession;

    private User user;

    @BeforeEach
    void setUp() {

        user = User.builder()
            .email("withPlace@admin.com")
            .password("1234asdf")
            .nickname("김위플")
            .build();

        mockHttpSession = new MockHttpSession();

        loginService = new SessionLoginService(mockHttpSession, userService);
    }

    @Test
    void failToLoginUserNotFound() {
        //given
        when(userService.findUserByEmail(any())).thenThrow(UserNotFoundException.class);

        //then
        assertThrows(UserNotFoundException.class, () -> {
            userService.findUserByEmail(user.getEmail());
        });
    }

}