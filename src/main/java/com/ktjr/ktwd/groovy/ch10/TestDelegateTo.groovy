package com.ktjr.ktwd.groovy.ch10

import groovy.transform.TypeChecked

/**
 * Created by forker
 * on 2017/9/29.
 */
class TestDelegateTo {

    static def validate(@DelegatesTo.Target def o, @DelegatesTo Closure rule){
        rule.delegate = o
        rule.call()
    }

    @TypeChecked
    static void validateAll(){

        def a = new Address (country: 'Austria')
        validate(a){
            if(country[0] == 'X')
                println "No countries start with that"
        }
        def w1 = new WishList(items: ['iphones','iphones'])
        validate(w1){
            if(items != items.toUnique()){
                println "Item appeared twice"
            }
        }
    }

    static void main(String[] args) {

        validateAll()
    }

    /**
     * @DelegateTo的参数：
     * 1.type(optional)    :
     */
}
