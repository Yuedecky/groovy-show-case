package com.ktjr.ktwd.groovy.ch01

/**
 * Created by forker on 2017/9/24.
 */
class TestList {

    static void main(args){
        test16()
    }

    static void test1(){
        def list =[1,2,3] as List
        assert list[2] ==3
        assert list.size() == 3
        List longList = (0..1000).toList()
        assert longList[333] == 333
    }

    static void test2(){
        def myList = ['a','b','c','f','g','h','k']
        assert myList[0..2] == ['a','b','c']
        assert myList[1,3] == ['b','f']//getAt()

        myList[0..2]= ['x','y','z'] //putAt()
        assert myList == ['x','y','z','f','g','h','k']

        myList[1..1] = ['9','0'] //add()
        println myList
    }

    static void test3(){
        def myList = []
        myList += 'a'
        assert myList == ['a']
        myList += ['b','c']
        assert  myList == ['a','b','c']

        myList = []
        myList << 'y' << 'z' ///左移操作
        assert myList == ['y','z']
        assert myList * 2 == ['y','z','y','z']

    }


    static void test4(){
        def myList = ['a','b','c']
        assert myList.isCase('a')
        assert 'b' in myList

        def candidate = 'c'
        switch (candidate){
            case myList: assert true;break
            default:assert false
        }

        assert ['x','a','z'].grep(myList) == ['a']
        myList = []
        if(myList)
            assert false
    }

    static void test5(){
        def expr = ''
        for (i in [1,'*',5]){
            expr += i
        }
        assert expr == '1*5'
    }

    static void test6(){
        assert [1,[2,3]].flatten() == [1,2,3]
    }

    /**
     * List的元素的类型可以是任意类型 包括其他的嵌套类型
     * 这可以用来实现列表的列表：即java中的多位数组
     * 列表也可以像栈操作一样，支持pop和push 就如同使用左移 << 操作符
     */
    static void test7(){

        def myList = [1,2,3]
        myList << 4 << 5
        assert myList == [1,2,3,4,5]

        myList >> 5
        assert myList == [1,2,3,4]
    }

    static void test8(){
        def x = [1,1,1]
        assert [1] == new HashSet(x).toList()
        assert [1] == x.unique()
    }

    static void test9(){
        def x = [1, null, 1]
        assert [1,1] == x.findAll {
            it != null
        }
        assert [1,1] == x.grep{it}
    }

    static void test10(){
        def list = [1,2,'r','x']
        def result = list.collect{it *2}
        println result
        def res = result.findAll{
            it ->
                !(it instanceof Integer)
        }
        // or write like this:
        println res.grep{!(it instanceof String)}
        println res
    }

    static void test11(){
        def lists = [1,3]
        def res = lists.every{
            it ->
                it > 0
        }
        println res
    }

    static void test12(){
        def list = [2,34,56]
        def count = list.inject(10){
            result, it ->
                result + it
        }
        println count
    }
    /**
     * 还有一个集合方法，对于字符串特别好用
     *
     */
    static void test13(){

        def list = ['xxxsdf','rervf','gtg']
        def result = list.join("---")
        println result

    }

    static void test14(){

        def list = [1,2,3]
        assert list.first() == 1
        assert list.head() == 1
        assert list.tail() == [2,3]
        assert list.last() == 3
        assert list.count(2) == 1
        assert list.max() == 3

        assert list.min() == 1

    }

    static void test15(){
        def store= ''
        def list = ['a','b','c']
        list.each {
            store += it
        }
        println store

        store = ''
        list.reverseEach {
            store += it
        }
        println store
    }



    def static quickSort(list){
        if(list.size() < 2)
            return list
        def pivot = list[list.size().intdiv(2)]
        def left = list.grep{it < pivot}
        def middle = list.grep{it ==pivot}
        def right = list.grep{it > pivot}
        return quickSort(left) + middle + quickSort(right)
    }

    /**
     * list在GDK中引入了了两种方便的方法asImmutable()和asSynchronized() 方法
     */
    static void test16(){
        def res = quickSort([1,2,45,42,57,23,18] as List)
        println( res)
    }




}
