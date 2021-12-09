class Day05 {

    fun part1(input: List<String>): Int {
        val rows = 1000
        val cols = 1000


        val arr = Array(rows) { IntArray(cols) }
//        for (row in arr) {
//            println(row.contentToString())
//        }

        fun drawLine() {

        }

        for (line in input) {
            val pointStrings = line.split(" -> ")

            val pointOne = pointStrings[0].split(",")
            val pointTwo = pointStrings[1].split(",")

            // either x or y must be equal to guarantee horizontal or vertical lines
            if (pointOne[0] == pointTwo[0]) {

            } else if (pointOne[1] == pointTwo[1]) {
                
            }
        }

        return 0
    }

    fun part2(input: List<String>): Int {
        return 0
    }
}

fun main() {
    val day = Day05()
    var input = readInput("Day05")

    var list = point(1,1).stepTo(point(1,7))
    for(ent in list) {
        println(""+ent.x + " + " + ent.y)
    }
    day.part1(input)
    day.part2(input)

}