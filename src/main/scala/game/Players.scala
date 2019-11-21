package game

import scala.util.{Try, Success, Failure}
import scala.util.Random
import scala.io.StdIn._

import game.Choice.{Rock, Paper, Scissor}

// Players
sealed trait Players
    
// Human
case class Human() extends Players {
    private val mapUserInputWithChoice = Map('r' -> Rock, 'p' -> Paper, 's' -> Scissor)    
    
    /* 
     Enter User Input from the List of choice and then user input ll match with Choice Object
     ** Need to refactor; To avoid sideeffect
    */

    // def userInput: Char => Choice = chr => {  
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
case class Computer() extends Players {
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