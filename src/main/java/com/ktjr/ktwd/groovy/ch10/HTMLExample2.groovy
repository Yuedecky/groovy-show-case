package com.ktjr.ktwd.groovy.ch10

import groovy.transform.TypeChecked
import groovy.transform.TypeCheckingMode
import groovy.xml.MarkupBuilder

import javax.swing.text.html.HTML

/**
 * Created by forker on 2017/9/29.
 */
class HTMLExample2 {

    @TypeChecked(TypeCheckingMode.SKIP)
    private static String buildPage(String pageTitle){
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)

        xml.html{
            head{title pageTitle}
        }
        writer
    }

    static String page404(){
        buildPage '404-Not Found'
    }

    static void main(String[] args) {
        println HTMLExample2.page404()
    }

    /**
     * If you like the benefits of type checking and only use dynamic features in
     * quite specific places, then we’d recommend using TypeCheckingMode.SKIP
     * because it more clearly clarifies the exact portions of the code that are “dynamic.”
     */

}

