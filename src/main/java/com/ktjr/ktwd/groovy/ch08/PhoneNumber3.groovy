package com.ktjr.ktwd.groovy.ch08

import java.util.concurrent.locks.ReentrantLock
import java.util.concurrent.locks.ReentrantReadWriteLock

/**
 * Created by forker on 2017/9/28.
 */
class PhoneNumber3 {

    private final phoneNumbers = [:]

    final private lock = new ReentrantReadWriteLock()

    def getNumber(key){
        lock.readLock().lock()
        try{
            phoneNumbers[key]
        }finally {
            lock.readLock().unlock()
        }
    }

    def addNumber(key,value){
        lock.writeLock().lock()
        try{
            phoneNumbers[key] = value
        }finally {
            lock.writeLock().unlock()
        }
    }
}
