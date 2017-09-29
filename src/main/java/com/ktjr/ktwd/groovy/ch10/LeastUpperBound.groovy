package com.ktjr.ktwd.groovy.ch10

/**
 * Created by forker on 2017/9/29.
 */
class LeastUpperBound {

    /**
     *
     * @param args
     */
    static void main(String[] args) {
        def list = [23,3.45]
        /**
         * 你能在第一眼就确定该列表的类型是什么？有几个答案是可能的，

         * 但如果你仔细看一看的元素，你会发现第一个是一个整数，
         * 另一个是BigDecimal（在Groovy中，小数是BigDecimal默认情况下，没有像java）。
         * 所以类型检查器必须计算 这两个元素的常见类型。
         * 从记忆中，你可能猜到Number， 它是一个接口。
         * 这是正确的，但Integer和BigDecimal 都实现了 serializable的，所以为什么你宁愿数序列化？
         * 为什么不选择最低具体的常见的超类（在这种情况下，是Object)
         */

        /**
         * 为了解决这个问题，常规的介绍了最小上界的概念，这是
         一种是用户不能定义但是编译器知道的模式。
         在这种情况下，最小上界是一个数，具有Comparable，和
         Serializable
         */

    }
}
