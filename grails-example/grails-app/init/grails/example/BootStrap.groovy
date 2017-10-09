package grails.example

import com.example.User
import org.apache.commons.lang.RandomStringUtils

class BootStrap {

    def init = { servletContext ->

        for (int i = 0; i < 100; i++) {
            def name = RandomStringUtils.randomAlphabetic(5)
            def password = RandomStringUtils.randomAlphanumeric(10)
            new User(name: name, password: password).save()
        }
    }
    def destroy = {
        User.withNewSession {
            User.deleteAll()
        }
    }
}
