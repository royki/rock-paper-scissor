package game

import scala.io.StdIn._

import Rules._
import Result._

class ComputerVsHuman {

  val user = new Human
  val bot = new Computer

  var gamesPlayed = 0
  def play(numGamesToPlay: Int) = {
    println("""
              |Start the Game 
              |Rock-Paper-Scissor
                """.stripMargin)
    while (gamesPlayed < numGamesToPlay) {
      val userChoice = user.choice
      val botChoice = bot.choice
      val matchResult = pickWinner(userChoice, botChoice)
      matchResult match {
        case Win =>
          println(
            s"${Console.GREEN}Player Won ${Console.RESET}, ${Console.RED}Computer Lost ${Console.RESET}"
          )
          println("=========================")
        case Lost =>
          println(
            s"${Console.GREEN}Computer Won ${Console.RESET}, ${Console.RED}Player Lost ${Console.RESET}"
          )
          println("=========================")
        case Draw =>
          println(s"${Console.YELLOW}Match Draw ${Console.RESET}")
          println("=========================")

      }
      gamesPlayed += 1
    }
    println("See you next time")
    gamesPlayed = 0
  }
}

class ComputerVsComputer {
  val computer1 = new Computer
  val computer2 = new Computer

  var gamesPlayed = 0
  def play(numGamesToPlay: Int) = {
    println("""
              |Start the Game 
              |Rock-Paper-Scissor
                """.stripMargin)
    while (gamesPlayed < numGamesToPlay) {
      pickWinner(computer1.choice, computer2.choice) match {
        case Win =>
          println(
            s"${Console.GREEN}Computer-1 Won ${Console.RESET}, ${Console.RED}Computer-2 Lost ${Console.RESET}"
          )
          println("==============================")
        case Lost =>
          println(
            s"${Console.GREEN}Computer-2 Won ${Console.RESET}, ${Console.RED}Computer-1 Lost ${Console.RESET}"
          )
          println("==============================")
        case Draw =>
          println(s"${Console.RED}Match Draw ${Console.RESET}")
          println("==============================")
      }
      gamesPlayed += 1
    }
    println("See you next time")
    gamesPlayed = 0
  }
}
