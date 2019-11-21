package game

// Choice of Move
sealed abstract class Choice

object Choice {
    case object Rock extends Choice
    case object Paper extends Choice
    case object Scissor extends Choice
}