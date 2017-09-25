package com.ktjr.ktwd.groovy.ch02

/**
 * Created by forker on 2017/9/25.
 */
class TestResources {

    /**
     * groovy style
     * @param args
     */
    static void main(args){
        def path = System.properties.'user.dir' + "/src/main/resources/demo.txt"
        new File(path).eachLine { println it }
        def printer = getPrinter()

        test3()
        test4()

       test(5)

        test5()

    }

    /**
     * As you see, closures are objects. They can be stored in variables, they can be passed
     around, and, as you probably guessed, you can call methods on them. Being objects,
     closures can also be returned from a method
     * @return
     */
    static def  getPrinter(){
        return { line ->
            println line
        }
    }


    static class SizeFilter {
        Integer limit
        boolean sizeUpTo(String value) {
            return value.size() <= limit
        }

        static void main(args){
            SizeFilter filter1 = new SizeFilter(limit: 6)
            SizeFilter filter2 = new SizeFilter(limit: 5)

            Closure sizeUpTo6 = filter1.&sizeUpTo
            Closure sizeUpTo5 = filter2.&sizeUpTo
            def words = ['long string','medium','short','tiny']

            assert 'medium' == words.find(sizeUpTo6)
            assert 'short' == words.find(sizeUpTo5)



        }
    }

    static class MultiMethodSample{
        int mysteryMethod(String value){
            return value.length()
        }

        int mysteryMethod(List list){
            return list.size()
        }
        int mysteryMethod(int x,int y){
            return x + y
        }


        static void main(args){
            MultiMethodSample sample = new MultiMethodSample()
            Closure multi = sample.&mysteryMethod

            assert 10 == multi('String arg')
            assert 3 ==multi(['list','of','values'])
            assert 14 == multi(6,8)
        }
    }

    static void test3(){
        assert numParams {one ->} ==1
        assert numParams {one,two ->} ==2
    }
    static void test4(){
        assert paramTypes {String s ->} == [String]
        assert paramTypes {Number n,Date d ->} == [Number,Date]
    }

    def static numParams (Closure closure){
        closure.getMaximumNumberOfParameters()
    }

    def static paramTypes(Closure closure){
        return closure.getParameterTypes()
    }



    static void test(int n) {
        def multi = {
            x, y ->
                return x * y
        }
        def twoTimes = multi.curry(2)
        assert twoTimes(n) == 2*n
        twoTimes = {
            y -> multi 2,y
        }

    }

    static void test5(){
        def configurator = {
            format,filter, line ->
                filter(line) ? format(line) : null
        }
        def appender = {
            config, append,line ->
                def out = config(line)
                if(out) append(out)
        }

        def dateFormatter = {
            line ->
                "${new Date()}:$line"
        }
        def debugFilter = {
            line ->
                line.contains('debug')
        }

        def consoleAppender = {
            line ->
                println line
        }

        def myConf = configurator.curry(dateFormatter,debugFilter)

        def myLog = appender.curry(myConf,consoleAppender)
        myLog("here is some debug message")
        myLog("this will not be printed")
    }




}
