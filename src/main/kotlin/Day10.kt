import java.math.BigInteger

class Day10 {

    private val roundPoints = 3
    private val squarePoints = 57
    private val curlyPoints = 1197
    private val anglePoints = 25137


    private fun parseLine(line: String) : Char {
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

    fun part1(input: List<String>): Int {


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

    private fun autoComplete(line: String) : BigInteger {
        val list = mutableListOf<Char>()
        for (c in line) {
            when (c) {
                '(' -> list.add(c)
                '[' -> list.add(c)
                '{' -> list.add(c)
                '<' -> list.add(c)
                ')' -> list.removeLast()
                ']' -> list.removeLast()
                '}' -> list.removeLast()
                '>' -> list.removeLast()
            }
        }

        var score = BigInteger.ZERO
        for (c in list.reversed()) {
            score *= BigInteger.valueOf(5)
            when(c) {
                '(' -> score += BigInteger.ONE
                '[' -> score += BigInteger.valueOf(2)
                '{' -> score += BigInteger.valueOf(3)
                '<' -> score += BigInteger.valueOf(4)
            }
        }

        return score
    }

    fun part2(input: List<String>): BigInteger {
        var incompleteInput = mutableListOf<String>()
        for(line in input) {
            if (parseLine(line) == ' ')
                incompleteInput.add(line)
        }

        val scores = mutableListOf<BigInteger>()

        for (line in incompleteInput) {
            scores.add(autoComplete(line))
        }

        val index = (scores.size - 1) / 2
        return scores.sorted()[index]
    }

}

fun main() {
    val day = Day10()
    val inp = readInput("Day10")
    println(day.part1(inp))
    println(day.part2(inp))

}