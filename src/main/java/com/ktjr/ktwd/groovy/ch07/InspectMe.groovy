package com.ktjr.ktwd.groovy.ch07

/**
 * Created by forker on 2017/9/27.
 */
class InspectMe {
    int outer(){
        return inner()
    }
    private int inner(){
        return 1
    }

    static void main(String[] args) {
        def tracer = new TracingInterceptor(writer: new StringWriter())
        def proxyMetaClass = ProxyMetaClass.getInstance(InspectMe)
        proxyMetaClass.interceptor =tracer

        InspectMe me = new InspectMe()
        me.metaClass = proxyMetaClass
        
        assert 1 == me.outer()
        assert "\n"+tracer.writer.toString() ==
                """
                   before InspectMe.outer()
                     before InspectMe.inner()
                     after InspectMe.inner()
                   after InspectMe.outer()
                """


    }
}
