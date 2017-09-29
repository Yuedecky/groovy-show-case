package com.ktjr.ktwd.groovy.ch09

import groovy.time.TimeCategory

/**
 * Here, TimeCategory adds methods at runtime
 * that are difficult to examine for the type checker
 */
use(TimeCategory){
    duration = 1.week - 1.day
}

