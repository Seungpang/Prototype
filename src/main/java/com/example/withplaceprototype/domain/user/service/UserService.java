package com.example.withplaceprototype.domain.user.service;

import static com.example.withplaceprototype.global.common.ErrorCode.EMAIL_DUPLICATION;
import static com.example.withplaceprototype.global.common.ErrorCode.NOT_FOUND_USER;

import com.example.withplaceprototype.domain.exception.BusinessException;
import com.example.withplaceprototype.domain.user.domain.entity.User;
import com.example.withplaceprototype.domain.user.domain.repository.UserRepository;
import com.example.withplaceprototype.domain.user.dto.UserDto;
import com.example.withplaceprototype.domain.user.exception.UserDuplicatedEmailException;
import com.example.withplaceprototype.domain.user.exception.UserNotFoundException;
import com.example.withplaceprototype.global.common.ErrorCode;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User signUp(User user) {
        return userRepository.save(user);
    }


    public boolean isDuplicatedEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean isValidUser(UserDto userDto, PasswordEncoder passwordEncoder) {
        User user = findUserByEmail(userDto.getEmail());

        if (passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            return true;
        }
        return false;
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow( ()->
            new UserNotFoundException(NOT_FOUND_USER));
    }

}
