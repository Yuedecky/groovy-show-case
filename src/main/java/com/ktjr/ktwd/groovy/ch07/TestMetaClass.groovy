package com.ktjr.ktwd.groovy.ch07

/**
 * Created by forker on 2017/9/27.
 */
class TestMetaClass {

    /**
     * 对于在类加载器中的每一个class A，Groovy维持一个metaclass，一个类型为MetaClass的对象，这个metaclass维持着一个类A中的方法和属性的集合
     * 开始于A的字节码信息和添加附加的groovy得知的每一个默认的方法
     *
     * 通常来说，每一个class A的实例共享着相同的metaclass。但是groovy支持每一个实例都有一个metaclass，那就是不同的实例A可以执行不同的metaclass
     *
     */

    static void main(String[] args) {
        MetaClass mc = String.metaClass
        final Object[] NO_ARGS = []
        assert  1 == mc.respondsTo('toString', NO_ARGS).size()
        assert  3 == mc.properties.size()
        assert 76 == mc.methods.size()
        assert  177 ==mc.metaMethods.size()
        assert '' ==mc.invokeMethod('','toString',NO_ARGS)
        assert null == mc.invokeMethod(String,"println",NO_ARGS)
        assert  '' == mc.invokeMethod(NO_ARGS)
    }
}
