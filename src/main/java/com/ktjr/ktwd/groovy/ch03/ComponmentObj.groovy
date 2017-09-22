package com.ktjr.ktwd.groovy.ch03

import org.junit.Test

import java.util.function.Consumer

/**
 * Created by forker on 2017/9/22.
 */
class ComponmentObj implements Iterable<ComponmentObj>{

    def components = [
            new Component(id: 1, name: 'Foo'),
            new Component(id: 2, name: 'Bar')]

    @Override
    Iterator<Component> iterator() {
        components.iterator()
    }
    //groovy

    @Override
    void forEach(Consumer<Component> action) {
        Component component = new ComponmentObj(id:3,name:'fooBar')
        action.accept(component)
    }

    @Test
    void test(){
        def composite = new ComponmentObj()
        assert composite*.id == [1,2]
        assert composite*.name == ['Foo','Bar','fooBar']
    }
}
