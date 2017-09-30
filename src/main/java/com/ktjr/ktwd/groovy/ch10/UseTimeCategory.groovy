package com.ktjr.ktwd.groovy.ch10


def meetting


use(TimeCategory){
    Booking booking = new Booking()
    booking.book meetting room 'Honolulu' between 9.am and 12.am to 'B2'
}
