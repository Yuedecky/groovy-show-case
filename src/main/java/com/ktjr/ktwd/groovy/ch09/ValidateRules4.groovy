package com.ktjr.ktwd.groovy.ch09

import groovy.transform.TypeChecked

/**
 * Created by forker on 2017/9/29.
 */
class ValidateRules4 {

    def validate(User u, @DelegatesTo(User) Closure rule) {
        rule.delegate = u
        rule()
    }

    @TypeChecked
   void validateAll(User u) {
        validate(u) { if (name.isEmpty()) println 'Empty name' }
        validate(u) { if (password.size() < 8) println 'Password too short' }
    }


    static void main(String[] args) {
        def bob = new User(name: 'bob',password: 'secret')
        ValidateRules4 rules4 = new ValidateRules4()
        rules4.validateAll(bob)
    }


}
