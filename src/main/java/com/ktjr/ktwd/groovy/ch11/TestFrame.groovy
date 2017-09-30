package com.ktjr.ktwd.groovy.ch11

import groovy.swing.SwingBuilder

import java.awt.Color

/**
 * Created by forker on 2017/9/30.
 */
class TestFrame {


    static void main(String[] args) {
        def purple = new NamedColor('purple', Color.WHITE, new Color(127, 0, 255))
        def mediumBlue = new NamedColor("Blue", Color.WHITE, new Color(64, 128, 255))
        def brightYellow = new NamedColor('Yellow', Color.BLACK, Color.YELLOW)
        def brightRed = new NamedColor("Red", Color.BLACK, Color.RED)
        def data = [
                [name: 'Anthony', color: mediumBlue],
                [name: 'Greg', color: brightYellow],
                [name: 'Jeff', color: purple],
                [name: 'Murray', color: brightRed]
        ]

        def swing = new SwingBuilder()
        def frame = swing.frame(title: 'Table Demo') {
            scrollPane {
                table(id: 'table') {
                    tableModel(list: data) {
                        propertyColumn(header: 'Name', propertyName: 'name')
                        propertyColumn(
                                header: 'Color', propertyName: 'color', type: NamedColor
                        )
                    }
                }
            }

        }
        frame.pack()
        swing.table.setDefaultRenderer(NamedColor, new ColorRenderer())
        frame.visible = true
    }
}
