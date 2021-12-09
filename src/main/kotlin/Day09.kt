class Day09 {

    fun part1(input: Array<IntArray>): Int {

        fun isLowPoint(x: Int, y: Int): Boolean {
            val value = input[x][y]

            if (x > 0 && input[x-1][y] <= value)
                return false
            if (x < input.size - 1 && input[x+1][y] <= value)
                return false
            if (y > 0 && input[x][y-1] <= value)
                return false
            if (y < input.first().size - 1 && input[x][y+1] <= value)
                return false
            return true
        }

        var riskLevel = 0

        for (line in input.indices) {
            for (value in input[line].indices) {
                val valu = input[line][value]
                if (isLowPoint(line, value) ) {
                    riskLevel += input[line][value] + 1
                    print(ANSI_GREEN  + valu)
                } else
                    print(ANSI_RED + valu)
            }
            println()
        }

        return riskLevel
    }

    fun part2(input: List<String>): Int {

        return 0
    }

}

fun main() {
    val day = Day09()
    val inp = readIntArray("Day09")
//    for (line in inp)
//        println(line.first())
//    var input = readInput("Day09")
    println(day.part1(inp))
//    println(day.part2(input))

}