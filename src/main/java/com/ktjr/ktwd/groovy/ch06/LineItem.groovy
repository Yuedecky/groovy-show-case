package com.ktjr.ktwd.groovy.ch06

/**
 * Created by forker on 2017/9/27.
 */
class LineItem {
    Product product
    int count
    int total(){
        return product.dollar * count
    }
}
