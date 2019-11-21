package game

import org.scalatest._
import game.Choice._
import  game.Result.{Win, Lost, Draw}

class RulesTestSuite extends FunSuite with Matchers {
    test("Human(Rock) & Computer(Scissor) Loss should Pass") {                       
        Rules.pickWinner(Rock, Scissor) shouldBe Win
    }
    test("Human(Rock) & Computer(Paper) Loss should Pass") {               
        Rules.pickWinner(Rock, Paper) shouldBe Lost
    }
    test("Human(Scissor) & Computer(Paper) Loss should Pass") {               
        Rules.pickWinner(Scissor, Paper) shouldBe Win
    }
    test("Human(Scissor) & Computer(Rock) Loss should Pass") {               
        Rules.pickWinner(Scissor, Rock) shouldBe Lost
    }
    test("Human(Paper) & Computer(Rock) Loss should Pass") {               
        Rules.pickWinner(Paper, Rock) shouldBe Win
    }
    test("Human(Paper) & Computer(Scissor) Loss should Pass") {               
        Rules.pickWinner(Paper, Scissor) shouldBe Lost
    }
    test("Human(Paper) & Computer(Paper) returns Draw result should Pass") {               
        Rules.pickWinner(Paper, Paper) shouldBe Draw
    }
    test("Human(Rock) & Computer(Rock) returns Draw result should Pass") {               
        Rules.pickWinner(Rock, Rock) shouldBe Draw
    }
    test("Human(Scissor) & Computer(Scissor) returns Draw result should Pass") {               
        Rules.pickWinner(Scissor, Scissor) shouldBe Draw
    }
}