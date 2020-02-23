# [Rock-Paper-Scissor](http://en.wikipedia.org/wiki/Rock-paper-scissors)

- Game
  - [x] Can I play Player vs Computer?
  - [x] Can I play Computer vs Computer?
  - [] Can I play a different game each time?
  
- Scoope of Improvement
  - [ ] Very Minimal UI. [known Issue: User Input doesn't display on the console when typing]
  - [ ] Game/AI Logic.
  - [ ] Code Coverage.
    - [x] Rules (Game logic)
    - [ ] Game, GameMode, Players.
  
## Environment

- Scala version `2.12.10`
- Sbt version `1.3.2`
- Scalafmt `2.2.0`
- Scalafx `0.9.11`

## Execution in Local

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
- Format Code
  - `sbt scalafmt`
  - `sbt test:scalafmt`
- Fix Code
  - `sbt scalafix`
- Generate Documentation
  - `scaladoc src/main/scala/game/*`
  
## Using Docker Container

### Build Docker Image (Mandatory)
  
- `docker build -t IMAGE_NAME:TAG -f path/to/Dockerfile CONTEXT_NAME(Optional)`
- example: `docker build -t rps:v1 -f $(pwd)/rock-paper-scissor/Dockerfile rock-paper-scissor`

## Create Container from the Image & Enter to the container directly

- `docker run -it --name game_1 -v $(pwd)/sharedDoc:/sharedDoc rps:v1`
- Start game
  - `sbt run`
- Generate test result in shared directory in the host
  - `sbt clean coverage test`
  - Check Test Report in Host `${pwd}/src/target/test-reports/index.html`
- Generate Coverage Report
  - `sbt coverageReport`
  - Check Coverage Report in Host `${pwd}/src/target/scala-2.12/scoverage-report/index.html`
- Generate Documentation & access from host directory named *sharedDoc*
  - `scaladoc src/main/scala/game/* -d /sharedDoc`
- Or Create Container from the Image & Enter to the container & Start the game directly
  - `docker run -it --name game_1 -v $(pwd)/sharedDoc:/sharedDoc rps:v1 sbt run`
- Delete Containers
  - `docker rm $(docker ps -aq)`

## Using Docker-compose

- `docker-compose run game`
- Start game
  - `sbt run`
- Generate test result in shared directory in the host
  - `sbt clean coverage test`
  - Check Test Report in Host `${pwd}/src/target/test-reports/index.html`
- Generate Coverage Report
  - `sbt coverageReport`
  - Check Coverage Report in Host `${pwd}/src/target/scala-2.12/scoverage-report/index.html`
- Delete Containers
  - `docker-compose down`
  - `docker rm $(docker ps -aq)`

### Example of the Game Console

```console
Please choose the game mode you want to play:
1) Human Vs Computer
2) Computer Vs Computer
>
1
Enter Number of times Computers'll play together
5

Start the Game
Rock-Paper-Scissor

Pick a Sign: R/Rock, P/Paper or S/Scissor
=========================================
Rock
Computer Won , Player Lost
=========================
Pick a Sign: R/Rock, P/Paper or S/Scissor
=========================================
P
Computer Won , Player Lost
=========================
Pick a Sign: R/Rock, P/Paper or S/Scissor
=========================================
Paper
Computer Won , Player Lost
=========================
Pick a Sign: R/Rock, P/Paper or S/Scissor
=========================================
R
Player Won , Computer Lost
=========================
Pick a Sign: R/Rock, P/Paper or S/Scissor
=========================================
scissor
Computer Won , Player Lost
=========================
See you next time

*Or 2nd Option for Computer vs Computer*

Please choose the game mode you want to play:
1) Human Vs Computer
2) Computer Vs Computer
>
2
Enter Number of times Computers'll play together
10

Start the Game
Rock-Paper-Scissor

Computer-2 Won , Computer-1 Lost
==============================
Computer-2 Won , Computer-1 Lost
==============================
Computer-2 Won , Computer-1 Lost
==============================
Computer-2 Won , Computer-1 Lost
==============================
Match Draw
==============================
Match Draw
==============================
Computer-1 Won , Computer-2 Lost
==============================
Computer-2 Won , Computer-1 Lost
==============================
Computer-2 Won , Computer-1 Lost
==============================
Computer-2 Won , Computer-1 Lost
==============================
See you next time

```
