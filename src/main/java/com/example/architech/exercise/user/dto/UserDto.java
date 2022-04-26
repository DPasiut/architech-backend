package com.example.architech.exercise.user.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class UserDto {
    String login;
    String password;
}
