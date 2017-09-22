package com.ktjr.ktwd.groovy.ch06

import org.junit.Test

import java.util.regex.Pattern

/**
 * Created by forker on 2017/9/22.
 */
class Regex {
    @Test
    void test(){
        def p = ~/foo/
        assert p instanceof Pattern
    }

    @Test
    void test2(){
        def p
        def pattern = 'hello'
        p =~ 'foo'  //使用单引号字符串
        p =~"foo"   //使用双引号字符串
        p =~ $/dollar/slashy $ string/$ //使用美元-正斜杠字符串
        p = ~"${pattern}" //可以使用GString

        assert p.matcher('hello').find(0) == true

    }

}
