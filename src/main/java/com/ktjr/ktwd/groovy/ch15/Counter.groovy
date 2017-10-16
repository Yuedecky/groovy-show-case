package com.ktjr.ktwd.groovy.ch15

/**
 * Created by yzy
 * on 2017/10/13.
 */
class Counter {

    static void main(String[] args) {

    }

    int biggerThan(items,threshold) {
        return items.grep { it > threshold }.size()
    }
}
