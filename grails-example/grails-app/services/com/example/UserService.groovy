package com.example

import grails.transaction.Transactional
import org.grails.cxf.utils.EndpointType
import org.grails.cxf.utils.GrailsCxfEndpoint

import javax.jws.WebMethod
import javax.jws.WebParam
import javax.jws.WebResult
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement

/**
 * For SOAP testing use the endpoint http://localhost:8080/webservices/user?wsdl
 */
@Transactional
@GrailsCxfEndpoint(address = '/user', expose = EndpointType.JAX_WS, name = 'user', soap12 = true)
class UserService {

    @WebMethod(operationName = 'getUser')
    @WebResult(name = 'User')
    User getUser(@WebParam(name = 'id') long id) {
        return User.findById(id)
    }

    @WebMethod(operationName = 'getUsers')
    @WebResult(name = 'Users')
    List<User> getUsers(@WebParam(name = 'page') Page page) {
        return User.list(page.properties)
    }
}

@XmlAccessorType(XmlAccessType.NONE)
class Page {
    @XmlElement
    int max = 10
    @XmlElement
    int offset = 0
    @XmlElement
    String sort = 'id'
    @XmlElement
    boolean ascending = true

    public int getMax() {
        return Math.min(100, max)
    }
}