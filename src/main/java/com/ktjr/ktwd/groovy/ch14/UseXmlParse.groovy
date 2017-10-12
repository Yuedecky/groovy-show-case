package com.ktjr.ktwd.groovy.ch14

import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory

import javax.xml.parsers.DocumentBuilderFactory

/**
 * Created by yzy
 * on 2017/10/12.
 */
class UseXmlParse {

    static void main(String[] args) {

        parseXmlWithDomParser()
        useDOMCategory()
        readingDOMWithXmlParser()
        testGPathResult()
    }
    /**
     * xml和JSON：
     * 1。Techniques for parsing XML in Groovy
     * 2。Tricks for processing and transforming XML
     * 3。Groovy support for parsing JSON, which is probably the most widespread alternative
     to XML

     */

    /**
     * parse plan.xml file
     * we plan for two weeks,with eight hours for education each week.
     * Three tasks are schduled for current week: reading this chapter,playing with the newly acquired knowledge
     * and using it in the real world
     */
    static def parseXmlWithDomParser(){
        /**
         * even in groovy code,we sometimes need DOM Objects for further processing:
         * for example: when applying XPath expressions to an object
         * For that reason, we show the groovy way of retrieving the DOM parsers.
         * Second,there's basic Groovy suport for dealing with DOM NodeLists,and Groovy also
         * provides extra helper classes to simplify common tasks within the DOM
         */
        def factory = DocumentBuilderFactory.newInstance()
        def builder = factory.newDocumentBuilder()
        def doc = builder.parse(new FileInputStream(System.properties.'user.dir'+'/src/main/java/com/ktjr/ktwd/groovy/ch14/plan.xml'))
        /**
         * We can now work with the plan variable
         * It’s of type org.w3c.dom.Node.
         * The nodeType is Node.ELEMENT_NODE, and the nodeName is plan
         *
         */
        def plan = doc.documentElement
        assert info(plan) == 'element:plan'

        def firstWeek = plan.childNodes.find{
            it.nodeName == 'week'
        }

        assert info(firstWeek) == 'element:week'

        def firstTask = firstWeek.childNodes.item(1)
        assert info(firstTask) == 'element:task'

        def firstTaskText = firstTask.childNodes.item(0)

        assert info(firstTaskText) == 'text:easy'


        def firstTaskTitle = firstTask.attributes.getNamedItem('title')

        assert info(firstTaskTitle) == 'attribute:title = read XML chapter'
    }

    static String info(node){
        switch (node.nodeType){
            case org.w3c.dom.Node.ELEMENT_NODE:
                return "element:$node.nodeName"
            case org.w3c.dom.Node.ATTRIBUTE_NODE:
                return "attribute:$node.nodeName = $node.nodeValue"
            case org.w3c.dom.Node.TEXT_NODE:
                return "text:$node.nodeValue"
        }
        return "some other type: $node.nodeType"
    }

    /**
     * Groovy provides a DOMCategory that you can use for simplified access.
     With it, you can index child nodes via the subscript operator or via their node name
     */
    static def useDOMCategory(){

        def doc = DOMBuilder.parse(new FileReader(System.properties.'user.dir'+'/src/main/java/com/ktjr/ktwd/groovy/ch14/plan.xml'))
        def plan = doc.documentElement
        use(DOMCategory){
            assert plan.name() == 'plan'
            assert plan.week[0].name() == 'week'
            assert plan.week[0].'@capacity' == '8'
            assert plan.week.task[0].name() == 'task'
            assert plan.week.task[0].text() == 'easy'
        }
    }



    static def readingDOMWithXmlParser(){
        def plan = new XmlParser().parse(new File(System.properties.'user.dir'+'/src/main/java/com/ktjr/ktwd/groovy/ch14/plan.xml'))

        assert plan.name() == 'plan'
        assert plan.week[0].name() == 'week'
        assert plan.week[0].task[0].name() == 'task'
        assert plan.week[1].task[0].@title == 're-read DB chapter'
    }

    /**
     * common methods of groovy.util.node and GPathResult:
     * Node method ---->  GPathResult
     * 1. name() --> String name()
     * 2. text() ---> String text()
     * 3. toString() ---> String toString()
     * 4. Node parent()   ----> GPathResult parent()
     * 5. List children()   -----> GPathResult cgildren()
     * 6. Map attributes() ----> Map attributes()
     * 7. Iterator iterator() ---> Iterator iterator()
     * 8.List depthFirst()  ----> Iterator depthFirst()
     * 9. List breadthFirst() ----> Iterator breadthFirst()
     */


    static def testGPathResult(){
        def plan = new XmlParser().parse(new FileReader(System.properties.'user.dir'+'/src/main/java/com/ktjr/ktwd/groovy/ch14/plan.xml'))


        assert 2 == plan.week.task.findAll{
            it."@title" =~ 'XML'
        }.size()
    }



}
