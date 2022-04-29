package com.example.architech.exercise.user.infrastructure;

import com.example.architech.exercise.user.domain.UserService;
import com.example.architech.exercise.user.dto.UserDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "user")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
