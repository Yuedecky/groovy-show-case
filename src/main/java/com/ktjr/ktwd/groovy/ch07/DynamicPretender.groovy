package com.ktjr.ktwd.groovy.ch07

/**
 * Created by forker on 2017/9/27.
 */
class DynamicPretender {
    Closure whatToDo = {name -> "accessed $name"}
    def propertyMissing(String name){
        whatToDo(name)
    }

    static void main(String[] args) {
        def one  = new DynamicPretender()
        assert one.hello == 'accessed hello'
        one.whatToDo = {
            name ->
                name.size()
        }
        assert one.hello == 5
    }
}
