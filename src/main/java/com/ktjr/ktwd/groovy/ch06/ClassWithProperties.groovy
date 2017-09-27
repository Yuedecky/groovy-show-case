package com.ktjr.ktwd.groovy.ch06

/**
 * Created by forker on 2017/9/27.
 */
class ClassWithProperties {

    def someProperty
    public someField
    private somePrivateField


    static void main(String[] args) {
        def obj = new ClassWithProperties()
        def store = []
        obj.properties.each {
            store +=  it.key
            store += it.value
        }
        assert store.contains('someProperty')
        assert store.contains('class')
        assert !store.contains('someField')
        assert !store.contains('somePrivateField')
        println store
        assert store.properties.size() == 2
    }
}
