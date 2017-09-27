package com.ktjr.ktwd.groovy.ch07

/**
 * Created by forker on 2017/9/27.
 */
class Marshal {


    static String marshal(Integer self){
        self.toString()
    }

    static Integer unMarshal(String self){
        self.toInteger()
    }
}
