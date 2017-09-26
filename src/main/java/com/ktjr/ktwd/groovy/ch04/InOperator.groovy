package com.ktjr.ktwd.groovy.ch04

/**
 * Created by forker on 2017/9/26.
 */
class InOperator {

    static def main(args) {

        test1()

        test3()

        test4()
    }

    /**
     * in操作符出现在三种情景下：
     * 1。switch case
     * 2。grep 分类
     * 3。如下
     */
    static void test1(){

        def okValues = [1,2,3]
        def value = 2
        assert value in okValues
    }


    static void test2(){
        def input = new File("no such file")
        assert input.exists() , "cannot find '${input.name}'"

        assert input.canRead(), "cannot read '$input.canonicalPath'"
        println input.text
    }

    static void test3(){
        def host = /\/\/([a-zA-Z0-9-]+(\.[a-zA-Z0-9-])*?)(:|\/)/

        assertHost 'http://a.b.c:8080/bla', host, 'a.b.c'
        assertHost "http://a.b.c/bla", host, 'a.b.c'

        assertHost 'http://t-online.de/bla', host, 't-online.de'


    }

    static def assertHost(candidate, regex,expected){
        candidate.eachMatch(regex){
            assert it[1] == expected
        }
    }

    /**
     * 需要注意的是：
     * 在Groovy中，没有do...while 或者 repeat..until
     */
    static void test4(){
        def list = [1,2,3]

        while (list){
            list.remove(0)
        }
        assert list == []
        while (list.size() < 3){
            list << list.size() + 1
        }
        assert list == [1,2,3]
    }
}
