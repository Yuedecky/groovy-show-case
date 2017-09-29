package com.ktjr.ktwd.groovy.ch09

import groovy.transform.TypeChecked
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FirstParam

/**
 * Created by forker on 2017/9/29.
 */
class ValidateRules2 {

    /**
     * The @ClosureParams annotation is added to the closure parameter
     * The @ClosureParams annotation minimally accepts one argument
     * The type hint is a class that’s responsible for completing type information
     at compile time for the closure

     * which indicates to the type checker that the closure
     will accept one parameter of which the type is the type of the first parameter of the first parameter of the method
     * @param user
     * @param rule
     */
    static void validate(User user,@ClosureParams(FirstParam) Predicate<User> rule){
        if(!rule.apply(user)){
            println "User $user.name $user.password rejected"
        }

    }

    @TypeChecked
    static void validateAll(User user){
        validate(user){
            !it.name.isEmpty()
        }
        validate(user){
            it.password.size() > 7
        }
    }

    static void main(String[] args) {
        def bob = new User(name: 'Bob', password: 'secret')

        validateAll(bob)
    }

    /**
     * Some hint type classes support optional information; for example,
     * if you have a closure
     that takes two arguments, a String and an int, you could use: @ClosureParams(value=SimpleType,options=['java.lang.String','int']) closure c
     */
}
