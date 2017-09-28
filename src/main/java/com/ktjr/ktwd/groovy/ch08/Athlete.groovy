package com.ktjr.ktwd.groovy.ch08

import groovy.transform.TupleConstructor

/**
 * Created by forker
 * on 2017/9/28.
 */
@TupleConstructor
class Athlete {
    String firstName,lastName

    static void main(String[] args) {
        def a1 = new Athlete('Michael','Jordan')
        def a2 = new Athlete('Michael')
        assert a1.firstName == a2.firstName
    }
}
