package com.ktjr.ktwd.groovy.ch07

/**
 * Created by forker on 2017/9/27.
 */
class PropPretender {
    def propertyMissing(String name){
        "access $name"
//        int result = 0
//        name.each {
//            result <<= 1
//            if(it == 'I')
//                result ++
//        }
    }

    /**
     * 属性钩子
     * @param args
     */
    static void main(String[] args) {

        def bounce = new PropPretender()
        assert bounce.hello == 'access hello'
    }
}
