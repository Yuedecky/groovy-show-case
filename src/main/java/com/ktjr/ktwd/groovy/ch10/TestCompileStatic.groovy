package com.ktjr.ktwd.groovy.ch10

import groovy.transform.CompileStatic

/**
 * Created by forker on 2017/9/29.
 */

    def dynamicFib(n){
        n<1 ?1 : dynamicFib(n-1) + dynamicFib(n-2)
    }
    int primFib(int n){
        n <1 ? 1 : primFib(n-1) + primFib(n-2)
    }


    @CompileStatic
    int staticFib(int n){
        n < 1? 1: staticFib(n-1) + staticFib(n-2)
    }

        def r = benchmark {
            'Dynamic Groovy'  {
                dynamicFib(10)
            }

            'Primitive optimized Groovy' {
                primFib(10)
            }

            'Static complied Groovy' {
                staticFib(10)
            }
        }
        r.prettyPrint()


