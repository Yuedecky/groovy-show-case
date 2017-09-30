package com.ktjr.ktwd.groovy.ch11

import groovy.swing.SwingBuilder

/**
 * Created by forker on 2017/9/30.
 */
class UsingSwingBuilder {

    static void main(String[] args) {
        def swing = new SwingBuilder()
        def frame = swing.frame(title: "password"){
            passwordField(columns:10,actionPerformed:{ event ->
                println event.source.text
// any further processing is called here
                System.exit(0)
            })
            }
        frame.pack()
        frame.visible = true
    }
}
