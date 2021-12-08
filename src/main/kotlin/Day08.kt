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

    fun part2(input: List<String>): Int {
        fun digsIn(a: String, b: String) : Int {
            var counter = 0
            for (c in a) {
                if (!b.contains(c)) {
                    counter += 1
                }
            }
            return counter
        }

        var result = 0
        for (entry in input) {
            val learn = entry.split("|").first().trim().split(" ")

            var digs = MutableList<String>(10) {""}

            // Find digits by size
            digs[1] = learn.find { x -> x.length == 2 }.toString().alphabetized()
            digs[4] = learn.find { x -> x.length == 4 }.toString().alphabetized()
            digs[7] = learn.find { x -> x.length == 3 }.toString().alphabetized()
            digs[8] = learn.find { x -> x.length == 7 }.toString().alphabetized()

            // Find 6 (length 6 and one segment of 1 is not in it
            digs[6] = learn.find { x -> x.length == 6 && digsIn(digs[1],x.alphabetized()) == 1}.toString().alphabetized()
            digs[0] = learn.find { x -> x.length == 6 && digsIn(digs[4],x.alphabetized() ) == 1 && x.alphabetized() != digs[6] }.toString().alphabetized()
            digs[9] = learn.find { x -> x.length == 6 && x.alphabetized() !=  digs[0] && x.alphabetized() != digs[6] }.toString().alphabetized()


            digs[5] = learn.find { x -> x.length == 5 && digsIn(x.alphabetized(), digs[6]) == 0}.toString().alphabetized()
            digs[3] = learn.find { x -> x.length == 5 && digsIn(x.alphabetized(), digs[9]) == 0 && x.alphabetized() != digs[5] }.toString().alphabetized()
            digs[2] = learn.find { x -> x.length == 5 && x.alphabetized() !=  digs[3] && x.alphabetized() != digs[5] }.toString().alphabetized()

            // Find 0




//            println(digs)
            var digits = entry.split("|").last().trim().split(" ")

            var value = ""
            for (digit in digits) {
                for (i in 0..9) {
                    if (digs[i] == digit.alphabetized()) {
                        value += i.toString()
                    }
                }
            }
            result += value.toInt()
            println(value.toInt())
        }
        return result
    }

}

fun main() {
    val day = Day08()
    var input = readInput("Day08")
    println(day.part1(input))
    println(day.part2(input))

}