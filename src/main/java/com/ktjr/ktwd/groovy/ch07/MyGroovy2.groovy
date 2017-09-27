package com.ktjr.ktwd.groovy.ch07

/**
 * Created by forker on 2017/9/27.
 */
class MyGroovy2 {
    static void main(String[] args) {


        test2()
        
    }

    static def test(){
        def myGroovy = new MyGroovy2()
        myGroovy.metaClass.myProp = "MyGroovy prop"
        myGroovy.metaClass.test = {
            ->
            myProp
        }
        try {
            test()
            assert false, 'should throw MME'
        } catch (mme) {
        }
        assert myGroovy.test == 'MyGroovy prop'
    }

    static move(string, distance) {
        string.collect {
            (it as char) + distance as char
        }.join()
    }


    static void test2() {
        String.metaClass {
            shift = -1
            encode {
                ->
                move delegate, shift
            }
            decode {
                ->
                move delegate, -shift
            }
            getCode {
                ->
                encode()
            }
            getOrig {
                ->
                decode()
            }
        }
        
        assert "IBM".encode() =="HAL"
        assert "HAL".orig == "IBM"
        
        def ibm = "IBM"
        
        ibm.shift = 7
        assert ibm.code == 'PIT'
    }


}

