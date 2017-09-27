package com.ktjr.ktwd.groovy.ch07

use Marshal,{
    assert 1.marshal() == "1"
    assert "1".unMarshal() == 1
    [Integer.MIN_VALUE, -1,0,Integer.MAX_VALUE].each {
        assert it.marshal().unMarshal() == it
    }
}

def static method(Closure closure){
    closure.each {
        println it
    }
}
/**
 * Created by forker
 * on 2017/9/27.
 */

