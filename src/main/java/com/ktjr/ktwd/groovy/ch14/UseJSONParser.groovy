package com.ktjr.ktwd.groovy.ch14

import groovy.json.JsonBuilder


/**
 * Created by yzy
 * on 2017/10/12.
 */
class UseJSONParser {


    static void main(String[] args) {

        def builder = new JsonBuilder()

        builder.weeks {
            capacity '8'
            tasks([
                    {
                        done '0'
                        total '4'
                        title 'build web services'
                    },
                    {
                        done: '0'
                        total '1'
                        title 'build web service client'
                    }
            ])
        }
        print builder.toString()
    }
}
