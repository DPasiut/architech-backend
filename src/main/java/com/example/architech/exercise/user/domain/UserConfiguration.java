package com.example.architech.exercise.user.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserConfiguration {

    @Bean
    public UserFacade userFacade (UserRepository userRepository){
        return new UserFacade(userRepository);
    }

}
