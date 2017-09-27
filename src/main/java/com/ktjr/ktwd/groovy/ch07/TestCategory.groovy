package com.ktjr.ktwd.groovy.ch07

import groovy.time.TimeCategory

def janFirst1970 = new Date()
use TimeCategory,{
    Date xmas = janFirst1970 + 1.year -7.days
    assert xmas.month == Calendar.DECEMBER
    assert xmas.date == 25
}

