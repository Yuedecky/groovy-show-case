package com.ktjr.ktwd.groovy.ch01

/**
 * Created by forker on 2017/9/25.
 */
class UseMaps {


    static void main(args){

        test9()
    }
    static void test1(){
        def myMap = [a:1,b:2,c:3]
        assert myMap instanceof LinkedHashMap
        assert myMap.size() == 3
        assert myMap['a'] == 1

        def emptyMap = [:]
        assert emptyMap.size() == 0

        def explicitMap = new TreeMap()
        explicitMap.putAll(myMap)
        assert explicitMap['a'] == 1

        def composed = [x: 'y',*:myMap]
        assert composed == [x: 'y',a:1,b:2,c:3]
    }

    static void test2(){

        def x ='a'
        assert ['x':1] == [x:1]
        assert ['a': 1] == [(x):1]
    }

    static void test3(){
        def myMap =[a:1,b:2,c:3]
        assert myMap['a'] == 1
        assert myMap.a == 1
        assert myMap.get('a') == 1
        assert myMap.get('a',0) ==1
        assert myMap['d'] == null
        myMap['d'] = 4
        assert myMap.d == 4

        //当然 key也支持.符号
        myMap =['a.b':6]
        assert myMap.'a.b' == 6
        myMap.a.b == 6 //等于 myMap.getA().getB()
        //myMap.a.b 会报错

    }

    static void test4(){
        def myMap = [a:1,b:2,c:4]
        def other = [b:2,c:4,a:1]
        assert myMap == other
        assert !myMap.isEmpty()
        assert myMap.size() == 3
        assert myMap.containsKey('a')
        assert myMap.containsValue(1)
        assert myMap.any {
            it.value > 2
        }
        assert myMap.every {
            it.key < 'd'
        }

        assert myMap.keySet() == ['a','b','c'] as Set
        assert myMap.values().toList() == [1,2,4]
    }

    static void test5(){
        def myMap = [a: 1,b:2,c:3]
        def store = ''
        myMap.each{
            store += it.key
            store += it.value
        }
        assert store == 'a1b2c3'
    }

    static void test6(){
        def myMap = [a:1,b:2,c:3]
        myMap.clear()
        assert myMap.isEmpty()

        myMap = [x:4,y:5,z:6]
        myMap.remove('x')
        assert myMap.size() == 2

        assert [a:1] + [b:2] == [a:1,b:2]
        def abmap = myMap.subMap(['y'])
        assert abmap.size() == 1

        def doubled = [a:1,b:2,c:3].collect {
            it.value *2
        }
        assert doubled instanceof List

        assert doubled.every{
            it %2 == 0
        }

        def addTo =[]
        myMap.collect(addTo){
            it.value *= 2
        }
        assert addTo.every{
            it %2 == 0
        }
    }

    /**
     * 字符串检索并生成map
     */
    static void test7(){
        def textCorpus =
                """
                    Look for the bare necessities
                    The simple bare necessities
                    Forget about your worries and your strife
                    I mean the bare necessities
                    Old Mother Nature's recipes
                    That bring the bare necessities of life
                """

        def words = textCorpus.tokenize()

        def wordFrency = [:]
        words.each { word ->
            wordFrency[word] = wordFrency.get(word,0) + 1
        }
        def wordList = wordFrency.keySet().toList()

        wordList.sort{wordFrency[it]}
        def statistic = '\n'
        wordList[-1..-5].each {
            statistic += it.padLeft(12) + ":"
            statistic += wordFrency[it] + '\n'
        }
        println statistic
        println wordList
    }

    /**
     * map reduce demo
     */
    static void test8(){
        def people = [peter: 40, paul: 30, mary: 20]
        assert people.findAll {
            _, age ->
                age < 35
        }.collect{
            name , _->
                name.toUpperCase()
        }
        .sort()
        .join(",") == "MARY,PAUL"
    }

    static void test9(){
        def list = [1,2,3,4]
        list.each {
            list.remove(0)
        }
    }

}
