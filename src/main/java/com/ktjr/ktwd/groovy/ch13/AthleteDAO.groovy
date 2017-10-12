package com.ktjr.ktwd.groovy.ch13

/**
 * Created by yzy
 * on 2017/10/11.
 */
class AthleteDAO extends DataAccessObject{

    @Override
    Map getFields() {
        return [
                firstname :'VARCHAR(64)',
                lastname : 'VARCHAR(64)',
                birthOfDate : 'DATE'
        ]
    }
}
