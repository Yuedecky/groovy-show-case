package com.ktjr.ktwd.groovy.ch06

/**
 * Created by forker on 2017/9/22.
 */
class XmlIter {
    static void main(de){
        readXml(System.properties."user.dir"+"/src/main/resources/xml/demo.xml")
    }
    static void readXml(filePath){
        def xml = new XmlSlurper().parse(filePath)
        xml.each {
            it ->
                println it
        }
    }
}
