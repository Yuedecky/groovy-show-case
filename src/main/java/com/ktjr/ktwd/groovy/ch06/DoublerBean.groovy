package com.ktjr.ktwd.groovy.ch06

/**
 * Created by forker on 2017/9/27.
 */
class DoublerBean {

    public value
    void setValue(value){
        this.value =value
    }
    def getValue(){
        value *2
    }

    static void main(args){
        def bean = new DoublerBean(value: 100)
        /**
         * call getValue
         */
        assert bean.value == 200
        assert 100 ==bean.@value
    }
}
