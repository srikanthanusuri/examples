package com.example

import com.example.validations.Password
import org.grails.datastore.gorm.GormEntity

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement

@XmlAccessorType(XmlAccessType.NONE)
class User implements GormEntity<User> {

    @XmlElement
    Long id
    @XmlElement
    String name
    @XmlElement
    String password

    static constraints = {
        name unique: true
        password validator: Password.strength
    }
}
