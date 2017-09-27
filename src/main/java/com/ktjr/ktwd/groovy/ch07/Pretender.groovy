package com.ktjr.ktwd.groovy.ch07

/**
 * Created by forker on 2017/9/27.
 */

    /**
     * 动态语言编程has a wide range of applicability:
     * 1.设计dsl
     * 2.实现builders设计模式
     * 3.高级的日志、跟踪、调试和调优
     * 4.自动化测试驱动开发
     * 5.在现有的API上添加lipstick
     * 6.组织你的代码库
     */

    /**
     * MOP是如何对方法调用的请求由Groovy运行时系统处理规则的集合。以及如何处理中间层控制
     */

    class Pretender{
        def methodMissing(String name,Object args){
            "called $name with $args"
        }


    }


