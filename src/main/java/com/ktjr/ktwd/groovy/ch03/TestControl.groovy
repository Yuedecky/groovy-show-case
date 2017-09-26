package com.ktjr.ktwd.groovy.ch03

/**
 * Created by forker on 2017/9/25.
 */
class TestControl {

    static void main(def args) {
        test1()
    }

    static void test1(){
        assert true
        assert !false
        assert ('a' =~ /./)
        assert !('a' =~ /b/)
        assert [1]
        assert ![]
        Iterator iterator = [1].iterator()
        assert iterator
        iterator.tail()
        assert !iterator

        assert ['a':1]
        assert ![:]
        assert 'a'
        assert !''
        assert 1
        assert 1.1
        assert 1.2f
        assert 2L
        assert 3G
        assert !0
        assert !null
        assert new Object()

        assert !new AlwaysFalse()

    }

    static class AlwaysFalse{
        boolean asBoolean(){
            false
        }
    }


    static void test2(){
        def x = 1
        /**
         *  编译报错
         */
//        if(x=2){
//
//        }

        if((x=3)){
            println(x)
        }

        assert x == 3
        def store = []
        while(x=x-1){
            store << x
        }

        assert store == [2,1]


        while (x=2){
            println x
            break
        }
    }

}
