package com.ktjr.ktwd.groovy.ch10

/**
 * Created by forker
 * on 2017/9/29.
 */
@Category(Integer)
class TimeCategory {

    static Date getAm(Integer self){
        def d = Calendar.instance
        d.set(Calendar.MINUTE,0)
        d.set(Calendar.SECOND,0)
        d.set(Calendar.HOUR_OF_DAY,self)
        d.time
    }


}
