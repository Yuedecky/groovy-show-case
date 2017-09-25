package com.ktjr.ktwd.groovy.ch02

/**
 * Created by forker on 2017/9/25.
 */
class TestClosure {

    static void main(args){

        def slow = benchMark(10000){
            (int) it/2
        }
        def fast = benchMark(10000){
            it.intdiv(2)
        }
        assert fast * 2 < slow

        useMem()
        test6()
    }

    static void test1(){
        def adder = {
            x,y ->
                return x+y
        }
        assert adder(2,3) == 5
        assert adder.call(4,5) == 9
    }

    static def benchMark(int repeat, Closure worker){
        def start = System.nanoTime()
        repeat.times{
            worker(it)
        }
        def stop = System.nanoTime()
        return stop - start
    }

    /**
     * This code takes 0.001 seconds on our machine to execute. Without memoize it takes
     about 20 seconds!
     */
    static void useMem(){
        def fib
        def start = System.currentTimeMillis()
        fib = { it < 2 ? 1 : fib(it-1) + fib(it-2) }
        def end = System.currentTimeMillis()
        fib = fib.memoize()
        assert fib(40) == 165_580_141
        println (end-start)
    }

    static void test6(){
        def odd = {it % 2 == 1}
        assert [1,2,3].grep(odd) == [1,3]

        switch (10){
            case odd:assert false
        }
        if(2 in odd) assert false

    }
}
