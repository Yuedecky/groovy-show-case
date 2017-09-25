package com.ktjr.ktwd.groovy.ch01

import org.junit.Test

/**
 * Created by forker on 2017/9/22.
 */
class Run {

    static def main(args){
        def obj = new Object()
        println Hello(obj)
    }
    /**
     * 在groovy中会动态运行时判断传入的参数类型
     * 根据实际的传参lei x
     * @param java
     * @return
     */
    static String Hello(String java) {
        return "1 Hello ${java}"
    }
    static String Hello(Object groovy) {
        return "2 Hello ${groovy}"
    }

    @Test
    void testGroovy() {
        def person1 = ['id':12]
        def person2 = ['id':14]
        def Persons = [person1,person2] as List

        def person = Persons.find { it.id == 123 }    //返回一个Person对象person为null
        def name = person?.name             //使用这种操作符避免了空指针异常
        assert name == null
    }





}
