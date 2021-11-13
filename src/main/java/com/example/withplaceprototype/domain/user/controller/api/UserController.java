//package com.example.withplaceprototype.domain.user.controller.api;
//
//import static com.example.withplaceprototype.domain.user.controller.api.UserController.USER_API_URI;
//
//import com.example.withplaceprototype.domain.user.domain.entity.User;
//import com.example.withplaceprototype.domain.user.dto.UserDto;
//import com.example.withplaceprototype.domain.user.service.LoginService;
//import com.example.withplaceprototype.domain.user.service.UserService;
//import javax.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@Slf4j
//@RequestMapping(USER_API_URI)
//public class UserController {
//
//    public static final String USER_API_URI = "/api/users";
//
//    public UserController(UserService userService,
//        LoginService loginService,
//        /**PasswordEncoder passwordEncoder**/) {
//        this.userService = userService;
//        this.loginService = loginService;
//        //this.passwordEncoder = passwordEncoder;
//    }
//
//    private final UserService userService;
//    private final LoginService loginService;
//    //private final PasswordEncoder passwordEncoder;
//
//    @PostMapping
//    public ResponseEntity<HttpStatus> singUp(@RequestBody @Valid UserDto userDto) {
//
//        boolean isDuplicated = userService.isDuplicatedEmail(userDto.getEmail());
//
//        if (isDuplicated) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).build();
//        }
//
//        User user = UserDto.toEntity(userDto, passwordEncoder);
//        userService.signUp(user);
//
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<HttpStatus> login(@RequestBody @Valid UserDto userDto) {
//
//        boolean isValidUser = userService.isValidUser(userDto, passwordEncoder);
//
//        if (isValidUser) {
//            loginService.login(userService.findUserByEmail(userDto.getEmail()).getId());
//            return ResponseEntity.ok().build();
//        }
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//    }
//}
