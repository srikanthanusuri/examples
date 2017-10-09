package com.example

import org.grails.datastore.gorm.GormEntity

class User implements GormEntity<User> {

    String name
    String password

    static constraints = {
    }
}
