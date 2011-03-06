package scalaexamples.inheritance

// Subclass the Rectangle
class Square(size: Double, color:String) extends Rectangle(size, size, color) {
  
  def this(size:Double) = this(size, Shape.DefaultColor)
  // Create an auxiliary constructor
  
  // Override the area method

}
