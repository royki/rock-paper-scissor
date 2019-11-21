package game

import scala.io.StdIn._

class GameModes {
    // Game Mode
    def gameModes: Int => Unit = i => i match {
        case 1 => 
                    val manVsbot = new ComputerVsHuman
                    manVsbot.play
        case 2 => 
                    println(s"${Console.RED}Enter Number of times Computers'll play together${Console.RESET}")
                    def numberOfTimeToPlay: Int => Int = num =>  num
                    val botVsbot = ComputerVsComputer(numberOfTimeToPlay(readInt))
                    botVsbot.play
        case _ => println(s"${Console.RED}Wrong Choice, Start Again${Console.RESET}")
    }    
}

object Play extends App {    
    println("""
    |Please choose the game mode you want to play:
    |1) Human Vs Computer
    |2) Computer Vs Computer
    |>""".stripMargin)
    new GameModes().gameModes(readInt)
}