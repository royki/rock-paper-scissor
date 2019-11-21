package game

// Game Result
sealed abstract class Result

object Result {
    case object Win extends Result
    case object Lost extends Result
    case object Draw extends Result
}
