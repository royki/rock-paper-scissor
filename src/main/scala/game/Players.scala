package game

import scala.util.{Try, Success, Failure}
import scala.util.Random
import scala.io.StdIn._

import game.Choice.{Rock, Paper, Scissor}

trait PickChoice {
    def choice: Choice
}
    
// Human
class Human {
    private val mapUserInputWithChoice = Map('r' -> Rock, 'p' -> Paper, 's' -> Scissor)    
       
    def choice: Choice = {             
        var validChoice = Option.empty[Choice]
        println(s"${Console.GREEN}Pick a Sign: Rock, Paper or Scissor")
        while(validChoice.isEmpty) {
            validChoice = Try(readChar) match {
                case Success(value) if mapUserInputWithChoice.contains(value.toLower) => {
                    val humanChoice = mapUserInputWithChoice.get(value.toLower)
                    println(s"User Sign $humanChoice")
                    humanChoice
                }
                case _ => 
                    println(s"Pick again a ${Console.RED}Valid ${Console.RESET} Sign")
                    Option.empty[Choice]
            }
        }
        validChoice.head
    }
}

// Computer/AI/Bot
class Computer {
     /* 
        Minimal Logic
        Computer Moves, 
        Randomly selects from sequence of choice
    */
     private val allChoice = List(Rock, Paper, Scissor)
     def choice: Choice = {
         val random = new Random
         val computerChoice = allChoice(random.nextInt(allChoice.size)) 
         println(s"Computer Sign is $computerChoice")       
         computerChoice
     }
}