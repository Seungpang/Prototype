package com.example.withplaceprototype.domain.user.dto;

import com.example.withplaceprototype.domain.user.domain.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotEmpty
    @Email(message = "유효하지 않은 이메일 형식입니다.",
        regexp = "^[\\\\w!#$%&'*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$")
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String nickname;

    public static User toEntity(UserDto userDto, PasswordEncoder passWordEncoder) {
        return User.builder()
            .email(userDto.getEmail())
            .password(passWordEncoder.encode(userDto.getPassword()))
            .nickname(userDto.getNickname())
            .build();
    }
}
