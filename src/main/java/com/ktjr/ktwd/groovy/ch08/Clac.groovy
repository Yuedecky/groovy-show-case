package com.ktjr.ktwd.groovy.ch08

import groovy.transform.Memoized

/**
 * Created by forker
 * on 2017/9/28.
 */

/**
 * 把计算结果缓存起来
 */
class Clac {
    static log = []


    @Memoized
    static int sum(int a,int b){

        log << "$a + $b"
        a +b
    }

    static void main(String[] args) {
        assert sum(3,4) == 7
        assert sum(4,4) == 8
        assert sum(3,4) == 7
        assert log.join(' ') == '3 + 4 4 + 4'
    }
}
