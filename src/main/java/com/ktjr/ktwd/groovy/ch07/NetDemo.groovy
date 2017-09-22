
package com.ktjr.ktwd.groovy.ch07
//@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7' )
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.*
import static groovyx.net.http.ContentType.*


/**
 * Created by forker on 2017/9/22.
 */

/**
 * 详细参考： http://groovy.codehaus.org/modules/http-builder/home.html
 */
class NetDemo {

    HTTPBuilder http = new HTTPBuilder('http://m.weather.com.cn')

    def tellWeather(){
        when:
        def info =""
        http.request( GET, JSON ) {
            url.path = '/data/101290401.html'
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
            response.success = { resp, json ->
                info = json.weatherinfo.city
            }
            response.failure = { resp -> println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}" }
        }
        then:  "曲靖"==info
    }


}
