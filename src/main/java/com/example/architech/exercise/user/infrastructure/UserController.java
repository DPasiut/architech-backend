package com.example.architech.exercise.user.infrastructure;

import com.example.architech.exercise.user.domain.UserFacade;
import com.example.architech.exercise.user.dto.UserDto;
import com.example.architech.exercise.user.exception.CriteriaException;
import com.example.architech.exercise.user.exception.UserAlreadyExistException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "user")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(this);

    UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        try {
            return new ResponseEntity<>(userFacade.addUser(userDto), HttpStatus.OK);
        }catch (UserAlreadyExistException e){
            logger.error(e.getLocalizedMessage());
        }
        return ResponseEntity.internalServerError().build();
    }
}
