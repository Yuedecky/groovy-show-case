package com.ktjr.ktwd.groovy.ch08

import groovy.transform.Sortable

/**
 * Created by forker on 2017/9/28.
 */
@Sortable(includes = 'last,initial')
class Politician {
    String first
    Character initial
    String last

    String initials(){
        first[0] + initial + last[0]
    }


    static void main(String[] args) {

        def politicians = [
                new Politician(first: 'Margaret', initial: 'H', last: 'Thatcher'),
                new Politician(first: 'George', initial: 'W', last: 'Bush')
        ]
        def sorted = politicians.toSorted()
        assert sorted*.initials() == ['GWB', 'MHT']

        def byInitial = Politician.comparatorByInitial()
        sorted = politicians.toSorted(byInitial)
        assert sorted*.initials() == ['MHT', 'GWB']
    }
}
