package com.ktjr.ktwd.groovy.ch12

/**
 * Created by yzy
 * on 2017/10/9.
 */
class IdentityDemo {

    static void main(String[] args) {


    }

    static def test1(){
        new Date().identity {
            println "$date.$month.$year"
        }
    }

    static def test2(){
        def address = new Address()
        address.with {
            streetName = 'Mainstreet'
            houseNumber = '42'
        }
    }


}
