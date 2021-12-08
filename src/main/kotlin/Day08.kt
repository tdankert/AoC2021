import kotlin.math.sqrt

class Day08 {

    fun part1(input: List<String>): Int {

        var counter = 0
        for (entry in input) {
            var digits = entry.split("|").last().trim().split(" ")
            for (digit in digits) {
                val size = digit.length
                if (size == 2 || size == 3 || size == 4 || size == 7 ) {
                    counter += 1
                }
            }
        }
        return counter
    }

    /**
     * a very naive approach
     */
    fun part2(input: List<String>): Int {
        return 0
    }
}

fun main() {
    val day = Day08()
    var input = readInput("Day08")
    println(day.part1(input))
    println(day.part2(input))

}