package com.ktjr.ktwd.groovy.ch08

import groovy.transform.AutoClone

/**
 * Created by forker on 2017/9/28.
 */
/**
 * 有四种@AutoClone方式
 * 1. CLONE: Adds a clone() method to your class. The clone() method will call
 super.clone() before calling clone() on each Cloneable property
 of the class. Doesn’t provide deep cloning. Not suitable if you have final
 properties. This is the default cloning style if no style attribute is provided.
 *
 * 2.SIMPLE: Adds a clone() method to your class that calls the no-arg constructor
 then copies each property calling clone() for each Cloneable property.
 Handles inheritance hierarchies. Not suitable if you have final properties.
 Doesn’t provide deep cloning.

 3.COPY_CONSTRUCTOR: Adds a copy constructor, which takes your class as its parameter, and a
 clone() method to your class. The copy constructor method copies each
 property calling clone() for each Cloneable property. The clone()
 method creates a new instance making use of the copy constructor. Suitable
 if you have final properties. Handles inheritance hierarchies. Doesn’t provide
 deep cloning.
 * 4.SERIALIZATION: Adds a clone() method to your class that uses serialization to copy your
 class. Suitable if your class already implements the Serializable or
 Externalizable interface. Automatically performs deep cloning. Not as
 time or memory efficient. Not suitable if you have final properties.
 *
 */
@AutoClone
class Chef1 {

    String name
    List<String> recipes
    Date born

    static void main(String[] args) {
        def name = 'Heston Blumenthal'
        def recipes = ['Snail porridge', 'Bacon & egg ice cream']
        def born = Date.parse('yyyy-MM-dd', '1966-05-27')
        def c1 = new Chef1(name: name,recipes: recipes,born: born)
        def c2 =c1.clone()
        assert c2.recipes ==recipes
    }
}
