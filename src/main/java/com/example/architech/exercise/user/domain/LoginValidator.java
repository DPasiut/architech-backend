package com.example.architech.exercise.user.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class LoginValidator {

    boolean isValid(String login){
        if(login != null){
            String regex = "[0-9a-zA-Z]{6,}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(login);
            return matcher.matches();
        }
        return false;
    }
}
