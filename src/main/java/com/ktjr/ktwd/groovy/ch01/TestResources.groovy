package com.ktjr.ktwd.groovy.ch01

import org.junit.Test

/**
 * Created by forker on 2017/9/22.
 */
class TestResources {

    @Test
    void test(){
        def basePath = TestResources.class.getResource("/").toString().split("file:/")[1]
        println basePath
        println this.class.classLoader.properties
        Class aClass = new GroovyClassLoader().parseClass(new File(basePath+"/com/ktjr/ktwd/groovy/ch01/Song.class"))
        GroovyObject groovyObject = aClass.newInstance() as GroovyObject
        String a = 12
        println basePath
        println a //   内置类型转换 这个吊^_^
        println groovyObject
    }

    /**
     *  既然在Groovy中 所有类的属性都是默认为public的
     *  那么 当我声明一个私有的private的属性时 怎么访问？
     *  使用.@符号 ^_^ 或者直接.
     *
     */
    @Test
     void test1(){
        String path = System.properties."user.dir"+"/src/main/java/com/ktjr/ktwd/groovy/ch01/Book.groovy"
        def file = new File(path)
        def clazz = new GroovyClassLoader().parseClass(file)
        GroovyObject book = (GroovyObject)clazz.newInstance()
        book.@name = "A计划"
        book.author = "成龙"
        book.invokeMethod("readers", [new User(name:"z3",age:23),new User(name: 'l4', age: 45)] as List)
        println book
    }


    @Test
    void test2(){
        String path = System.properties."user.dir"+"/src/main/java/com/ktjr/ktwd/groovy/ch01/Book.groovy"
        def file = new File(path)
        GroovyShell shell = new GroovyShell()
        Script script = shell.parse(file)
        println script.metaClass
        Object[] args = {}
        script.invokeMethod("readers", args)
    }
}
