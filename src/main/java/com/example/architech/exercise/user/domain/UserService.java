package com.example.architech.exercise.user.domain;

import com.example.architech.exercise.user.dto.UserDto;
import com.example.architech.exercise.user.exception.InvalidLoginException;
import com.example.architech.exercise.user.exception.InvalidPasswordException;
import com.example.architech.exercise.user.exception.UserAlreadyExistException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Slf4j
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class UserService {

    Logger logger = LogManager.getLogger(this);

    UserRepository userRepository;
    PasswordValidator passwordValidator = new PasswordValidator();
    LoginValidator loginValidator = new LoginValidator();

    public UserDto addUser(UserDto userDto) {
        checkUserExist(userDto);
        checkLogin(userDto);
        checkPassword(userDto);
        User newUser = User.builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .build();
        return userRepository.save(newUser).dto();
    }

    private void checkUserExist(UserDto userDto) {
        String login = userDto.getLogin();
        if (userRepository.findOneByLogin(login).isPresent()) {
            logger.error("User [ " + userDto.getLogin() + " ] already exist");
            throw new UserAlreadyExistException("User already exist");
        }
    }

    private void checkPassword(UserDto userDto) {
        if (!passwordValidator.isValid(userDto.getPassword())) {
            logger.error("Password is invalid");
            throw new InvalidPasswordException("Password is invalid");
        }
    }

    private void checkLogin(UserDto userDto) {
        if (!loginValidator.isValid(userDto.getLogin())) {
            logger.error("Login is invalid");
            throw new InvalidLoginException("Login is invalid");
        }
    }
}
