fun main() {
    // Range of ranges to check. Defaults checks [1,2,3] up to and including [1,2,3,...,98,99,100]
    var lowerBound = 3
    val upperBound = 1000

    // Use this if you would prefer to type in the lower and upper bound in console. Don't forget to also change upperBound to a var then
//    lowerBound = readLine()!!.toInt()
//    upperBound = readLine()!!.toInt()

    // Keep track of the min and max amount of shuffles in the range indicated above.
    var max = 0
    var min = Int.MAX_VALUE
    while (lowerBound <= upperBound) {
        //Create a mutable and a non-mutable list of all ints up to the lowerBound. The original is to check the changing list against.
        val range = (1..lowerBound)
        val original = range.toList()
        val changing = range.toMutableList()
        //I'm keeping in a bunch of commented code to check different outputs. For example, seeing the original ordered list.
//        println("0: $original")
        var index = 0
        // Shuffle the deck until it is the same as the original. Do{..}while() because the two lists are the same before the first shuffle.
        do {
            shuffleOnce(changing)
            //Keep track of the amount of shuffles
            index++
//            println("$index: $changing")
        } while (original != changing)
        // Use this to find all cases where n(cards) = n(shuffles) + 1
//        if (upperBound == index + 1) { }
        //Pretty output
        println("Cards: $lowerBound - Shuffles: $index")
        //Not so pretty output
//        print("$index ")
        //Keep track of min and max values of shuffles
        if (index > max) {
            max = index
        }
        if (index < min) {
            min = index
        }
        lowerBound++
    }
    //Print the min and max amount of shuffles in the range.
//    println("Min: $min - Max: $max")
}

//Shuffle the cards badly.
// As in, imagine a noob in shuffling only ever taking the top and bottom card from the deck in their right hand
// and putting them in their left hand. Then repeating this action until the deck is gone,
// each time putting the top-bottom pair on top of the pile in their left hand.
fun shuffleOnce(cards: MutableList<Int>) {
    var index = 0
    while (index < cards.lastIndex / 2) {
        cards.add(index++ * 2 + 1, cards.removeLast())
        //Print the changing permutation of cards. It's best to do this only when the lowerBound and upperBound aren't very far apart.
//        println("$cards: $index")
    }
}