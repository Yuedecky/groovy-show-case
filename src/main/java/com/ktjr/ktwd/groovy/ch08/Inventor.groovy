package com.ktjr.ktwd.groovy.ch08

import groovy.transform.Canonical

/**
 * Created by forker
 * on 2017/9/28.
 */
/**
 * The @Canonical annotation takes optional parameters to include or exclude properties
 from the constructor and method implementations that it creates
 */
@Canonical
class Inventor {
    String firstname,lastname

    static void main(String[] args) {

        def i1 = new Inventor('Thomas',"Edison")
        def i2 = new Inventor("Thomas")
        assert i1 != i2
        assert i1.firstname == i2.firstname
        assert i1.toString() == 'com.ktjr.ktwd.groovy.ch08.Inventor(Thomas, Edison)'
    }
}

