package com.ktjr.ktwd.groovy.ch08

/**
 * Created by forker on 2017/9/28.
 */
class Resource {

    private static alive =0
    private static used = 0
    Resource(){
        alive++
    }
    def use(){
        used++
    }
    static stats(){
        "$alive alive, $used used"
    }

}
