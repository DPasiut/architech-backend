package com.example.architech.exercise.user.domain;

import com.example.architech.exercise.user.dto.UserDto;
import com.example.architech.exercise.user.exception.UserAlreadyExistException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class UserFacade {
    UserRepository userRepository;
    PasswordValidator passwordValidator = new PasswordValidator();
    LoginValidator loginValidator = new LoginValidator();

    public UserDto addUser(UserDto userDto) throws UserAlreadyExistException {
        isUserExist(userDto);
        User newUser = User.builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .build();
        return userRepository.save(newUser).dto();
    }

    private void isUserExist(UserDto userDto) throws UserAlreadyExistException {
        String login = userDto.getLogin();
        if (userRepository.findOneByLogin(login).isPresent()) {
            throw new UserAlreadyExistException("User [ " + login + " ] already exist");
        }
    }

//    private void isCriteriaValid(UserDto userDto) throws CriteriaException {
//        if (!loginValidator.isValid(userDto.getLogin())
//                || !passwordValidator.isValid(userDto.getPassword())) {
//            throw new CriteriaException("Login or password is invalid");
//        }
//    }
}
