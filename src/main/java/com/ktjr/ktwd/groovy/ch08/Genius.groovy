package com.ktjr.ktwd.groovy.ch08

import groovy.transform.ToString
import groovy.transform.builder.Builder
import jdk.nashorn.internal.ir.annotations.Immutable

/**
 * Created by forker on 2017/9/28.
 */
/**
 * Immutable types (such as String) permit no changes in state: when an instance has
 been created it can never be altered. The main advantage of immutability is that the
 object is side-effect free and thread safe.
 */
@Immutable
@Builder
@ToString(includes = ['firstName','lastName'])
class Genius {
    String firstName,lastName

    static void main(String[] args) {
        def g1 = new Genius(firstName: 'Albert',lastName: 'Einstein')

        assert g1.toString() == 'com.ktjr.ktwd.groovy.ch08.Genius(Albert, Einstein)'
        def g2 = Genius.builder().lastName('dd').firstName('Leonardo').build()
        assert g2.firstName == 'Leonardo'
        assert g1 != g2
        shouldFail(ReadOnlyPropertyException) {
            g2.lastName = 'DiCaprio'
        }
    }
}
