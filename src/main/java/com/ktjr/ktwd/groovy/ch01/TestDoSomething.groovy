package com.ktjr.ktwd.groovy.ch01

/**
 * Created by forker on 2017/9/22.
 */
class TestDoSomething {

    /**
     *
     * @param args
     */
    static def main(args){
        def mySong  = new Song(length: 90, name: "Buring down the house")
        def myBook = new Book(name: "one Duck stuck",author: "Phyllis Root")
        def result = doSomething(myBook)
        assert result == "java.lang.void"
        doSomething(mySong)
    }

    static def doSomething(def thing){

        println "going to do something with a thing named :${thing.name}"
    }
}
