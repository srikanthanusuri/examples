package com.example

import com.example.validations.Password
import org.grails.datastore.gorm.GormEntity

class User implements GormEntity<User> {

    String name
    String password

    static constraints = {
        name unique: true
        password validator: Password.strength
    }
}
