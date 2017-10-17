package com.ktjr.ktwd.groovy.ch16

/**
 * Created by yzy
 * on 2017/10/16.
 */
def shell = new GroovyShell(this.class.classLoader)
shell.evaluate '''

        def robot = new Robot()
        robot.move Direction.left
'''

/**
 * we evaluated a DSL that was in the form of a string
 * but the idea here is thast your DSL might come from an external file.
 * you could also store this DSL in a database or elsewhere
 */

