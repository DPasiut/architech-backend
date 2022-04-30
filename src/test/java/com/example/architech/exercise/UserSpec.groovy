package com.example.architech.exercise

import com.example.architech.exercise.user.domain.InMemoryUserRepository
import com.example.architech.exercise.user.domain.UserService
import com.example.architech.exercise.user.dto.UserDto
import com.example.architech.exercise.user.exception.InvalidLoginException
import com.example.architech.exercise.user.exception.InvalidPasswordException
import com.example.architech.exercise.user.exception.UserAlreadyExistException
import spock.lang.Specification

class UserSpec extends Specification {

    InMemoryUserRepository repository = new InMemoryUserRepository()
    UserService service = new UserService(repository)
    UserDto userDto

    def "should thrown error when login is invalid"() {
        given: "There is a user with invalid login"
            userDto = new UserDto("invalidLogin!@# ", "CorrectPassword123")
        when: "User try register invalid data"
            service.addUser(userDto)
        then: "InvalidLoginException is thrown"
            thrown(InvalidLoginException)
        and: "user has not been added"
            !repository.findOneByLogin(userDto.getLogin()).isPresent()
    }

    def "should thrown error when password is invalid"() {
        given: "There is a user with invalid password"
            userDto = new UserDto("CorrectLogin", "passwordHasNoNumber")
        when: "User try register invalid data"
            service.addUser(userDto)
        then: "InvalidPasswordException is thrown"
            thrown(InvalidPasswordException)
        and: "user has not been added"
            !repository.findOneByLogin(userDto.getLogin()).isPresent()
    }

    def "should thrown error when user already exist"() {
        given: "There is a user"
            userDto = new UserDto("CorrectLogin", "CorrectPassword123")
        and: "User with the same login already exist"
            repository.addUser(1L, userDto)
        when: "User try register new user"
            service.addUser(userDto)
        then: "UserAlreadyExistException is thrown"
            thrown(UserAlreadyExistException)
    }

    def "should add user with correct login and password"() {
        given: "There is a user"
            userDto = new UserDto("CorrectLogin", "CorrectPassword123")
        when: "User try register new user"
            service.addUser(userDto)
        then: "user has been added"
            repository.findOneByLogin(userDto.getLogin()).isPresent()
    }

}
