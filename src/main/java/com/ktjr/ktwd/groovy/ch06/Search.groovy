package com.ktjr.ktwd.groovy.ch06

import org.junit.Test

import java.util.regex.Matcher

/**
 * Created by forker on 2017/9/22.
 */
class Search {

    @Test
    void test(){
        def text = "some text to match"
        def m = text =~ /yyee/
        assert m instanceof Matcher
        if (!m) {
            throw new RuntimeException("Oops, text not found!")
        }
    }
}
