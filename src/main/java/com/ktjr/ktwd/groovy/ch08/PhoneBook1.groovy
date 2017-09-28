package com.ktjr.ktwd.groovy.ch08

import groovy.transform.Synchronized

/**
 * Created by forker on 2017/9/28.
 */
/**
 * This annotation injects a lock object into your class
 * The object is a zero-length
 * Object array so that your class remains serializable
 */
class PhoneBook1 {

    private final phoneNumbers = [:]

    def getNumbe(key){
        phoneNumbers.get(key)
    }

    @Synchronized
    void addNumber(key,value){

        phoneNumbers[key] = value
    }

    static void main(String[] args) {
        def p1 =new PhoneBook1()
        (0..99).collect{ num ->
            Thread.start{
                p1.addNumber('Number:'+num, '98765'+num)
            }
        }*.join()
        p1.phoneNumbers.each {
             println it
        }
        assert p1.getNumbe('Number:43') == '9876543'
    }
}
