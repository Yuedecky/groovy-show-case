package com.ktjr.ktwd.groovy.ch08

/**
 * Created by forker on 2017/9/28.
 */
class RealNoisySet {
    @Delegate
    Set delegate = new HashSet()

    @Override
    boolean add(item){
        println "adding $item"
        delegate.add(item)
    }

    @Override
    boolean addAll(Collection items){
        items.each {
            println "adding $it"
            delegate.addAll(items)
        }
    }

    static void main(String[] args) {
        Set ns = new NoisySet()
        ns.add(1)
        ns.addAll([2,3])
        assert ns.size() == 3
    }
}
