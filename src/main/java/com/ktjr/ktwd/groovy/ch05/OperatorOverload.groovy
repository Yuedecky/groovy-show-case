package com.ktjr.ktwd.groovy.ch05

import org.junit.Test

/**
 * Created by forker on 2017/9/22.
 */
class OperatorOverload {
    int size

    static def main(args){
        OperatorOverload operator = new OperatorOverload(12)
        println(operator + operator)
    }
    OperatorOverload(int size){
        this.size = size
    }


    def plus(OperatorOverload other) {
        return new OperatorOverload(this.size * other.size)
    }

    @Override
    String toString() {
        return this.size
    }
}
