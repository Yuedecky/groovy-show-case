package com.ktjr.ktwd.groovy.ch11

import groovy.transform.Canonical

import java.awt.Color

/**
 * Created by forker
 * on 2017/9/30.
 */
@Canonical
class NamedColor {
    String name
    Color foreground, background

}
