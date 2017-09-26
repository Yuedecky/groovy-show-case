package com.ktjr.ktwd.groovy.ch05

/**
 * Created by forker on 2017/9/26.
 */
trait Trader {

    /**
     * 就像Groovy类，trait也支持属性
     */
    int availableMoney = 0

    /**
     * 无法在Trader以外访问tradesDone私有变量
     */
    private int tradesDone = 0

    def buy(Item item){
        if(item.getPrice() <= availableMoney){
            availableMoney -= item.price
            tradesDone += 1
            println "${getName()} bought ${item.name}"
        }
    }

    def sell(Item item) {
    }

    abstract String getName()
}
