package com.example.architech.exercise

import com.example.architech.exercise.user.domain.LoginValidator
import com.example.architech.exercise.user.domain.PasswordValidator
import spock.lang.Specification

class ValidatorSpec extends Specification {

    def "should return false when login is invalid"() {
        given: "there is an incorrect login"
            String invalidPassword = "NewUser!@#"
        when: "login is validating"
            LoginValidator loginValidator = new LoginValidator()
            boolean result = loginValidator.isValid(invalidPassword)
        then: "result is false"
            !result
    }

    def "should return false when password is invalid"() {
        given: "there is a incorrect password"
            String invalidPassword = "abc"
        when: "password is validating"
            PasswordValidator passwordValidator = new PasswordValidator()
            boolean result = passwordValidator.isValid(invalidPassword)
        then: "Throws an exception"
            !result
    }

    def "should return true when login is correct"() {
        given: "there is an correct login"
            String correctLogin = "NewUser1234"
        when: "login is validating"
            LoginValidator loginValidator = new LoginValidator()
            boolean result = loginValidator.isValid(correctLogin)
        then: "result is true"
            result
    }

    def "should return true when password is correct"() {
        given: "there is a incorrect password"
            String correctPassword = "1Aa23456"
        when: "password is validating"
            PasswordValidator passwordValidator = new PasswordValidator()
            boolean result = passwordValidator.isValid(correctPassword)
        then: "result is true"
            result
    }
}
