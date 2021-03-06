package game

import scala.io.StdIn._

import Rules._
import Result._

sealed trait GameMode {
    def play
}

class ComputerVsHuman extends GameMode {

    val user = new Human
    val bot = new Computer
    
    def play = {
        println("""
                |Start the Game 
                |Rock-Paper-Scissor
                """.stripMargin)                        
                val userChoice = user.choice      
                val botChoice = bot.choice
                val matchResult = pickWinner(userChoice, botChoice)
                matchResult match {
                    case Win => println("Player Won, Computer Lost")
                    case Lost => println("Computer Won, Player Lost")
                    case Draw => println(s"${Console.RED}Match Draw ${Console.RESET}")
                } 
        println("See you next time")
    }    
}

case class ComputerVsComputer(numGamesToPlay: Int) extends GameMode {
    val computer1 = new Computer
    val computer2 = new Computer

    var gamesPlayed = 0
    def play = {
        println("""
                |Start the Game 
                |Rock-Paper-Scissor
                """.stripMargin)
        while(gamesPlayed < numGamesToPlay) {
            pickWinner(computer1.choice, computer2.choice) match {
                case Win => println(s"${Console.GREEN}Computer1 Won, Computer2 Lost ${Console.RESET}")
                case Lost => println(s"${Console.GREEN}Computer2 Won, Computer1 Lost ${Console.RESET}")
                case Draw => println(s"${Console.RED}Match Draw ${Console.RESET}")                            
            }            
            gamesPlayed += 1
        }
        println("See you next time")
        gamesPlayed = 0
    }
}