fun main() {
    var upperBound = 3
    var max = 0
    var min = Int.MAX_VALUE
    while (upperBound <= 1000) {
        val range = (1..upperBound)
        val original = range.toList()
        val changing = range.toMutableList()
//        println("0: $original")

//        println(original)
        var index = 0
        do {
            shuffleOnce(changing)
            index++
//            println("$index: $changing")
        } while (original != changing)
//        if (upperBound == index + 1) {
        println("Cards: $upperBound - Shuffles: $index")
//        }
//        print("$index ")
        if (index > max) {
            max = index
        }
        if (index < min) {
            min = index
        }
        upperBound++
    }
    println("Min: $min - Max: $max")
}

fun shuffleOnce(cards: MutableList<Int>) {
    var index = 0
    while (index < cards.lastIndex / 2) {
        cards.add(index++ * 2 + 1, cards.removeLast())
//        println("$cards: $index")
    }
}