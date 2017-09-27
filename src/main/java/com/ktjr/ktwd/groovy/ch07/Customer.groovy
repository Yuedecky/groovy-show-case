package com.ktjr.ktwd.groovy.ch07

/**
 * Created by forker on 2017/9/27.
 */
class Customer {


    def mopInvoke(Object obj,String method,Object args){
        if(obj instanceof GroovyObject){
            return groovyObjectInvoke(obj,method,args)
        }
        registry.getMetaClass(obj.class).invokeMethod(obj,method,args)
    }
}
