package com.ktjr.ktwd.groovy.ch12

/**
 * Created by forker on 2017/10/9.
 */
class TestThread {

    static void main(String[] args) {

        zip()
    }

    static def test1(){
        Thread.start('thread-001') {

        }
    }

    static def deffer(long delay){
        new Timer().runAfter(delay){

        }
    }

    static def cmd(){
        def env = ['USERNAME=mittie']
        def proc = 'cmd /c set'.execute(env, new File('/'))
        InputStream input = proc.in
        OutputStream out = proc.out
        InputStream err = proc.err

        proc.waitForOrKill(1000)


    }

    static def testCommand(){
        def listFiles = 'ls'.execute()
        def ignoreCase = "tr '[A-Z]' '[a-z]'".execute()
        def reverseSort = 'sort -r'.execute()
        listFiles | ignoreCase | reverseSort
        reverseSort.waitForOrKill(1000)
        if(reverseSort.exitValue()){
            println reverseSort.err.text
        }else {
            print reverseSort.text
        }
    }

    static def zip(){
        def outputBuffer = new StringBuffer()
        def errorBuffer = new StringBuffer()
        def zipProcess = 'gzip -c'.execute()
        def unzipProcess = 'gunzip -c'.execute()

        unzipProcess.consumeProcessOutput(outputBuffer,errorBuffer)
        zipProcess.consumeProcessErrorStream(errorBuffer)

        zipProcess | unzipProcess
        zipProcess.withWriter {
            writer->
                writer << "Hello World"
        }

        unzipProcess.waitForOrKill(1000)

        println "Output:$outputBuffer"
        println "Error:$errorBuffer"
    }
}
