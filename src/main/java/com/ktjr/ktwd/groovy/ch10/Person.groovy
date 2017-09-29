package com.ktjr.ktwd.groovy.ch10

/**
 * Created by forker on 2017/9/29.
 */
class Person implements Polite {
    String name
    @Override
    void greet() {

        println "Hello I'm $name"
    }

    @Override
    void thank() {

        println "thanks"
    }
}
