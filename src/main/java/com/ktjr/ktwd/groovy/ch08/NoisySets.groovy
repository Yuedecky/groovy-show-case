package com.ktjr.ktwd.groovy.ch08

/**
 * Created by forker on 2017/9/28.
 */
abstract class NoisySets implements Set {

    private Set delegate = new HashSet()
    @Override
    boolean add(item) {
        println "adding $item"
        delegate.add(item)
    }

    @Override
    boolean addAll(final Collection items) {
        items.each { println "adding $it" }
        delegate.addAll(items)
    }


    @Override
    boolean isEmpty() {
        return delegate.isEmpty()
    }

    @Override
    boolean contains(Object o) {
        return delegate.contains(o)
    }

    @Override
    Object[] toArray() {
        return delegate.toArray()
    }

    @Override
    int size() {
        return delegate.size()
    }


}
