package com.ktjr.ktwd.groovy.ch08

import groovy.transform.WithReadLock
import groovy.transform.WithWriteLock

/**
 * Created by forker
 * on 2017/9/28.
 */
class PhoneBook3 {

    private final phoneNumbers = [:]

    @WithReadLock
    def getNumber(key){
        println "reading started for $key"
        phoneNumbers[key]
        sleep 80
        println "Reading done for $key"
    }

    @WithWriteLock
    def addNumber(key,value){
        println "Writing started for $key"
        phoneNumbers[key] = value
        sleep 100
        println "Writing done for $key"
    }

    static void main(String[] args) {
        def p3 = new PhoneBook3()
        (3..4).each {
            sleep 100 * it
            p3.addNumber('Number'+it,'987643')
        }

        (2..6).collect{ count ->
            Thread.start {
                sleep 100 * count
                p3.getNumber('Number' + count)
            }
        }*.join()
    }
}
