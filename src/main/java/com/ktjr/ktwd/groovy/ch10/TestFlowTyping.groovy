package com.ktjr.ktwd.groovy.ch10

/**
 * Created by forker
 * on 2017/9/29.
 */

/**
 * In the previous sections, we’ve spent time explaining what @TypeChecked would offer you,
 * and what it would prohibit, but we also explained why it was difficult to
 * perform static analysis of a dynamic language
 */
class TestFlowTyping {

    /**
     * This example makes use of a single variable (var) to
     * which different objects are stored at different lines
     * @return
     */
    def flowTyping(){
        def var = 'A string' // String
        var = var.toUpperCase() //string#tpUpperCase()
        var = var.length() //string.length()
        var = String.valueOf(var) //int
        var = 2*var
        var
    }




}
