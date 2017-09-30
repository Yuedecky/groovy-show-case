package com.ktjr.ktwd.groovy.ch10

/**
 * Created by forker
 * on 2017/9/29.
 */
class Booking {

    String mettingRoom

    String className
    Date start,end

    def book(def metting){
        [room: {
            name ->
                [between: {
                    sd ->
                        [and:{
                            ed ->
                                [to:
                                         {
                                                 to ->
                                                 def b = new Booking(mettingRoom: name,className: to,start: start,end: end)
                                             print b
                                             b
                                         }]
                        }]
                }]
        }]




    }
}
