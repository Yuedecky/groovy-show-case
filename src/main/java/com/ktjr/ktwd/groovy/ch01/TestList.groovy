package com.ktjr.ktwd.groovy.ch01

/**
 * Created by forker on 2017/9/24.
 */
class TestList {

    static void main(args){
        test6()
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
}
