package com.ktjr.ktwd.groovy.ch07

/**
 * Created by forker on 2017/9/27.
 */
class TestDynamic {

    static void main(String[] args) {
        def bounce = new Pretender()
        assert bounce.hello('world') == 'called hello with [world]'
    }
}
