# [Rock-Paper-Scissor](http://en.wikipedia.org/wiki/Rock-paper-scissors)

- Criteria
  - [x] Can I play Player vs Computer?
  - [x] Can I play Computer vs Computer?
  - [x] Can I play a different game each time?
  
- Scoope of Improvement
  - [ ] Very Minimal UI. [known Issue: User Input doesn't display on the console when typing]
  - [ ] Game/AI Logic.
  - [ ] Code Coverage.
    - [x] Rules (Game logic)
    - [ ] Game, GameMode, Players.
  
## Environment

- Scala version `2.12.10` (have to downgrade from `2.13.1` as there is some issues with [scoverage](https://github.com/weso/utils/issues/3))
- Sbt version `1.3.2`
- Scalafmt `2.2.0` (Rule is not specified yet)

## Execution

- Clone the repo & go to the directory
- Enter to the Game
  - `sbt run`
  - Follow then the instruction
- Run Test & Check TestReport
  - `sbt clean test` or `sbt clean coverage test`
  - Check `${repo}/src/target/test-reports/index.html`
- Run Coverage & Check
  - `sbt coverageReport`
  - Check `${repo}/src/target/scala-2.12/scoverage-report/index.html`
  