package com.ktjr.ktwd.groovy.ch14

import groovy.xml.DOMBuilder
import groovy.xml.XmlUtil
import groovy.xml.dom.DOMCategory
import org.xml.sax.helpers.DefaultHandler

import java.util.jar.Attributes

/**
 * Created by yzy
 * on 2017/10/12.
 */
class PlanHandler extends DefaultHandler {


    def underway = []
    def upcoming = []

    void startElement(String namespace, String localName, String qName, Attributes attributes
    ) {

        if (qName != 'task') return
        def title = attributes.getValue('title')
        def total = attributes.getValue('total')
        switch (attributes.getValue('done')) {
            case '0': upcoming << title
                break
            case { it != total }: underway << title; break
        }
    }


    static void main(String[] args) {
        updateXml()
    }

    static def updateXml() {
        def doc = DOMBuilder.parse(new FileReader(System.properties.'user.dir' + '/src/main/java/com/ktjr/ktwd/groovy/ch14/plan.xml'))

        def plan = doc.documentElement
        use(DOMCategory) {
            plan.week[0].task[2]['@done'] = '2333'
            plan.week[0].task[2].value = 'time updater'
            plan.week[1].task[1].replaceNode {
                task(done: '0', total: '444', title: 'build web service')
            }
            plan.week[1].task[1] + {
                task(done: '0', total: '1', title: 'building plus')
            }
        }
        UpdateChecker.check(XmlUtil.serialize(plan))
    }

}
