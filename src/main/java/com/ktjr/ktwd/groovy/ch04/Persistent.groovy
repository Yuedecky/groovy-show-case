package com.ktjr.ktwd.groovy.ch04

/**
 * Created by forker on 2017/9/26.
 */
trait Persistent {

    boolean save(){
        println "saving ${this.dump()}"
    }
}