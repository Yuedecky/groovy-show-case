package com.ktjr.ktwd.groovy.ch09

import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.ast.stmt.ReturnStatement

/**
 * The AstBuilder is a convenient shortcut
 * for writing shorter, more concise AST
 */
def ast = new AstBuilder().buildFromSpec {
    returnStatement {
        constructorCall(Date){
            argumentList {}
        }
    }
}

assert ast[0] instanceof ReturnStatement

/**
 *
 * The AstBuilder object has a buildFromString method that converts Groovy source
 code into the corresponding AST. By default it compiles the code to the class-generation
 phase and returns only the AST for the enclosed script, not any classes defined within the
 script.
 */

def ast2 = new AstBuilder().buildFromString('new Date()')

assert ast2[0] instanceof BlockStatement

assert ast2[0].statements[0] instanceof  ReturnStatement
