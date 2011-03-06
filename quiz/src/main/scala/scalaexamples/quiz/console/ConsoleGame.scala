package scalaexamples.quiz.console

import scalaexamples.quiz.{Answer, Question, Quiz}
import annotation.tailrec

class ConsoleGame(quiz: Quiz) {
  println("Welcome to our faboulus quiz called '" + quiz.title + "'")

  val answers = quiz.questions.map {
    question =>
      println("Question: " + question.text);
      question.answers.zipWithIndex.foreach {case (answer, index) => println((index + 1) + ". " + answer.text)}
      println("What is your answer?:")
      askQuestion(question)
  }

  val correct = answers.filter(_.correct == true).size

  println("You answered correctly on  " + correct + " of " + quiz.questions.size + " questions::")

  @tailrec
  private def askQuestion(question: Question): Answer = {
    def parseInput = try readLine.toInt - 1 catch {case _ => -1}
    val index = parseInput
    //lazy val input = try readLine.toInt - 1 catch {case _ => -1}

    if (!question.answers.isDefinedAt(index)) {
      println("Not valid input, try again!:")
      askQuestion(question)
    } else {
      question.answers(index)
    }   
  }
}
