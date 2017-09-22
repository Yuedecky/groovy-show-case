package com.ktjr.ktwd.groovy.ch03

import org.junit.Test

/**
 * Created by forker on 2017/9/22.
 */
class Range {
    @Test
    void test(){
        def range = 0..5
        assert (0..5).collect() == [0, 1, 2, 3, 4, 5]
        assert (0..<5).collect() == [0, 1, 2, 3, 4]
        assert (0..5) instanceof List //groovy.lang.Range实现了List接口
        assert (0..5).size() == 6
    }
}
