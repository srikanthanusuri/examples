package com.example.validations

class Password {

    static strength = { val ->
        if(val.trim().length() < 8) {
            return 'small'
        }

        def digitMatcher = (val =~ /\d/)
        if(digitMatcher.count < 3) {
            return 'not.enough.digits'
        }

        def punctuationMatcher = (val =~ /\p{Punct}/)
        if(punctuationMatcher.count == 0) {
            return 'not.enough.punctuations'
        }
        return true
    }

}
