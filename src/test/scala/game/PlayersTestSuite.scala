package game

import org.scalatest._

import java.io.ByteArrayOutputStream

class PlayersTestSuite extends FunSuite with Matchers {

  test("Player - Human pick the choice Rock") {
    new Human
    new ByteArrayOutputStream()
    // withOut(readInput) {
    //     withIn(new StringReader(userInput)) {
    //         Paper
    //     }
    // }
    pending
  }
}
