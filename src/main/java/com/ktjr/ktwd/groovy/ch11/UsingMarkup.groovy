package com.ktjr.ktwd.groovy.ch11

import groovy.xml.MarkupBuilder

/**
 * Created by forker
 * on 2017/9/30.
 */
class UsingMarkup {

    static void main(String[] args) {
        def builder = new MarkupBuilder()

        builder.numbers {
            description 'Squares and factors of 10..15'

            for( i in 10..15){
                number(value: i, square: i * i){
                    for(j in 2..<i){
                        if(i % j ==0){
                            factor(value: j) //Emit each factor element
                        }
                    }
                }
            }

        }
    }
}
