package com.ktjr.ktwd.groovy.ch16

import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ImportCustomizer


/**
 * Created by yzy
 * on 2017/10/16.
 */
class UseBinding {

    static void main(String[] args) {

        testConfig()
    }

    static def test1() {
        def binding = new Binding([distance: 3400, time: 34])
        def shell = new GroovyShell(binding)
        shell.evaluate '''
                speed = distance / time
            
        '''
        assert binding.distance == 3400

        assert binding.speed == 100
    }

    static def test2() {
        def binding = new Binding(
                robot: new Robot(),
                left: Direction.left,
                right: Direction.right,
                forward: Direction.forward,
                backward: Direction.backward
        )
        def shell = new GroovyShell(this.classLoader, binding)

        shell.evaluate '''
            robot.move left
        '''
    }

    static def test3() {
        def binding = new Binding(
                robot: new Robot(),
                *: Direction.values().collectEntries {
                    [(it.name()): it]
                }
        )
        def shell = new GroovyShell(this.classLoader, binding)
        shell.evaluate '''
            robot.move left
        '''
    }

    static def testConfig() {
        def binding = new Binding(robot: new Robot())
        def importCustomerizer = new ImportCustomizer()
        importCustomerizer.addStaticStars Direction.name
        def config = new CompilerConfiguration()
        config.addCompilationCustomizers config
        config.scriptBaseClass = Robot.class
        def shell = new GroovyShell(this.classLoader, binding, config)
        shell.evaluate '''
            move left
        '''

    }
}
