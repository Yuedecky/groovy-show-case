package com.ktjr.ktwd.groovy.ch08

import groovy.transform.TypeChecked

/**
 * Created by forker on 2017/9/29.
 */
class ClosureTypeChecking {
    /**
     * closure are very similar to methods:they are blocks of code that can accept parameters and return values.
     * when it comes to typr checking,however, there is big difference between a method and a closure:while in the first
     * one the signature is declared explicitly,what gives the closures their name is the fact that they are able to capture local variables
     * and references from the enclosing scope
     */

    static def sum1(int x, int y) {
        x + y
    }

    /**
     * The difference is that the closure can be manipulated as data,
     * making it ideal to be passed as an arguments to a method
     * @param args
     */
    static void main(String[] args) {
        def sum2 = {
            int x, int y ->
                x + y
        }
        assert sum1(4, 5) == 9
        assert sum2(4, 5) == 9
    }

    /**
     * As closures are Callable,
     * it’s possible to call them using the same syntax as a
     regular method call
     */


    @TypeChecked
    static class Logger {
        static void print(Closure<String> messageProvider) {
            println "Received message: ${messageProvider()}"
        }

        static void main(args) {
            def returnString = { "Hello Groovy " }
            def returnInt = {
                int x, int y
                    ->
                    x * y
            }
            Logger.print(returnString)
//            Logger.print (returnInt)
        }
    }
}
