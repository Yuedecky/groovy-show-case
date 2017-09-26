package com.ktjr.ktwd.groovy.ch01

/**
 * Created by forker on 2017/9/22.
 */
class Book {
    private def name
    private def author

    Book(name, author) {
        this.name = name
        this.author = author
    }

    /**
     * 三种实例化方式吧
     * @param args
     */
    static void main(def args) {
        def first = new Book("canoo","jeter")

        def second = ['canoo','jeter'] as Book

        Book third = ['canoo','jeter']
    }
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
