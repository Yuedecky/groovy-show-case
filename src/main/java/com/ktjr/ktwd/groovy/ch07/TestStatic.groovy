package com.ktjr.ktwd.groovy.ch07

/**
 * Created by forker on 2017/9/27.
 */
class TestStatic {

    static void main(String[] args) {

        test()
    }

    static void test(){
        Integer.metaClass.static.answer = {
            ->
            42
        }
        assert Integer.answer() == 42
    }
}
