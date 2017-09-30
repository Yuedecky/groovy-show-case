package com.ktjr.ktwd.groovy.ch11

import groovy.swing.SwingBuilder
import java.awt.BorderLayout as BL

/**
 * Created by forker on 2017/9/30.
 */
class UsingSwingBuilders {

    static void main(String[] args) {

        button()
    }

    static void panel(){
        def swing = new SwingBuilder()
        def frame = swing.frame(title:'Demo') {
            menuBar {
                menu('File') {
                    menuItem 'New'
                    menuItem 'Open'
                }
            }
            panel {
                label 'Label 1'
                slider()
                comboBox(items:['one','two','three'])
            }

        }
        frame.pack()
        frame.visible = true
    }

    static void layout(){
        def swing = new SwingBuilder()
        def frame = swing.frame(title:'Layout Demo') {
            panel(layout: new BL()) {
                button(constraints: BL.NORTH, 'North' )
                button(constraints: BL.CENTER, 'Center')
                button(constraints: BL.SOUTH, 'South' )
                button(constraints: BL.EAST, 'East' )
                button(constraints: BL.WEST, 'West' )
            }
        }
        frame.pack()
        frame.visible = true
    }

    static void button(){
        def swing = new SwingBuilder()
        def frame = swing.frame(title:'Printer') {
            panel {
                textField(id:'message', columns:10)
                button(text:'Print', actionPerformed: {
                    println swing.message.text
                })
            }
        }
        frame.pack()
        frame.visible = true


    }
}
