package com.ktjr.ktwd.groovy.ch08
import static groovy.test.GroovyAssert.shouldFail
/**
 * Created by forker
 * on 2017/9/28.
 */
@Singleton class Zenus {

    static void main(String[] args) {
        assert Zenus.instance
        def ex = shouldFail(RuntimeException){
            new Zenus()
        }
        assert ex.message =="Can't instantiate singleton com.ktjr.ktwd.groovy.ch08.Zenus. Use com.ktjr.ktwd.groovy.ch08.Zenus.instance"

    }
}
