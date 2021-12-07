import kotlin.math.sqrt

class Day07 {

    fun part1(input: MutableList<Int>): Int {

        fun diff(a: Int, b: Int): Int {
            val x = a.toDouble()
            val y = b.toDouble()
            return sqrt((x-y)*(x-y)).toInt()
        }

        var dists = input.sorted()
        println(dists)

        val lowest = dists.first()
        val highest = dists.last()

        var lowerdist = Int.MAX_VALUE
        for (position in lowest..highest) {
            var curDist = 0
            for (crab in dists) {
                curDist += diff(position, crab)
            }
            if (curDist < lowerdist) {
                lowerdist = curDist
            }
        }

        return lowerdist
    }

    /**
     * a very naive approach
     */
    fun part2(input: List<Int>): Int {
        fun diff(a: Int, b: Int): Int {
            val x = a.toDouble()
            val y = b.toDouble()
            val dist = sqrt((x-y)*(x-y)).toInt()

            var list = mutableListOf<Int>()
            for (i in 0..dist)
                list.add(i)
            return list.sum()
        }

        var dists = input.sorted()
        println(dists)

        val lowest = dists.first()
        val highest = dists.last()

        var lowerdist = Int.MAX_VALUE
        for (position in lowest..highest) {
            var curDist = 0
            for (crab in dists) {
                curDist += diff(position, crab)
            }
            if (curDist < lowerdist) {
                lowerdist = curDist
            }
        }

        return lowerdist
    }
}

fun main() {
    val day = Day07()
    var input = readIntInputOneLine("Day07")
    println(day.part1(input))
    input = readIntInputOneLine("Day07")
    println(day.part2(input))

}