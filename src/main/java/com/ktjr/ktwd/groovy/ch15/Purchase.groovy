package com.ktjr.ktwd.groovy.ch15

import groovy.transform.TupleConstructor

/**
 * Created by yzy
 * on 2017/10/13.
 */
@TupleConstructor
class Purchase {

    def name,number,completed = false

    def fill(theater){
        if(theater.hasSeatsAvailable(name,number)){
            theater.purchaseTicket(name,number)
            completed = true
        }
    }
}
