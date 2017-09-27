package com.ktjr.ktwd.groovy.ch06

/**
 * Created by forker on 2017/9/27.
 */
class MrBean {

    String firstname, lastname
    String getName(){
        return "$firstname $lastname"
    }

    static void main(args){
        def bean = new MrBean(firstname: "Rowan")
        bean.lastname = 'Atkinson'
        assert 'Rowan Atkinson' == bean.name
    }
}
