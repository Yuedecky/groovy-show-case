package com.ktjr.ktwd.groovy.ch06

import org.junit.Test

/**
 * Created by forker on 2017/9/22.
 */
class StringIter {
    @Test
    void testStringIter(){
        def s = 'KaiTong JinRong Tech'
        s.each {
            print it
        }
        println()
        s.eachWithIndex {
            it , idx ->
                print("${it}:${idx}\t")
        }
    }

}
