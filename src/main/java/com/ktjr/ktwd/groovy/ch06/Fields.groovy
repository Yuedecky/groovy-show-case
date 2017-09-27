package com.ktjr.ktwd.groovy.ch06

/**
 * Created by forker on 2017/9/27.
 */
class Fields {

    /**
     * 在groovy中，你会经常发现诸如这样的表达式 object.name,下面就来说明一下当Groovy发现这种表达式如何解析引用：
     * 1。如果object指向一个map，object.name指向这个map中key为name的value，如果这个name是一个object的属性，那么这个属性就是引用（当让需要看方法的访问修饰符）
     * 2。每一个Groovy对象拥有一个实现getProperty(name)方法和setProperty(name,value)的机会,当你这样做了，这个实现是控制属性的访问的。比如map，使用这个机制暴漏key的属性
     * 3。字段访问可以使用提供object.get(name)方法打断。对groovy运行时这是最后的求助机会
     */

    static void main(String[] args) {
        def boxer = new Expando()
        assert null == boxer.takeThis
        boxer.takeThis = 'ouch'
        assert boxer.takeThis == 'ouch'
        boxer.fightBack = {
            times ->
                delegate.takeThis * times
        }
        assert  'ouchouchouch' == boxer.fightBack(3)
    }
}
