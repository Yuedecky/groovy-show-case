package com.ktjr.ktwd.groovy.ch15

import spock.lang.Specification

/**
 * Created by yzy
 * on 2017/10/13.
 */
class MovieSpec extends Specification {
    def 'buy ticket for a movie theater'(){
        given:
        def purchase = new Purchase('Lord of the Rings',2)
        MovieTheater theater = Mock()
        theater.hasSeatAvailable('Lord of the Rings',2) >> true
        when:
        purchase.fill(theater)
        then:
        purchase.completed
        1 * theater.purchaseTicket('Lord of the Rings',2)
    }
}
