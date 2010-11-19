package scalaexamples.intro

class Stuff {
  override def toString = "Stuff"



  val const = "This is a constant"

  var variable = "This is a variable"

  def sayHello(dude: String ) = "Hello " + dude


  def printHello(name: String)  {
    println(sayHello(name))

  }

}

object Stuff {

  def getString() = "StuffObject"


}
