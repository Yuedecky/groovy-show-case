package com.ktjr.ktwd.groovy.ch01

import groovy.transform.TypeChecked

/**
 * Created by forker
 * on 2017/9/28.
 */
@TypeChecked
class Repeat {

    /**
     * Since @TypeChecked works at compile time it cannot always know
     * what the runtime method dispatch will do
     * This will later become more important when we introduce @CompileStatic,
     * which additionally has an effect on the generated code.
     * @param n
     * @param message
     */

    /**
     * Here, def is equivalent to declaring it as Object,
     * but because Groovy resolves method calls at runtime,
     * the compiler doesn’t need to know the explicit type at compile time
     */
    def str = 'Type is implicit'
    static void repeat(int n, String message){


        n.times {
            println message + str
        }
    }
    static void main(String... args){
        repeat(3,"hello")
    }
}
