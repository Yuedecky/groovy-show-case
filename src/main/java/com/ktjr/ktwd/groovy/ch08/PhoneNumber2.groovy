package com.ktjr.ktwd.groovy.ch08

import groovy.transform.Synchronized
import groovy.util.logging.Log

/**
 * Created by forker
 * on 2017/9/28.
 */
@Log
class PhoneNumber2 {

    private final phoneNumbers = [:]
    private final lock = new Object()
    @Synchronized('lock')
    def getNumber(key){
        phoneNumbers[key]
    }

    def addNumber(key,value){
        log.info("add phone number $value")
        synchronized (lock){
            phoneNumbers[key] = value
        }
    }

    /**
     * Synchronization is a low-level, primitive operation
     *
     * Java has higher-level locking mechanisms as well,
     * and the following two annotations help make them easy to use.
     * @param args
     */
    static void main(String[] args) {

        def p2 =new PhoneNumber2()
        (0..99).collect{
            num ->
            Thread.start {
                p2.addNumber('Number'+num,'98765'+ num)
            }
        }*.join()
        assert p2.getNumber('Number43') == '9876543'
    }
}
