package com.ktjr.ktwd.groovy.ch10

/**
 * Created by forker on 2017/9/29.
 */
class TestClosureShareVariables {

    static def captureOfALocalVariable(){
        def msg = "hello"
        def c1 = {
            msg = 'Hi'
        }
        c1()
        assert msg == 'Hi'
    }

    static void main(String[] args) {
        captureOfALocalVariable()
        notAllowed()
    }

    /**
     * 特别是，对闭包共享变量的方法调用只能在存在于所有赋值的最小上界上的方法上实现。尝试使用其他方法将不能编译
     */

    /**
     * 即使在这个例子中，很明显，当闭包被调用时，总的来说，我们不能 做特定假设,因此，计算字符串和日期的最小上界。因为toUpperCase方法不在此最小上界定义，编译器将报告显式错误。
     * @return
     */
    static def notAllowed(){
        def var = 'String'
        def c1 = {
            var = new Date()
        }
        c1()
        var = var.toUpperCase()
    }
}
