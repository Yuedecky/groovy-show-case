package com.ktjr.ktwd.groovy.ch15

import groovyx.gpars.dataflow.DataflowQueue
import groovyx.gpars.dataflow.Dataflows

import static groovyx.gpars.dataflow.Dataflow.operator
import static groovyx.gpars.dataflow.Dataflow.task

/**
 * Created by yzy
 * on 2017/10/13.
 */

class UseDataFlows {

    static void main(String[] args) {

    }

    static def test1() {
        final flow = new Dataflows()


        task {
            flow.result = flow.x = flow.y
        }

        task {
            flow.x = 10
        }
        task {
            flow.y = 5
        }

        assert 15 == flow.result
    }


    static def test2() {
        def chances = new DataflowQueue()
        def amounts = new DataflowQueue()
        def payouts = new DataflowQueue()


        operator(
                inputs: [chances, amounts],
                outputs: [payouts]) {
            chance, amount ->
                payouts << chance * amount
        }

        task{
            [0.1,0.2,0.3].each {
                chances << it
            }
        }

        task{
            [300,200,100].each {
                amounts << it
            }
        }
    }


}






