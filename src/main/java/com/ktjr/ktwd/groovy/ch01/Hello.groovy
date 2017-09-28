package com.ktjr.ktwd.groovy.ch01

import groovy.transform.TypeChecked

/**
 * Created by forker
 * on 2017/9/22.
 */
/**
 * The checking process includes verifying that fields and properties exist at compile time
 */
@TypeChecked
class Hello {
    def name
    /**
     *     1.所有的groovy class默认都是public的
     *     2.所有的class（被Groovy编译的class）都是实现了于GroovyObject接口
     *     3.类的所有方法默认都是public的
     *     4.类的所有属性默认都是public的
     *
     */
    def static main(def args){
        println "Hello Groovy!" // 不能比这个更hello world了吧
    }

    /**
     * 我想在这里说明以下groovy file和class的之间的关系：
     * 1.在这里，files和class之间的关系不像java那样固定，有一些规则可以遵循：
     * > 如果Groovy 文件没有声明的class，它将被视为脚本文件：也就是说，它会被透明的包装为一个类型为Script的class，与源文件同名的class，当然，还有一个run()方法和一个附加的main()方法去更好的启动这个脚本
     * > 如果Groovy文件包含一个与groovy文件同名的class声明，这就如同java的一对一关系
     * > 如果一个Groovy文件可能包含多个class声明（任意的可见性），并且没有强制的规则使它们必须和groovy文件同名。那么groovyc编译器将会愉快的为每一个声明的class生成*.class文件，如果你希望直接调用你的脚本，比如，在命令行中或者在IDE中使用groovy命令，那么第一个被声明为class的将拥有一个main()方法
     * >一个Groovy文件可能混杂class声明和脚本代码。在这种情况下，脚本代码将会变为main class执行，所以不要声明一个与源文件同名的class
     *
     *
     */
}
