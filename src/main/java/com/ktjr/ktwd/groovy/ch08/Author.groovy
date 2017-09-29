package com.ktjr.ktwd.groovy.ch08

import groovy.transform.TupleConstructor
import groovy.transform.TypeChecked

/**
 * Created by forker
 * on 2017/9/29.
 */

@TupleConstructor
class Author {

    String first
    String last
    int born
    @TypeChecked
    static Author createAuthor(List params){
        if(params.size() != 3){
            throw new IllegalArgumentException('Incorrect number of arguments')
        }
        String first = params[0]
        String last = params[1]
        Integer age = (Integer)params[2]

        Author a = [first,last,age]
        a
    }

    /**
     * Please note that compile-time type safety isn’t fully guaranteed here,
     * because we have to check that the list contains at least three elements and that can only be done at runtime
     * @param args
     */
    static void main(String[] args) {
        assert createAuthor(['Agatha','Christie',1890]).born == 1890


    }
}
