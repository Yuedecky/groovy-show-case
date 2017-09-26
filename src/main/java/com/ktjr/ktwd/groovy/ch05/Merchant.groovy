package com.ktjr.ktwd.groovy.ch05

import java.util.concurrent.TransferQueue

/**
 * Created by forker on 2017/9/26.
 */
class Merchant implements Trader {

    String name
    @Override
    String getName() {
        return this.name
    }

    static void main(args) {

        def bike = new Item(price: 567,name: 'big red bike')
        def paul = new Merchant(name: 'paul')
        paul.availableMoney = 2000
        paul.buy(bike)
        println paul.availableMoney
    }
}
