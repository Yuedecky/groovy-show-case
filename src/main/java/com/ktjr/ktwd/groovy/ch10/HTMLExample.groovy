package com.ktjr.ktwd.groovy.ch10

import groovy.transform.TypeChecked
import groovy.xml.MarkupBuilder

/**
 * Created by forker
 * on 2017/9/29.
 */
class HTMLExample {
    private static String buildPage(String pageTitle){
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)
        xml.html{

            head{ title pageTitle}
        }
        writer
    }

    @TypeChecked
    static String page404(){
        buildPage( '404- Not Found')
    }

    static void main(String[] args) {
        print HTMLExample.page404()
    }

    /**
     * While being an easy solution, this technique has drawbacks:
     * 1.You have to annotate each method that you want to be type checked with  @TypeChecked
     * 2.Static initializers blocks, instance initializer blocks, and fields cannot be annotated, so they’ll never be type checked
     */
}
