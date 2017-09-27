package com.ktjr.ktwd.groovy.ch07

/**
 * Created by forker on 2017/9/27.
 */

/**
 * 再次，您可以根据自己的喜好在Groovy类中实现任何这样的方法。
 如果没有，那么Groovy编译器将为您插入一个默认的实现
 */
class GroovyObjectSupport implements GroovyObject{

    /**
     * 只要一个class实现了GroovyObject，下面的规则将遵循：
     * 1.没一个属性的访问 需要调用getProperty()方法
     * 2.每一个属性的修改需要调用setProperty()方法，如果实现了GroovyObject接口和标志接口GroovyInterceptable，如果知道要调用的方法，只调用一次invokeMethod()
     * @param name
     * @param args
     * @return
     */
    Object invokeMethod(String name,Object args){

        return getMetaClass().invokeMethod(this,name,args)
    }
    
    Object getProperty(String property){
        return getMetaClass().getProperty(this,property)
    }

    void setProperty(String property, Object newValue){
        getMetaClass().setProperty(this,property,newValue)
    }



}
