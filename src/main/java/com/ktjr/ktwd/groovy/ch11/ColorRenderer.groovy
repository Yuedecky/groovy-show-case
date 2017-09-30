package com.ktjr.ktwd.groovy.ch11

import javax.swing.JLabel
import javax.swing.JTable
import javax.swing.table.TableCellRenderer
import java.awt.Component

/**
 * Created by forker
 * on 2017/9/30.
 */
class ColorRenderer extends JLabel implements TableCellRenderer {
    def opaque

    ColorRenderer(){

        opaque = true
    }

    @Override
    Component getTableCellRendererComponent(
            final JTable table,
            color, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
        background = color.background
        foreground = color.foreground
        text = color.name
        horizontalAlignment = CENTER
        this
    }
}
