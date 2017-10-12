package com.ktjr.ktwd.groovy.ch14

import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory

import javax.xml.xpath.XPathFactory

import static javax.xml.xpath.XPathConstants.NODESET
import static javax.xml.xpath.XPathConstants.NUMBER

/**
 * Created by yzy
 * on 2017/10/12.
 */
class UseXPath {


    static void main(String[] args) {

        evaluate()
    }


    static def evaluate(){
        def doc = DOMBuilder.parse(new FileReader(System.properties.'user.dir'+'/src/main/java/com/ktjr/ktwd/groovy/ch14/plan.xml'))

        def plan = doc.documentElement

        def xpath = XPathFactory.newInstance().newXPath()

        def out = new StringBuilder()
        use(DOMCategory){
            xpath.evaluate('//week',plan,NODESET).eachWithIndex{  entry,  i ->

                out << "\nWeek No. $i\n"
                int total = xpath.evaluate('sum(task/@total)',entry,NUMBER)
                int done = xpath.evaluate('sum(task/@done)',entry,NUMBER)
                out << "planed $total of ${entry.'@capacity'}\n"
                out << "done $done of $total"
            }
            print out
        }
    }


}
