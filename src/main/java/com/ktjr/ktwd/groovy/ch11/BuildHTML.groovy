package com.ktjr.ktwd.groovy.ch11

import groovy.xml.MarkupBuilder
import groovy.xml.StreamingMarkupBuilder

/**
 * Created by forker on 2017/9/30.
 */
class BuildHTML {

    static void main(String[] args) {
        test1()
        testWithStreamingMarkupBuilder()

    }


    static void test1(){
        def writer = new FileWriter('markup.html')

        def html = new MarkupBuilder(writer)

        html.html{
            head{
                title 'Constructed by MarkupBuilder'
            }
            body{
                h1 'What Can I do with MarkupBuilder?0'
                form(action: 'Whatever'){
                    for(line in  ['Produce HTML','Produce XML','Have some fun']){
                        input(type: 'checkbox',checked: false)
                        label(for: line ,line)
                        br()
                    }

                }
            }
        }
    }

    static void testWithStreamingMarkupBuilder(){

        def builder = new StreamingMarkupBuilder()
        def writable = builder.bind{
            invoices {
                for(day in 1..3){
                    def invDate = Date.parse('yyyy-MM-dd',"2015-01-2$day")
                    invoices(date: invDate){
                        item(count: day){
                            product(name: "ULC",dlollar:344,desc: 'simple')
                        }
                    }
                }
            }
        }
        def result = writable.toString()
        println result
        assert result.startsWith("<invoices><invoice date='Thu Jan 01")
        assert result.endsWith("</invoice></invoices>")
    }
}
