package com.ktjr.ktwd.groovy.ch04


/**
 * Created by forker on 2017/9/22.
 */
class User {

    String name
    int age
    int id



    String getName() { "Name: $name" }


    void putAt(int i, def value) {
        switch (i) {
            case 0: id = value; return
            case 1: name = value; return
        }
        throw new IllegalArgumentException("No such element $i")
    }

    def getAt(int i) {
        switch (i) {
            case 0: return id
            case 1: return name
        }
        throw new IllegalArgumentException("No such element $i")
    }

    User(Map map) {
        this.name = map.name
        this.age = map.age ?: 20
        this.id = map.id ?: 20
    }

    def asType(Class target) {
        if (target == Identifiable) {
            return new Identifiable(name: name)
        }
        throw new ClassCastException("User cannot be coerced into $target")
    }

}
