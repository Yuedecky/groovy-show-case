package com.ktjr.ktwd.groovy.ch08

import groovy.transform.builder.Builder

/**
 * Created by forker
 * on 2017/9/28.
 */
@Builder
/**
 *  Builder有四种策略：
 *  1.DefaultStrategy: Creates a nested helper class for instance creation. Each method in
 the helper class returns the helper until finally a build() method is
 called, which returns a created instance.
 *
 *  2. SimpleStrategy: Creates chainable setters, where each setter returns the object itself
 after updating the appropriate property.
 *
 *
 *  3. ExternalStrategy:Allows you to annotate an explicit builder class while leaving some
 builder class being built untouched. This is appropriate when you want
 to create a builder for a class you don’t have control over such as from
 a library or another team in your organization
 *
 *  4.InitializerStrategy:Creates a nested helper class for instance creation that when used
 with @CompileStatic allows type-safe object creation. Compatible
 with @Immutable
 *
 */
class Chemist {
    String first
    String last
    int born

    static void main(String[] args) {
        def builder = Chemist.builder()
        def c = builder.first("Marie").last('Curie').born(1867).build()
        assert c.first == 'Marie'
        assert c.last == 'Curie'
        assert c.born == 1867
    }
}
