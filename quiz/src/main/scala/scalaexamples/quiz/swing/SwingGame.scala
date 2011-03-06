package scalaexamples.quiz.swing

import scala.swing._
import scala.swing.Swing._
import event._
import scalaexamples.quiz.{Answer, Quiz}

class SwingGame(quiz: Quiz) extends MainFrame {
  private var currentQuestion = 0;

  val nextButton: Button = new Button("Next") {
    enabled = false
    reactions += {
      case e: ButtonClicked => {
        currentQuestion += 1;
        if (quiz.questions.size == currentQuestion) {
          val correctAnswers = questions.flatMap(_.allButtons).filter(_.isCorrect).size
          questions.flatMap(_.allButtons).foreach(_.enabled = false)
          resultLabel.text = "You answered correctly on  " + correctAnswers + " of " + quiz.questions.size + " questions.";
        } else {
          questionPanel.advanceQuestion
        }
        enabled = false
        revalidate
        SwingGame.this.repaint
      }
    }
  }

  val questions = quiz.questions.map {
    question =>
      val buttons = question.answers.map {
        ans =>
          new RadioButton(ans.text) {
            val answer = ans

            def isCorrect = answer.correct == true && peer.isSelected
            reactions += {
              case e: ButtonClicked => nextButton.enabled = true;
            }
          }
      }
      new ButtonGroup(buttons: _*)
      new BoxPanel(Orientation.Vertical) {
        val allButtons = buttons
        contents += new Label(question.text)
        contents.appendAll(buttons)

      }
  }

  val questionPanel = new BoxPanel(Orientation.Vertical) {
    contents += questions(0)
    contents += nextButton

    def advanceQuestion() = {
      contents.remove(0)
      contents.insert(0, questions(currentQuestion))
    }
  }

  size = (300, 200)
  setLocationRelativeTo(this)
  title = quiz.title
  visible = true
  val resultLabel = new Label(" ");

  contents = new BoxPanel(Orientation.Vertical) {
    contents += questionPanel
    contents += resultLabel
  }
}
