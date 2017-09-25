package com.ktjr.ktwd.groovy.ch01

/**
 * Created by forker on 2017/9/25.
 */
class ProcessUrls {

    static void main(args){
        def urls = [
                new URL('http','myshop.com',80,'index.html'),
                new URL('https','myshop.com',443,'buynow.html'),
                new URL('ftp','myshop.com',21,'downloads')
        ]
        assert urls.findAll{it.port <99}.collect {
            it.file.toUpperCase()
        }.sort().join(",") == 'DOWNLOADS,INDEX.HTML'
    }
}
