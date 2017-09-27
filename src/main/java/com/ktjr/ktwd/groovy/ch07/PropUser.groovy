package com.ktjr.ktwd.groovy.ch07

/**
 * Created by forker on 2017/9/27.
 */
class PropUser extends NoParens{
    boolean existingProperty = true

    static void main(String[] args) {
            def user = new PropUser()
        assert user.existingProperty
        assert user.toString() == user.toString
    }
}
