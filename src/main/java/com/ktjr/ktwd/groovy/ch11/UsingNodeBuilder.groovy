package com.ktjr.ktwd.groovy.ch11

import groovy.xml.MarkupBuilder

/**
 * Created by forker on 2017/9/30.
 */
class UsingNodeBuilder {


    static void main(String[] args) {

        test4()

    }

    static void test1() {
        def builder = new NodeBuilder()
        def ulcDate = Date.parse('yyyy-MM-dd', '2015-01-01')
        def otherDate = Date.parse('yyyy-MM-dd', '2015-02-02')

        print builder.langs(type: 'current') {
            language("Java")
            date(ulcDate)
            language("Groovy")
            language("JavaScript")
        }
    }

    static void test2() {
        def builder = new NodeBuilder()
        def invoices = builder.invoices {
            for (day in 1..3) {
                def invDate = Date.parse('yyyy-MM-dd', "2015-01-0$day")
                invoice(date: invDate) {
                    item(count: day) {
                        product(name: 'ULC', dollar: 1499)
                    }
                }
            }
        }
        def writer = new StringWriter()
        invoices.print(new PrintWriter(writer))
        println writer.toString()
    }

    static void test3(){
        def writer = new StringWriter()
        def builder = new MarkupBuilder(writer)
        builder.invoices{
            for(day in 1..3){
                def invDate = Date.parse('yyyy-MM-dd','2016-09-01')
                invoice(date: invDate){
                    item(count: day){
                        product(name: "ULC", dollar: 12344)
                    }
                }
            }
        }
        print writer.toString()
    }

    static void test4(){
        def writer = new StringWriter()
        def builder = new MarkupBuilder(writer)
        def web = builder.'web-app'{
            builder.'display-name'('Groovy WebApp')
        }

        def result = writer.toString().replaceAll('\r','')
        println result
    }

}
