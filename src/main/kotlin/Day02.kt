class Day02 {
    fun part1(input: List<String>): Pair<Int, Int> {
        var position = Pair(0, 0);

        for (i in input) {
            val line = i.split(" ")
            if (line[0] == ("forward")) {
                position = Pair(position.first + line[1].toInt(), position.second)
            } else if (line[0] == "up") {
                position = Pair(position.first, position.second - line[1].toInt())
            } else if (line[0] == "down") {
                position = Pair(position.first, position.second + line[1].toInt())
            }
        }

        println(position.first * position.second)
        return position;
    }

    fun part2(input: List<String>): Pair<Int, Int> {
        var position = Pair(0, 0);
        var aim = 0
        for (i in input) {
            val line = i.split(" ")
            if (line[0] == ("forward")) {
                Pair(position.first + line[1].toInt(), position.second - (line[1].toInt() * aim)).also {
                    position = it
                }
            } else if (line[0] == "up") {
                aim += line[1].toInt()
            } else if (line[0] == "down") {
                aim -= line[1].toInt()
            }
        }

        println(position.first * position.second)
        return position;
    }
}

fun main() {
    val day = Day02()
    val input = readInput("Day02_test")
    day.part1(input)
    day.part2(input)
}