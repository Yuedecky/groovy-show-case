package com.ktjr.ktwd.groovy.ch01
import static groovyx.gpars.GParsPool.withPool
/**
 * Created by forker on 2017/9/22.
 */
class DoJavaBusyWorks {

    static def main(args){
        method1()
    }
    static def method1(){
        def urls = [
                "http://www.groovy-lang.org",
                "http://www.gpars.org/",
                "http://gr8conf.org"
        ]*.toURL()

        println withPool{
            urls.collectParallel {
                it.text.findAll(~/[Gg]roovy/).size()
            }
        }

    }
}
