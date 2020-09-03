class Player (
    var name : String ="",
    var score : Int = 0,
    var listOfDie : MutableList<Die> = mutableListOf()
) {
    fun rollDie() : Int {
        //roll all dices
        var dieScore : Int = 0

        for(rollingDie in listOfDie) {
            var newRoll = rollingDie.roll()
//            println("each roll: $newRoll")
            dieScore += newRoll
//            println("total in rollDie(): $dieScore")
        }
//        println("dieScore in rollDie(): $dieScore")
        return dieScore
    }

    fun sumOfDice() : Int {
        //add all die values together - return as an Int
        var totalSum : Int = rollDie()
        //totalSum = rollDie()
        //println("total sum: $totalSum")
        return totalSum
    }

    fun increaseScore() : Int {
        //increase the score of the player with 1
        return score++
    }

    fun addDie(selectedNumberOfSides : Int) {
        //create a new die with *Die.sides* and add it to the player
        var newDie = Die(sides = selectedNumberOfSides)
        listOfDie.add(newDie)
    }
}