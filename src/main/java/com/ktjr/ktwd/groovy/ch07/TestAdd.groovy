package com.ktjr.ktwd.groovy.ch07

/**
 * Created by forker on 2017/9/27.
 */
class TestAdd {

    static void main(String[] args) {
        assert String.metaClass =~ /MetaClassImpl/
        String.metaClass.low = {
            ->
            delegate.toLowerCase()
        }
        assert "DiErK".low() == 'dierk'
    }


}
