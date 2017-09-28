package com.ktjr.ktwd.groovy.ch01

import groovy.transform.TypeChecked

/**
 * Created by forker on 2017/9/28.
 */
class Actor {
    String firstname,lastname

    @TypeChecked
    String getFullName(){
        "$firstname $lastname"
    }

    void makePeace(){
        new AntBuilder().echo("Peace was never an option")
    }
    static void main(String[] args) {
        def magneto = new Actor(firstname: 'Ian',lastname: 'McKellen')
        assert magneto.fullName == 'Ian McKellen'

        magneto.makePeace()
    }
}
