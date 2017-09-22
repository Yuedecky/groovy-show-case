package com.ktjr.ktwd.groovy.ch04

import org.junit.Test

/**
 * Created by forker on 2017/9/22.
 */
class TestAsWords {
    @Test
    void test(){
        def u = new User(name : 'Xavier')
        def p = u as Identifiable
        assert p instanceof Identifiable
        assert !(p instanceof User)
    }

    @Test
    void test1(){
        Map map = [age: 23,name: "lisi", id:45]
        def u = new User(map)
        assert u.age == 23
    }
}
