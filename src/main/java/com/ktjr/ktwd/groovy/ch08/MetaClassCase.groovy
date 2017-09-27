package com.ktjr.ktwd.groovy.ch08

/**
 * Created by forker on 2017/9/27.
 */
class MetaClassCase {

    static void main(def args) {
        MetaClass metaClass = String .metaClass
        MetaMethod alias = String.metaClass.metaMethods.find{
            it.name == 'size'
        }
        String.metaClass{
            oldSize = {
                ->
                alias.invoke delegate

            }
            size = {
                ->
                oldSize() *2
            }

        }
        
        assert "abc".size() == 6
        assert "abc".oldSize() ==3

        if(metaClass.is(String.metaClass)){
            String.metaClass{
                oldSize = {
                    ->
                    throw new UnsupportedOperationException()
                }
                size = {
                    ->
                    alias.invoke delegate
                }
            }
        }else {
            String.metaClass = metaClass
        }
        assert "abc".size() == 3
    }

    /**
     * Once you’ve experienced the merits of dynamic programming,
     * you’ll find it unwieldy to go back to a static language.
     */
}
