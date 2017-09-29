package com.ktjr.ktwd.groovy.ch10

import groovy.transform.TypeChecked

/**
 * Created by forker
 * on 2017/9/29.
 */
class TestTypeChecked {

    /**
     * Internally, the least upper bound is also used to
     * compute the inferred return type of a method or a closure
     * @return
     */
//    @TypeChecked
    def leastUpperBoundOnConditional(){
        def o = new Object()
        if(Math.random()){
            o = "hello"
        }
        o.time
    }
}
