package com.ktjr.ktwd.groovy.ch12

import groovy.text.SimpleTemplateEngine

/**
 * Created by yzy
 * on 2017/10/9.
 */

/**
 * A template is essentially text. Unlike fixed literal text, a template allows predefined
 * modifications. These modifications follow some structure; they don’t occur wildly
 */
class UseTemplate {

    /**
     * The groovy.text package defines multiple template engines. These engines (the
     * name factory would better reveal their purpose) have createTemplate methods that
     * read the template’s raw text from an input source (String, Reader, File, or URL) and
     * return a Template object
     */


    static void main(String[] args) {
        def mailReminder = '''
                Dear ${salutation?salutation+' ':''}$lastname,
                another month has passed and it's time for these
                <%=tasks.size()%> tasks:
                <% tasks.each { %>- $it
                <% } %>
                your collaboration is very much appreciated
            '''
        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(mailReminder)
        def binding  = [
                salutation: 'Mrs.',
                lastname: 'Davis',
                tasks:['visit the Groovy in Action (GinA) page',
                'see my doc']
        ]



        println template.make(binding).toString()


    }

    /**
     * groovy.text包下的markup包下包含五种不同的template引擎
     * 1. SimpleTemplateEngine:
     * 2.StreamingTemplateEngine:具有同等功能的simpletemplate引擎而是用写封更可扩展的模板创建
     对于大模板。特别是，这个模板引擎可以处理大于64000的字符串，这会给其他Groovy模板引擎带来问题
     * 3.GStringTemplateEngine: 以可写闭包方式保存模板，可能为大型模板和无状态流场景提供更好的性能和可伸缩性
     *
     * 4.XmlTemplateEngine:优化模板的原始文本和由此产生的
     文本都是有效的XML。它在DOM中的节点，可以提供
     漂亮的印刷效果。不像其他的引擎，它的产生依赖于系统
     换行。

     * 5.MarkupTemplateEngine:编译模板和更好的性能
     还提供了类型检查在模型中使用的属性的模板。它
     有许多好处，我们高度推荐
     *
     */

    /**
     * So far you’ve seen four ways to generate text dynamically:
     * 1.GStrings
     * 2.Formatter (with printf calls, for example)
     * 3.MarkupBuilder
     * 4.templates
     */


}
