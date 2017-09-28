package com.ktjr.ktwd.groovy.ch08

import groovy.transform.AutoExternalize
import groovy.transform.ToString

/**
 * Created by forker
 * on 2017/9/28.
 */
@AutoExternalize
@ToString
class Composer {
    String name
    int born
    boolean married


    static void main(String[] args) {
        def c = new Composer(name: 'Wolfgang Amadeus Mozart'
        ,born: 1765,married: true)
        def baos = new ByteArrayOutputStream()
        baos.withObjectOutputStream {
            os ->
                os.writeObject(c)
        }
        def bais = new ByteArrayInputStream(baos.toByteArray())

        def loader = this.classLoader
        def result
        bais.withObjectInputStream(loader) {
            result = it.readObject().toString()
        }

        assert result == 'com.ktjr.ktwd.groovy.ch08.Composer(Wolfgang Amadeus Mozart, 1765, true)'
    }
}
