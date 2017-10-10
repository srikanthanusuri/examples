package com.example.validations

import spock.lang.Specification

class PasswordSpec extends Specification {

    void "strength when password does not have enough letters"() {
        when: 'password does not have enough letters'
            def actual = Password.strength('tiny')
        then: 'the validator to return the appropriate message prefix'
            actual == 'small'
    }

    void "strength when password does not have any digits"() {
        when: 'password does not have any digits'
            def actual = Password.strength('nodigitsinthepassword')
        then: 'the validator to return the appropriate message prefix'
            actual == 'not.enough.digits'
    }

    void "strength when password does not have any punctuations"() {
        when: 'password does not have any punctuations'
            def actual = Password.strength('nopunctuationsinthepa55w0rd')
        then: 'the validator to return the appropriate message prefix'
            actual == 'not.enough.punctuations'
    }

    void "strength when password is strong enough"() {
        when: 'password is strong enough'
            def actual = Password.strength('punctuations!nthepa55w0rd')
        then: 'the validator to return the appropriate message prefix'
            actual == true
    }
}
