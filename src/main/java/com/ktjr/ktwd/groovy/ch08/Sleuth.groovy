package com.ktjr.ktwd.groovy.ch08

import groovy.transform.ToString

/**
 * Created by forker on 2017/9/28.
 */
@ToString(includeNames = true,ignoreNulls = true)
class Sleuth {
    String firstname,lastname

    static void main(String[] args) {
        def nancy = new Sleuth(firstname: 'Nancy',lastname: 'Drew')
        assert nancy.toString() == 'com.ktjr.ktwd.groovy.ch08.Sleuth(firstname:Nancy, lastname:Drew)'
    }
}
