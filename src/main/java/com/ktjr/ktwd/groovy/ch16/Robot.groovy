package com.ktjr.ktwd.groovy.ch16

/**
 * Created by yzy
 * on 2017/10/16.
 */
class Robot {
    void move(Direction direction){
        println "robot moved $direction"
    }

    static void main(String[] args) {
        def robot = new Robot()
        robot.move Direction.left
    }
}
