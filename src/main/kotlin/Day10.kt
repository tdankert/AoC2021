class Day10 {

    private val roundPoints = 3
    private val squarePoints = 57
    private val curlyPoints = 1197
    private val anglePoints = 25137

    fun part1(input: List<String>): Int {

        fun parseLine(line: String) : Char {
            var list = mutableListOf<Char>()
            for (c in line) {
                when (c) {
                    '(' -> list.add(c)
                    '[' -> list.add(c)
                    '{' -> list.add(c)
                    '<' -> list.add(c)

                    ')' -> {
                        if (list.removeLast() != '(') {
                            return c
                        }
                    }
                    ']' -> {
                        if (list.removeLast() != '[') {
                            return c
                        }
                    }
                    '}' -> {
                        if (list.removeLast() != '{') {
                            return c
                        }
                    }
                    '>' -> {
                        if (list.removeLast() != '<') {
                            return c
                        }
                    }
                }

            }
            return ' '
        }

        var errorScore = 0

        for (line in input) {

            when(parseLine(line)) {
                ')' -> errorScore += roundPoints
                ']' -> errorScore += squarePoints
                '}' -> errorScore += curlyPoints
                '>' -> errorScore += anglePoints
            }
        }

        return errorScore
    }

    fun part2(input: Array<IntArray>): Int {
        return 0
    }

}

fun main() {
    val day = Day10()
    val inp = readInput("Day10")
    println(day.part1(inp))
//    println(day.part2(inp))

}