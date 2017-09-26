package com.ktjr.ktwd.groovy.ch02

/**
 * Created by forker on 2017/9/25.
 */
class TestClosureAdvance {




    static class Mother{
        def prop = 'prop'
        def method(){
            'method'
        }

        Closure birth(param) {
            def local = 'local'
            def closure = {
                [this, prop, method(), local,param,owner]
            }
            return closure
        }
    }


    static void main(def args) {

        Mother julia = new Mother()
        def closure = julia.birth('param')
        def context = closure.call()
        assert context[0] == julia

        assert context[1,2] == ['prop','method']

        assert context[3,4] == ['local','param']


        assert closure.thisObject == julia
        assert closure.owner == julia

        assert closure.delegate == julia
        assert closure.resolveStrategy == Closure.OWNER_FIRST

    }

    static void test2(){
        def map = [:]
        map.with {
            a = 1 //same as map.a = 1
            b = 2 //same as map.b = 2
        }

        assert map == [a:1,b:2]
    }

    static def foo(n){
        return { n+= it}
    }

    static void test3(){
        def accumulator = foo(1)
        assert accumulator(2) == 3
        assert accumulator(1) == 4
    }

    /**
     * 闭包的返回值问题：
     * 1。最后一个表达式的值默认为闭包的返回值，此时return是可选的
     * 2。当然，return加上无论何时也不会错
     *
     */

    def static testReturn(){
        [1,2,3].collect{ it * 2}
    }

}
