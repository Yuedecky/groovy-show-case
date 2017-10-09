package com.ktjr.ktwd.groovy.ch12

/**
 * Created by forker on 2017/10/9.
 */
class TestProperties {

    static void main(String[] args) {


        def prop = new PropertyObj()

        /**
         * Using the hasProperty  and respondsTo  methods you can
         * check if the object has the specified property or method, respectively.
         */
        assert prop.hasProperty('first')
        assert prop.respondsTo('myMethod')


        def keys = ['first','second','class','name','age']
        assert prop.properties.keySet() == new HashSet(keys)


        assert 1 == prop.properties['first']
        assert 1 == prop.properties['first']
        assert 1 == prop.first
        assert 1 == prop['first']

        def one = 'first'
        def two = 'second'
        prop[one] = prop[two]

        assert prop.dump() =~ 'first=2'
    }
}
