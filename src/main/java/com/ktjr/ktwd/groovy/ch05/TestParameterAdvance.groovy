package com.ktjr.ktwd.groovy.ch05

/**
 * Created by forker on 2017/9/26.
 */
class TestParameterAdvance {

    def someMethod(def args){
        println args
    }
    static void main(args) {

        test4()



    }
    static def sumWithDefaults(a,b, c=0){
        return a + b + c
    }
    static def sumWithList(List args){
        return args.inject(0){
            sum,i ->
                sum += i
        }
    }
    def static sumWithOptionals(a,b,Object[] optional){
        return a + b + sumWithList(optional.toList())
    }

    def static sumNamed(Map args){
        ['a','b','c'].each {
            args.get(it,0)
        }
        return args.a + args.b + args.c
    }


    static void test3(){

        assert 2 == sumWithDefaults(1,1)
        assert 3 == sumWithDefaults(1,1,1)
        assert 2 == sumWithList([1,1])
        assert 3 == sumWithList([1,1,1])
        assert 2 == sumWithOptionals(1,1)
        assert 3 == sumWithOptionals(
                1,1,1
        )
        assert 2 == sumNamed(a:1,b:1)
        assert 3 == sumNamed(a:1,b:1,c:1)
    }

    /**
     * 这个就相当厉害
     */
    static void test4(){
        def advance = new TestParameterAdvance()
        def args = new Object()
        def methodName = 'someMethod'
        advance."${methodName}"(args)
    }

    /**
     * When calling a method or accessing a field on a null reference,
     * a NullPointerException (NPE) is  thrown
     */
    /**
     * 下面的例子 就说明了如何让避免NPE
     */
    static void test5(){
        def map = [a: [b:[c:1]]]
        assert map.a.b.c == 1
        if(map && map.a && map.a.x){
            assert map.a.x.c == null
        }
        try{
            assert map.a.x.c == null
        }catch (NullPointerException e){

        }
        assert map?.a?.x?.x == null
    }

}
