package com.ktjr.ktwd.groovy.ch09

import groovy.transform.TypeChecked

/**
 * Created by forker on 2017/9/29.
 */
class TestTypeChecking {

    /**
     * Activating type checking gives you the advantage of
     * catching the problem earlier, during compilation
     */
    @TypeChecked
    static void  printAuthors(){
        def authors = ['Dierk','Guillaume']
        printToUpperCase(authors)
    }
    static void printToUpperCase(List<String> authors){
        authors.each{
            println it.toUpperCase()
        }
    }

    static void main(String[] args) {

        printAuthors()
    }
}
