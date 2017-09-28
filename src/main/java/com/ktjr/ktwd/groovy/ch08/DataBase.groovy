package com.ktjr.ktwd.groovy.ch08

import groovy.util.logging.Log

/**
 * Created by forker on 2017/9/28.
 */
@Log
class DataBase {
    def search(){
        log.fine(runLongDatabaseQuery())
    }

    def runLongDatabaseQuery(){
        println 'calling database'
        return 'query result'
    }

    static void main(String[] args) {
        new DataBase().search()
    }
}
