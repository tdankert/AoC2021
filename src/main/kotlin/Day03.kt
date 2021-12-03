class Day03 {
    fun part1(input: List<String>): Int {
        var gamma = ""
        var epsilon = ""

        val bitsLength = input[0].length

        for (i in 0..bitsLength-1) {
            var ones = 0
            var zeros = 0

            for (inp in input) {

                if (inp[i].equals('0')) {
                    zeros += 1
                } else {
                    ones += 1
                }
            }

            if (zeros > ones) {
                gamma += "0"
                epsilon += "1"
            } else {
                gamma += "1"
                epsilon += "0"
            }
        }
        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun part2(input: MutableList<String>): Int {
        val bitsLength = input[0].length

        fun oxygenRating() : Int{
            var entries = input

            for (i in 0..bitsLength-1) {

                var ones = 0
                var zeros = 0

                for (inp in entries) {

                    if (inp[i].equals('0')) {
                        zeros += 1
                    } else {
                        ones += 1
                    }
                }

                val most = if (ones>zeros || ones == zeros) {
                    '1'
                } else {
                    '0'
                }
                var tempList = mutableListOf<String>()
                for (inp in entries) {
                    if (inp[i].equals(most)) {
                        tempList.add(inp)
                    }
                }
                entries = tempList
            }

            return entries.first().toInt(2)
        }

        fun cO2Rating() :Int {
            var entries = input

            for (i in 0..bitsLength-1) {

                if (entries.size == 1)
                    break
                var ones = 0
                var zeros = 0

                for (inp in entries) {

                    if (inp[i].equals('0')) {
                        zeros += 1
                    } else {
                        ones += 1
                    }
                }

                val least = if (ones<zeros) {
                    '1'
                } else {
                    '0'
                }
                var tempList = mutableListOf<String>()
                for (inp in entries) {
                    if (inp[i].equals(least)) {
                        tempList.add(inp)
                    }
                }
                entries = tempList


            }

            return entries.first().toInt(2)
        }

        println(oxygenRating())
        return oxygenRating() * cO2Rating()
    }
}

fun main() {
    val day = Day03()
    val input = readInput("Day03")
    println(day.part1(input))
    println(day.part2(input))
}