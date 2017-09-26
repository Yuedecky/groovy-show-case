package com.ktjr.ktwd.groovy.ch04

/**
 * Created by forker on 2017/9/26.
 */
class TestTrait {
    static void main(args){
        Entity gina = new Book(id: 1,version: 1,title: "gina",isbn: "11111")
        gina.save()
        assert gina.version == 2
    }
}
