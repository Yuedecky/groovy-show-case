package com.ktjr.ktwd.groovy.ch04

import groovy.test.GroovyAssert

/**
 * Created by forker on 2017/9/26.
 */
class ClassWithTypedAndUntypedFieldsAndProperties {

    static void main(args) {
        final String PI = '3.13'
        assert PI.class.name == 'java.lang.String'
        assert PI.size() == 4
        GroovyAssert.shouldFail (ClassCastException){
            Float areaOfCircleRadius = PI
        }


    }

    public fieldWithModifier
    String typedField
    def untypedField
    protected field1, field2,field3
    private assignedField = new Date()
    static classField
    public static final String CONSTA = 'a', CONSTB = 'b'

    def somemeyhod(){
        def localUntypedMethodVar = 1
        int localTypedMethodVar = 1
        def localVarWithoutAssignment, andAnotherOne
    }

    static class Counter{
        def count = 0

        Object get(String name){

        }
        void set(String name,Object value){

        }
    }

    static void test2(){
        def counter = new Counter()
        counter.count = 1
        assert counter.count ==1

        def fieldName = 'count'
        counter[fieldName] = 2
        assert counter['count'] == 2
    }
}
