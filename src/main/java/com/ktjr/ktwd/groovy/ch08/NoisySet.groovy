package com.ktjr.ktwd.groovy.ch08

/**
 * Created by forker on 2017/9/28.
 */
/**
 * 在java中，一个重用现有代码的最简单的方法是用一个父类，
 * 但只是因为 它很容易，并不意味着它是最好的方法。
 * 如果你真的有一个纯粹的IS-A关系 两类，
 * 然后继承可能是适当的，但在许多情况下 在构建你想要的行为进行修改，新的类 一些方法。
 */

/**
 * 委托是有关系的 两类之间。
 * 通常，一个类将包含一个引用到另一个，
 * 然后还分享一些这类的API
 * 下面的例子可以说明 这个更好的。
 * 首先，让我们看看我们如何可能会使用继承来创建 noisyset类打印输出每当一项添加到集合
 */
class NoisySet extends HashSet{

    @Override
    boolean add(item) {
        println "adding $item"
        return super.add(item)
    }

    @Override
    boolean addAll(final Collection items) {
        items.each {
            println "adding $it"
        }
        return super.addAll(items)
    }
}
