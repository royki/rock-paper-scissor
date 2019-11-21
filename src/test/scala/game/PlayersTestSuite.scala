package game

import org.scalatest._
import scala.Console._

import java.io.{ByteArrayOutputStream, StringReader}
import game.Choice.{Rock, Paper, Scissor}

class PlayersTestSuite extends FunSuite with Matchers {
    private val userInput:String = "Rock"
    test("Player - Human pick the choice Rock") {
        val user = Human
        val readInput = new ByteArrayOutputStream()
        // withOut(readInput) {
        //     withIn(new StringReader(userInput)) {
        //         Paper
        //     }
        // }
        pending
    }
}