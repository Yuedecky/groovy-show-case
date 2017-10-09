package com.ktjr.ktwd.groovy.ch12

/**
 * Created by forker on 2017/10/9.
 */
class TestFile {

    static void main(String[] args) {
        test2()
    }

    static def test1(){
        def file = new File('.')
        println file.name
        println file.absolutePath
        println file.canonicalPath
        println file.directory
    }

    static def test2(){
        def topDir = new File('src/main/java/com/ktjr/ktwd/')
        def srcDir = new File(topDir,'groovy')
        def dirs = []
        srcDir.eachDir {
            dirs << it.name
        }

        println dirs
    }
}
