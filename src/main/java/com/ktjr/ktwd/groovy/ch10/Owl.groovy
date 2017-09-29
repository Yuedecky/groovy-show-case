package com.ktjr.ktwd.groovy.ch10

/**
 * Created by forker on 2017/9/29.
 */
class Owl implements Polite {


    @Override
    void greet() {

        hoot()
    }

    @Override
    void thank() {
        hoot()
    }

    void hoot() { println 'Hoot' }


    static void main(def args){

        def list = [new Person(name: 'Bill'),new Owl()]
        Polite p1 = list[0]
        Polite o1 = list[1]
        Owl o2 = list[0]
        Person p2 = list[1]
    }
}
