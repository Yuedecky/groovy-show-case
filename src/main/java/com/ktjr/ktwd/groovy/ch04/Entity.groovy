package com.ktjr.ktwd.groovy.ch04

/**
 * Created by forker on 2017/9/26.
 */
trait Entity implements Persistent ,HasId,HasVersion{
    boolean save(){
        version ++
        super.save()
    }

}