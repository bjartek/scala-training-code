package scalaexamples.companionobject

// Define a primary constructor which takes a list of passengers (String) and an Option conductor also String
class Train(val passengers:List[String], val conductor: Option[String]) {

  def this(passengers:List[String]) = this(passengers, None)
}

object Train {

  def apply(passengers: Array[String]) = new Train(passengers.toList)

  def apply(passengers: String*) = new Train(passengers.toList)

  def apply(conductor: Option[String], passengers: String*) = new Train(passengers.toList, conductor)
  
  
}
