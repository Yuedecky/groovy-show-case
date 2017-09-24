package com.ktjr.ktwd.groovy.ch01

/**
 * Created by forker on 2017/9/24.
 */
class Weekly implements Comparable{
    static final DAYS = [
            'Suns',
            'Mon',
            'Tue',
            'Wed',
            'Thu',
            'Fri',
            'Sat'
    ]


    private int index = 0
    Weekly(String day){
        index = DAYS.indexOf(day)
    }

    Weekly next(){
        return new Weekly(DAYS[(index + 1) % DAYS.size()])
    }

    Weekly previous(){
        return new Weekly(DAYS[index - 1])
    }

    @Override
    int compareTo(Object other){
        return this.index <=> other.index
    }

    @Override
    String toString() {
        return DAYS[index]
    }

    static void main(args){
        def mon = new Weekly("Mon")
        def fri = new Weekly("Fri")
        def workDay = ''
        (mon..fri).each {
            workDay += "${it}\n"
        }
        println workDay
        println workDay[-1]
    }
}
