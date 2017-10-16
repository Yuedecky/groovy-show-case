package com.ktjr.ktwd.groovy.ch15


/**
 * Created by yzy
 * on 2017/10/13.
 */
/**
 * groovy内置了Junit的测试框架：GroovyTestCase
 * 它包含了新的断言方法,这也有利于运行Groovy脚本伪装成测试用例
 *
 */
class Converter {

    static cellsius (fahrenheit){
        (fahrenheit -32 ) * 5 /9
    }

    static void main(String[] args) {
        assert 20 == cellsius(68)
        assert 35 == cellsius(95)

        assert -17 == cellsius(0).toInteger()

        testNotImplementedYet()
    }

    static void testNotImplementedYet(){

        if(GroovyTestCase.notYetImplemented(this)) return
        GroovyTestCase.fail("will be implemented tomorrow")
    }



}
