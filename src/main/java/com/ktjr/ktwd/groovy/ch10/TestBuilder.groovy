package com.ktjr.ktwd.groovy.ch10

import groovy.transform.TypeChecked
import groovy.xml.MarkupBuilder

/**
 * Created by forker on 2017/9/29.
 */
class TestBuilder {

    /**
     * the MarkupBuilder class doesn’t define any html, head, or
     title methods
     * so if you tried to apply @TypeChecked on this example, the compiler
     would report them as compilation errors
     * @param args
     */
//    @TypeChecked
    static void main(String[] args) {
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)
        xml.html{
            head{
                title("An XHTML Page")
            }
        }
        println writer
    }
}
