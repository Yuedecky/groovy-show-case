package com.ktjr.ktwd.groovy.ch04

/**
 * Created by forker on 2017/9/26.
 */
class TestFor {


    static void main(args) {
        def log = []
        try{
            myMethod()
        }catch (Exception e){
            log << e.toString()
        }finally {
            log << 'finally'
        }
        assert log.size() == 2
    }

    static void test1(){
        def store = ''
        for(String s in 'a'..'c')
            store += s
        assert store == 'abc'
        store = ''
        for(String s in [1,2,3]){
            store += s
        }
        assert store == '123'
        def myString = 'Old school Java'
        store = ''
        for (int i  : 0..<myString.size()) {
            store += myString[i]
        }
        assert store == myString
        myString = 'Groovy iterator'
        store = ''
        for(s in myString){
            store += s
        }
        assert store == myString
    }

    static void test4(){
        def file = new File("demo.txt")
        for(line in file)
            println line
    }


    static void test5(){
        for(x in null)
            println "This will not be printed"

        /**
         * 这个不是闭包
         */
        for(x in 0..9){
            println x
        }

        /**
         * 这个是闭包
         */
        (0..9).each{
            println it
        }
    }

    def static myMethod(){
        throw new IllegalArgumentException()
    }




}
