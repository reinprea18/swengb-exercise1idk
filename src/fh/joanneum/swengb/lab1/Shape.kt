package fh.joanneum.swengb.lab1

import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Test

open class Shape(val color:String = "black") {
    open fun getArea(): Double {
        return 0.0
    }
}

fun main() {
    val testShape = Shape()
    println(testShape.color)

    val testRectangle = Rectangle(width = 5.0, length = 2.0 )
    println(testRectangle.getArea())
    testRectangle.length

    val circle1 = Circle(radius = 10.0, color = "red")
    println(circle1)
    val circle2 = Circle(radius = 10.0, color = "red")
    println(circle2)

    println(circle1===circle2)
    println(circle1==circle2)
    println(setOf<Circle>(circle1, circle2).size)

    val canvas = Canvas()
    canvas.addShape(Rectangle("white", width = 5.0, length = 2.0))
    canvas.addShape(Circle("red", radius = 1.0))
    println(canvas.getTotalArea()) //  13.14
}

class Rectangle(color:String = "black", val width:Double = 1.0, val length:Double = 1.0): Shape(color){
    override fun getArea(): Double {   // make use of smart completion in IntelliJ (Alt+Enter), Ctrl+Space
        return width * length
    }
}

class Circle(color:String = "black", val radius:Double = 1.0): Shape(color){
    override fun getArea(): Double {
        return radius*radius*Math.PI


    }
    override fun toString(): String {
        return "Circle(radius=$radius, color=$color)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Circle

        if (radius != other.radius) return false

        return true
    }

    override fun hashCode(): Int {
        return radius.hashCode()
    }

}

class Canvas() {
    private var shapes = mutableListOf<Shape>()

    fun addShape(shape: Shape) {
        shapes.add(shape)
    }

    fun getTotalArea(): Double {
        return shapes.sumByDouble { it.getArea() }
    }
        fun shapesCountPerType(): Map<String, Int> {
            return shapes.groupingBy { it.javaClass.simpleName }.eachCount()
        }
    }





