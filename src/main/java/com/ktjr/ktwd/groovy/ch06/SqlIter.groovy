package com.ktjr.ktwd.groovy.ch06

import org.junit.Test
import groovy.sql.Sql

/**
 * Created by forker on 2017/9/22.
 */
/**
 * 更多内容可以参考这个demo http://www.jianshu.com/p/a0e301f79f9b
 * 和官网： http://www.groovy-lang.org/databases.html
 */
class SqlIter {

    @Test
    void test(){
        def sql = Sql.newInstance(
                "jdbc:mysql://localhost:3306/spring_data?useSSL=true",
                "root",
                "123456",
                "com.mysql.cj.jdbc.Driver"
        )
        println("grab a specific field")
        sql.eachRow("select name from languages"){ row ->
            println row.name
        }

        println("grab all fields")
        sql.eachRow("select * from languages"){ row ->
            println("Name: ${row.name}")
            println("desc: ${row.desc}")
            println("URL: ${row.url}\n")
        }
    }

}
