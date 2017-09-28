package com.ktjr.ktwd.groovy.ch08

import groovy.transform.ToString

/**
 * Created by forker
 * on 2017/9/28.
 */
@ToString
class Detective {

    String firstName,lastName

    static void main(String[] args) {
        def sherlock = new Detective(firstName: "sherlock",lastName: "Holmes")
        assert sherlock.toString() == "com.ktjr.ktwd.groovy.ch08.Detective(sherlock, Holmes)"
    }
}
