package com.example

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "save"() {
        given: 'The domain class is initialized'
            domain.name = 'foo'
            domain.password = 'bar123!$'
        and: 'The domain instance is saved'
            domain.save()
        expect:'The id should be automatically generated'
            domain.id > 0
        and: 'The instance from the database should be the same as domain'
            def user = User.findById(domain.id)
            user == domain
    }
}
