package com.ktjr.ktwd.groovy.ch05

import org.junit.Test

/**
 * Created by forker on 2017/9/22.
 */
class MethodSpread {

    def fun(def a ,def b, def c){
        return a * b * c
    }

    @Test
    void test(){

        def arr = [1,2,4]
        def action = this.&fun
        def res = action(*arr)
        assert res == 8
    }


    @Test
    void test1(){
        def arr = ["2","f","sddd"]
        def action = this.&fun
        def res = action(*arr)
        assert res == null
    }


}
