package com.ktjr.ktwd.groovy.ch01

/**
 * Created by forker on 2017/9/24.
 */
class TestDate {

    /**
     * GDK在java.util.date中增加了minus()和plus()方法
     * @param args
     */
    static void main(args){
        def date = new Date()
        def after = date + 2
        println after
    }


}
