package game

// Game Rules

object Rules {
    
    import Choice._
    import Result._
    
    // Game Rules & Result
    def pickWinner(ch1: Choice, ch2: Choice): Result = {
        (ch1, ch2) match {
            case (Rock, Scissor) => Win
            case (Rock, Paper) => Lost
            case (Scissor, Paper) => Win
            case (Scissor, Rock) => Lost
            case (Paper, Rock) => Win
            case (Paper, Scissor) => Lost
            case _ => Draw
        }
    }
}


