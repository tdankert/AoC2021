class Day01 {
    fun part1(input: List<Int>): Int {
        var counter = 0
        for (i in input.indices) {
            if (i > 0 && input[i] > input[i-1]) {
                counter += 1
            }
        }
        return counter
    }

    fun part2(input: List<Int>): Int {

        fun sum(index: Int): Int {
            var output = input[index]
            if (index > 0)
                output += input[index-1]
            if (index < input.size - 1)
                output += input[index+1]

            return output
        }

        var counter = 0
        for (i in 2..input.size-2) {

            if(sum(i) > sum(i-1)) {
                counter += 1
            }
        }

        return counter
    }

}

fun main() {
    val day = Day01()
    val input = readIntInput("Day01")
    println(day.part1(input))
    println(day.part2(input))
}