package com.ktjr.ktwd.groovy.ch07

/**
 * Created by forker on 2017/9/27.
 */
class MySubGroovy extends MySuperGroovy{

    def addSuperMethod(){
        MySuperGroovy.metaClass.added = {
            ->
            true
        }
    }

    static void main(def args) {
        Map.metaClass.toTable = {->
            return delegate.collect {
                [it.key,it.value]
            }
        }

        assert [a:1,b:2].toTable() == [
                ['a',1],
                ['b',2]
        ]

        String.metaClass{
            rightShiftUnsigned = {
                prefix ->
                    delegate.replaceAll(~/\w+/){
                        prefix + it
                    }
            }
            methodMissing = {
                String name, obj->
                    delegate.replaceAll name, obj[0]
            }

            def people = "Dierk,Guillaume,Paul,Hamlet,Jon"
            people >>>= "\n"
        }
    }






}
