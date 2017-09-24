package com.ktjr.ktwd.groovy.ch01

/**
 * Created by forker on 2017/9/24.
 */
class TestSwitch {

    static void main(args){

        test2()
    }

    void test1(){
        def age =36
        def insurance = 0
        switch (age){
            case 10..20 : insurance = 0.03;break
            case 21..30 : insurance = 0.05;break
            case 31..40 : insurance = 0.08;break
            default:throw new IllegalArgumentException()
        }
        assert insurance == 0.08
    }

    static void test2(){
        def age = [20,34,54,67]
        def midAge = 21..50
        assert age.grep(midAge) == [34]
    }
}
