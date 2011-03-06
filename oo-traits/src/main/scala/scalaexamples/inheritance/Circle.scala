package scalaexamples.inheritance

import scala.math._

// Make Circle extend Shape, and add a primary constructor for radius and color
class Circle(radius: Double, color: String) extends Shape(color) {

  def this(radius:Double) = this(radius, Shape.DefaultColor)

  def area = Pi * radius * radius
  def circumference = 2 * Pi * radius
  
}
