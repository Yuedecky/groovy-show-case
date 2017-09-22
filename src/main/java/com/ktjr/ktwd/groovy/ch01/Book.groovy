package com.ktjr.ktwd.groovy.ch01

/**
 * Created by forker on 2017/9/22.
 */
class Book {
    private def name
    private def author

    @Override
    String toString() {
        return "{Book:name=${this.name},author=${this.author}}"
    }


    def readers(def users){
        users.forEach{
            it ->
                println it.name
        }
    }

    def noArgsMethod(){
        println "${this.name}:${this.author}"
    }
}
