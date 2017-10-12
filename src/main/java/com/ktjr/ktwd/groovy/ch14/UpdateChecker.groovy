package com.ktjr.ktwd.groovy.ch14

/**
 * Created by forker on 2017/10/12.
 */
class UpdateChecker {
    static check(text){
        def updated = new XmlParser().parseText(text)
        updated.week[0].with{
            assert it.task.@done*.toInteger().sum() == 2338
            assert it.find{
                it.text() == "time updater"
            }

            updated.week[1].with{
                w1 ->
                    assert w1.children().size() == 3
                    assert w1.findAll{

                        it.@total
                    }
            }
        }
    }
}
