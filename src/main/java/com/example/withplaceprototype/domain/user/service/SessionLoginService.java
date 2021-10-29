package com.example.withplaceprototype.domain.user.service;

import com.example.withplaceprototype.domain.user.domain.entity.User;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionLoginService implements LoginService{

    private final HttpSession httpSession;
    private final UserService userService;
    public static final String USER_ID = "USER_ID";

    @Override
    public void login(long id) {
        httpSession.setAttribute(USER_ID, id);
    }

    @Override
    public void logout() {
        httpSession.removeAttribute(USER_ID);
    }

}
