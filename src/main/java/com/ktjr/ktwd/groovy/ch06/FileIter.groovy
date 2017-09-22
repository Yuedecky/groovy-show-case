package com.ktjr.ktwd.groovy.ch06

/**
 * Created by forker on 2017/9/22.
 */
class FileIter {

    static void main(args){
        println System.properties.each {
            it ->
                println(it)
        }
        println()

        println "------"

        read(System.properties."user.dir"+"/src/main/resources/demo.txt")
    }

    static def read(file){
        def f = new File(file)
        f.eachLine {
            println "I Know "+it
        }
    }
}
