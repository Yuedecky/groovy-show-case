package com.ktjr.ktwd.groovy.ch01

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.AnnotationNode
import org.codehaus.groovy.ast.ClassHelper
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation

/**
 * Created by forker
 * on 2017/9/28.
 */
class MainTransformation implements ASTTransformation {
    private NO_EXCEPTIONS = ClassNode.EMPTY_ARRAY
    private STRING_ARRAY = ClassHelper.STRING_TYPE.makeArray()
    @Override
    void visit(final ASTNode[] nodes, final SourceUnit source) {

        if (astNodes?.size() != 2) return
        if (!(astNodes[0] instanceof AnnotationNode)) return
        if (astNodes[0].classNode.name != Main.name) return
        if (!(astNodes[1] instanceof MethodNode)) return

        def targetMethod = astNodes[1]
        def targetClass = targetMethod.declaringClass
        def targetInstance = ctorX(targetClass)
        def callTarget = callX(targetInstance, targetMethod.name)
        def mainBody = block(stmt(callTarget))
        def visibility = ACC_STATIC | ACC_PUBLIC
        def parameters = params(param(STRING_ARRAY, 'args'))
        targetClass.addMethod('main', visibility,
                VOID_TYPE, parameters, NO_EXCEPTIONS, mainBody)

    }
}
