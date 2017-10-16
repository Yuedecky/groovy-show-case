package com.ktjr.ktwd.groovy.ch15

import junit.framework.TestSuite
import junit.textui.TestRunner

/**
 * Created by yzy
 * on 2017/10/13.
 */
class UseTestSuite {

    static void main(String[] args) {

        def suite = suite()

        TestRunner.run(suite)


    }

    static def suite(){
        def suite = new TestSuite()
        def gts = new GroovyTestSuite()
        suite.addTestSuite(gts.compile(""))
        suite.addTestSuite(gts.compile(""))
        return suite
    }


    def relay(request,farm){
        farm.machines.sort{
            it.load
        }[0].send(request)
    }
}
