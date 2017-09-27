package com.ktjr.ktwd.groovy.ch07

/**
 * Created by forker on 2017/9/27.
 */
class MyGroovy1 {

    static void main(String[] args) {
        def before = new MyGroovy1()
        MyGroovy1.metaClass.myProp = "MyGroovy Prop"
        MyGroovy1.metaClass.test = {-> myProp}
        try{
            before.test()
            assert false, 'should throw MME'
        }catch (mme){
        }
        assert new MyGroovy1().test() == 'MyGroovy prop'
    }
}
