package com.ktjr.ktwd.groovy.ch05

import org.junit.Test

/**
 * Created by forker on 2017/9/22.
 */
class IsOperator {

    @Test
    void test(){

        Integer num = 123
        def strInt  = (String)num
        assert strInt == '123'

        def list1 = ['Groovy 1.8','Groovy 2.0','Groovy 2.3']
        def list2 = ['Groovy 1.8','Groovy 2.0','Groovy 2.3']
        assert list1 == list2
        assert !list1.is(list2)
    }
}
