package com.ktjr.ktwd.groovy.ch08

import groovy.transform.EqualsAndHashCode

/**
 * Created by forker on 2017/9/28.
 */
@EqualsAndHashCode
class Actor {
    String firstName,lastName

    static void main(String[] args) {

        def magneto = new Actor(firstName: 'Ian',lastName: 'McKellen')
        def gandalf = new Actor(firstName: 'Ian',lastName: 'McKellen')

        assert magneto == gandalf
    }
}
