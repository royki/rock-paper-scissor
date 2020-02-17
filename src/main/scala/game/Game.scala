package game

import scala.io.StdIn._

class GameModes {
    def numberOfTimeToPlay: Int => Int = num =>  num
    // Game Mode
    def gameModes: Int => Unit = i => i match {
        case 1 => 
                    println(s"${Console.RED}Enter Number of times Computers'll play together${Console.RESET}")                    
                    val manVsbot = new ComputerVsHuman
                    manVsbot.play(numberOfTimeToPlay(readInt))
        case 2 => 
                    println(s"${Console.RED}Enter Number of times Computers'll play together${Console.RESET}")                    
                    val botVsbot = new ComputerVsComputer
                    botVsbot.play(numberOfTimeToPlay(readInt))
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