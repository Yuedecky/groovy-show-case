package com.ktjr.ktwd.groovy.ch01

import groovy.transform.TypeChecked

/**
 * Created by forker on 2017/9/28.
 */
@TypeChecked
class Person {
    String name
    String getFullName(){
        name.toLowerCase()
    }

}
