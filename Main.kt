fun main() {
    val players = initialize()
    val gameInSession = takeTurn(players)
    val theWinnerIs = getWinners(gameInSession)

    if(theWinnerIs.size == 1) {
        println("The winner is ${theWinnerIs[0].name} with a score of ${theWinnerIs[0].score}")
    } else {
        print("The winners are ")
        for(eachPlayer in theWinnerIs) {
            print("${eachPlayer.name} ")
        }
        println("with a score of ${theWinnerIs[0].score}")
    }
}

fun initialize() : List<Player> {
    val playersOfTheGame = mutableListOf<Player>()

    println("How many players are playing?")
    val numberOfPlayers : Int? = readLine()?.toInt() ?: 1

    println("How many dices are each player using?")
    val numberOfDices : Int? = readLine()?.toInt() ?: 1

    println("How many sides should each die have?")
    val numberOfSides : Int? = readLine()?.toInt() ?: 1

    for(eachPlayer in 1..numberOfPlayers!!) {
        println("Player name: ")
        val playerName = readLine() ?: "New Player"

        val newPlayer = Player(
                name = playerName
        )
        for(eachDie in 1..numberOfDices!!) {
            newPlayer.addDie(numberOfSides!!)
        }
        playersOfTheGame.add(newPlayer)
    }
    return playersOfTheGame
}

fun takeTurn(players : List<Player>) : List<Player> {
    val gameLength = 5
    var currentTurn = 1

    while(currentTurn <= gameLength) {
        for(eachPlayer in players) {
            println("Turn $currentTurn")
            println("Player ${eachPlayer.name} guess your total roll:")
            val guess : Int = readLine()?.toInt() ?: 0
            val roll : Int = eachPlayer.sumOfDice()
            println("${eachPlayer.name} guessed $guess and rolls a total of $roll")
            if(guess == roll) {
                println("Amazing! You guessed correct")
                eachPlayer.increaseScore()
                println("Your total score is now ${eachPlayer.score}")
            } else {
                println("Too bad, you guessed incorrectly")
                println("Your total score is now ${eachPlayer.score}")
            }
        }
        currentTurn++
    }
    return players
}

fun getWinners(players: List<Player>) : List<Player> {
    val winner = mutableListOf<Player>()
    val highScore = players.maxOfOrNull { it.score }

    for(eachPlayer in players) {
        if(eachPlayer.score == highScore) {
            winner.add(eachPlayer)
        }
    }

    return winner
}
