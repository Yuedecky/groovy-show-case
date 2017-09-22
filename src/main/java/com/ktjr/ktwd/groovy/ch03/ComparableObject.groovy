package com.ktjr.ktwd.groovy.ch03

/**
 * Created by forker on 2017/9/22.
 */
class ComparableObject implements Comparable<ComparableObject> {

    long id

    def previous() {
        return --this.id
    }

    def next() {
        this.id++
        return this.id
    }

    @Override
    int compareTo(final ComparableObject o) {
        return this.id > o.id ? 1 : -1
    }

    @Override
    String toString() {
        return this.id
    }

    static void main(args) {
        ComparableObject o1 = new ComparableObject()
        o1.id = 10

        ComparableObject o2 = new ComparableObject()
        o2.id = 20
        def range = o1..o2
        range.each { it ->
            println "${it}"
        }
    }
}
