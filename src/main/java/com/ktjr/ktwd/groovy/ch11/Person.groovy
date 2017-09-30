package com.ktjr.ktwd.groovy.ch11

import groovy.beans.Bindable
import groovy.beans.Vetoable

/**
 * Created by forker
 * on 2017/9/30.
 */
class Person {
    @Bindable String name
    @Vetoable int age
}
