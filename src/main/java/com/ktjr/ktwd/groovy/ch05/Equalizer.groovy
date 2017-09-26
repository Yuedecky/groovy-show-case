package com.ktjr.ktwd.groovy.ch05

/**
 * Created by forker on 2017/9/26.
 */
class Equalizer {

    boolean equals(Equalizer equalizer){
        return true
    }

    static void main(args){
        def same = new Equalizer()
        def other = new Object()
        assert new Equalizer().equals(same)
        assert new Object().equals(other) //Object.equals()
    }
}
