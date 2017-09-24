package com.ktjr.ktwd.groovy.ch01

/**
 * Created by forker on 2017/9/24.
 */
class TestStr {
    /**
     * string中增加了previous()和next()的方法 用来范围操作
     * @param args
     */
    static void main(args){


        def log = ""
        for(ele in 9..5){
            log += ele
        }
        assert log == '98765'

        def logs = ''
        (9..<5).each {
            it ->
                logs += it
        }
        assert   logs == '9876'

    }
}
