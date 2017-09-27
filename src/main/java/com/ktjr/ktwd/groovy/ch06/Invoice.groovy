package com.ktjr.ktwd.groovy.ch06

/**
 * Created by forker on 2017/9/27.
 */
class Invoice {

    List items
    Date date

    static void main(def args) {

        def ulcDate = Date.parse('yyyy-MM-dd','2017-09-01')
        def otherDate = Date.parse('yyyy-MM-dd','2016-09-23')
        def ulc = new Product(dollar: 1234,name: 'ULC')
        def ve = new Product(dollar: 345,name: "visual Editor")
        def invoices = [
                new Invoice(date: ulcDate,items: [
                        new LineItem(count: 4,product: ulc),
                        new LineItem(count: 2,product: ve)
                ]),
                new Invoice(date: otherDate,items:[
                        new LineItem(count: 4, product: ve)
                ])
        ]

        def allItems = invoices.items.flatten()
        allItems*.total().each{
            println it
        }
    }
}
