package com.ktjr.ktwd.groovy.ch09

import groovy.time.TimeCategory

/**
 * Created by forker on 2017/9/29.
 */
class VacationHelper {

    static duration(){
        use(TimeCategory){
            doComplete()
        }
    }
    static doComplete(){
        1.week - 1.day
    }

    /**
     * This code is totally valid even if the doCompute method itself doesn’t explicitly use TimeCategory,
     * because it’s called from the duration method that has “opened” the category
     * @param ars
     */
    static void main(ars){
        duration()
    }
}
