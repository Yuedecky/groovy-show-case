package com.ktjr.ktwd.groovy.ch10

/**
 * Created by forker on 2017/9/29.
 */
class Canary extends Bird {

    void sing(){
        print "Tweet"
    }

    static void main(String[] args) {
        def o = new Bird()
        o.fly()
        o = new Canary()
        o.fly()
        o.sing()
    }
}
