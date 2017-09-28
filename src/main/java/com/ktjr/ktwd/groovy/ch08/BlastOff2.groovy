package com.ktjr.ktwd.groovy.ch08

import groovy.transform.TimedInterrupt

import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

/**
 * Created by forker on 2017/9/28.
 */

/**
 * Script support:
 * The transforms that fall into this category include @Field,
 @BaseScript, @TimedInterrupt, @ThreadInterrupt, and @ConditionalInterrupt.
  You should also check out the GroovyDoc for @SourceURI, which gives you a hook
  back to a script’s source
 */
@TimedInterrupt(value = 480L,unit = TimeUnit.MILLISECONDS)
class BlastOff2 {

    def log = []

    def countDown(n){

        sleep 100
        log << n
        if(n == 0){
            log << 'ignition'
        }else {
            countDown(n-1)
        }
    }

    static void main(String[] args) {
        def b = new BlastOff2()
        Thread.start {
            try{
                b.countDown(10)
            }catch (TimeoutException ignore){
            }
        }.join()
        assert  b.log.join(' ') == '10 9 8 7'
    }


}
