package com.ktjr.ktwd.groovy.ch02

import sun.security.provider.SHA

/**
 * Created by forker on 2017/9/25.
 */
class VisitorPattern {

    static class Drawing{
        List shapes
        def accept(Closure yield){
            shapes.each {it.accept(yield)}
        }
    }

    static class Shape{
        def accept(Closure yield){
            yield(this)
        }
    }
    static class Square extends Shape{
        def width
        def area(){
            width ** 2
        }
    }

    static class Circle extends Shape{
        def radius
        def area(){
            Math.PI*radius**2
        }

    }

    static void main(args){
        def picture = new Drawing(shapes: [new Square(width: 12),
            new Circle(radius: 23)])
        def totalArea = 0
        picture.accept {
            totalArea += it.area()
        }
        println "The shapes in this drawing cover an area of $totalArea units."


        println "The individual contributions are:"
        picture.accept {
            println "${it.class.name}:${it.area()}"
        }

    }
}
