package com.ktjr.ktwd.groovy.ch07

/**
 * Created by forker on 2017/9/27.
 */
class NoParens {
    def getProperty(String propertyName){
        if(metaClass.hasProperty(this,propertyName)){
            return metaClass.getProperty(this,propertyName)
        }
        metaClass.setProperty(this,'a',12)
        invokeMethod propertyName,null
    }
}
