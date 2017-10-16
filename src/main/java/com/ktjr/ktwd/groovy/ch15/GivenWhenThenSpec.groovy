package com.ktjr.ktwd.groovy.ch15

import spock.lang.Specification

/**
 * Created by yzy
 * on 2017/10/13.
 */
class GivenWhenThenSpec extends Specification {

    def 'test adding a new item to a set'(){
        given:
        def items = [3,45,6,78] as Set
        when:
        items << 1
        then:
        items.size() == 5
    }

}
