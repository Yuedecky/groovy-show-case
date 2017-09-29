package com.ktjr.ktwd.groovy.ch09


/**
 * Created by forker on 2017/9/29.
 */
class ValidateRules {


    static void validate(User user, Closure<Boolean> rule){
        if(!rule.call(user)){
            println "User $user.name $user.password rejected"
        }
    }

    static void validateAll(User user){
        validate(user){
            !it.name.isEmpty()
        }
        validate(user){
            it.password.size() > 7
        }
        //other rules
    }

    static void main(String[] args) {

        def bob = new User(name: 'Bob', password: 'secret')
        validateAll(bob)
    }

}
