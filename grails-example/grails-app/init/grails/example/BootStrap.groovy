package grails.example

import com.example.User
import org.apache.commons.lang.RandomStringUtils

class BootStrap {

    def init = { servletContext ->

        for (int i = 0; i < 100; i++) {
            def name = RandomStringUtils.randomAlphabetic(5)
            def alphanumeric = RandomStringUtils.randomAlphanumeric(10)
            def numeric = RandomStringUtils.randomNumeric(3)
            def punctuation = RandomStringUtils.random(1, '!@#$%')
            def password = "$alphanumeric$numeric$punctuation"
            new User(name: name, password: password).save()
        }
    }
    def destroy = {
        User.withNewSession {
            User.deleteAll()
        }
    }
}
