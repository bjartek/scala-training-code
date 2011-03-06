package scalaexamples.quiz

import xml._

/**
 * This class parses the xml from a file.
 */
class XmlQuizProvider(file: String) extends QuizProvider {

  def quiz = {
     val xmlFromFile = XML.load(getClass.getClassLoader.getResourceAsStream(file))
     parseXml(xmlFromFile)
  } 

  private def parseXml(xml: Elem): Quiz = {
    
    val title = (xml \ "title").text
    val questions = (xml \\ "item").map(item =>generateQuestions(item)).toList
    Quiz(title, questions)

  }

  def generateQuestions(node:NodeSeq) = {
    val title = (node \ "question").text
    val answers = (node \ "option").map(option => Answer(option.text, isCorrectAnswer(option))).toList
    Question(title, answers)
  }

  def isCorrectAnswer(node:Node) = node.attribute("correct").map(_.text == "y").getOrElse(false)
  
}
