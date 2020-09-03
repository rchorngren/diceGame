import kotlin.random.Random

class Die (
    var value : Int = 1,
    var sides : Int = 1
) {
    fun roll() : Int {
        value = Random.nextInt(1, sides)
        return value
    }
}

