package com.ktjr.ktwd.groovy.ch09

import org.codehaus.groovy.ast.ClassHelper
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.expr.ArgumentListExpression
import org.codehaus.groovy.ast.expr.ConstructorCallExpression
import org.codehaus.groovy.ast.stmt.ReturnStatement
import org.codehaus.groovy.control.CompilePhase

/**
 * Created by forker
 * on 2017/9/28.
 */
def ast = new ReturnStatement(
        new ConstructorCallExpression(
                ClassHelper.make(Date),
                ArgumentListExpression.EMPTY_ARGUMENTS
        )
)
assert ast instanceof ReturnStatement


def approxPI = 3.14G
def ast3 = new AstBuilder().buildFromString(
        CompilePhase.CLASS_GENERATION,
        false,
        "static double getTwoPI(){ def pi = $approxPI ; pi * 2}"
)
assert ast3[1] instanceof  ClassNode
def method = ast3[1].methods.find{
    it.name == 'getTwoPI'
}
assert method instanceof MethodNode

/**
 * The last approach is possibly the most interesting:
 *
 * buildFromCode()
 */
def ast4 = new AstBuilder().buildFromCode {
    new Date()
}

/**
 * The main disadvantage is
 that the Groovy compiler will validate your input
 * For instance, you cannot declare a new class within a closure body,
 * so declaring a new class (or method) using buildFromCode() isn’t allowed.
 * Also, there’s no way to bind in data from the enclosing context.
 * The new Date() expression here is only executed at runtime
 */
assert  ast4[0].statements[0] instanceof ReturnStatement





