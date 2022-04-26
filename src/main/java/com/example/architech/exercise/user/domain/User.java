package com.example.architech.exercise.user.domain;

import com.example.architech.exercise.user.dto.UserDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "user_example")
@FieldDefaults(level = AccessLevel.PRIVATE)

class User {
    @Id
    @Setter(value = AccessLevel.PACKAGE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long user_id;

    @Column(name = "login")
    String login;

    @Column(name = "password")
    String password;

    UserDto dto(){
        return UserDto.builder()
                .login(login)
                .password(password)
                .build();
    }
}
