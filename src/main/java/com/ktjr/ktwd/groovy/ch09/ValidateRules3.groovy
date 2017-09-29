package com.ktjr.ktwd.groovy.ch09

/**
 * Created by forker on 2017/9/29.
 */
class ValidateRules3 {

    static def validate(User user, Closure rule){
        rule.delegate = user
        rule()
    }

    /**
     * The solution works but so far it’s dynamic. The type checker can’t know in general that the delegate has been set at runtime,
     * there are no explicit types for the closure, and on top of that there are now properties
     * like name and password that aren’t declared anywhere
     * @param user
     */
    static void validateAll(User user){
        validate(user){
            if(name.isEmpty())
                print "Empty name"
        }
        validate(user){
            if(password.size() < 8)
                println "Password too short"
        }


    }

    static void main(String[] args) {
        def bob = new User(name: 'Bob',password: 'secret')
        validateAll(bob)
    }
}
