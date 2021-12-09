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
                } else if (valu == 9)
                    print(ANSI_RED + valu)
                else
                    print(ANSI_WHITE + valu)
            }
            println()
        }

        return riskLevel
    }

    fun part2(input: Array<IntArray>): Int {

        // Assumption: each region limited by 9s does only have one low point
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

        var lowpoints = mutableListOf<point>()

        var areaSizes = mutableListOf<Int>()

        for (line in input.indices) {
            for (value in input[line].indices) {
                val valu = input[line][value]
                if (isLowPoint(line, value)) {
                    lowpoints.add(point(line, value))
                }
            }
        }


        for (poin in lowpoints){
            var areaPoints = mutableListOf<point>(poin)
            var counter = 1

            fun containsPoint(entries: List<point>, p: point): Boolean {
                for (entry in entries) {
                    if (entry.x == p.x && entry.y == p.y)
                        return true
                }
                return false
            }

            var searchList = mutableListOf<point>(poin)
            var foundList = mutableListOf(poin)
            while (searchList.size > 0) {
                var p = searchList.first()

                searchList.removeFirst()
                if (input[p.x][p.y] != 8) {

                //iterate until area does not grow anymore
                if (p.x > 0 && input[p.x - 1][p.y] > input[p.x][p.y] && input[p.x - 1][p.y]!= 9) {
                    if (!containsPoint(foundList, point(p.x-1, p.y))) {
                        searchList.add(point(p.x-1, p.y))
                        foundList.add(point(p.x-1, p.y))
                        counter += 1
                    }
                }

                if (p.x < input.size - 1 && input[p.x + 1][p.y] > input[p.x][p.y] && input[p.x + 1][p.y] !=9) {
                    if (!containsPoint(foundList, point(p.x+1, p.y))) {
                        searchList.add(point(p.x + 1, p.y))
                        foundList.add(point(p.x + 1, p.y))
                        counter += 1
                    }
                }

                if (p.y > 0 && input[p.x][p.y - 1] > input[p.x][p.y] && input[p.x][p.y - 1] !=9) {
                    if (!containsPoint(foundList, point(p.x, p.y-1))) {
                        searchList.add(point(p.x, p.y - 1))
                        foundList.add(point(p.x, p.y - 1))
                        counter += 1
                    }
                }

                if (p.y < input.first().size - 1 && input[p.x][p.y + 1] > input[p.x][p.y] && input[p.x][p.y + 1] != 9 ) {
                    if (!containsPoint(foundList, point(p.x, p.y + 1))) {
                        searchList.add(point(p.x, p.y + 1))
                        foundList.add(point(p.x, p.y + 1))
                        counter += 1
                    }
                }
                }
            }
            areaSizes.add(counter)

        }

        return areaSizes.sorted().reversed().get(0) * areaSizes.sorted().reversed().get(1) * areaSizes.sorted().reversed().get(2)
    }

}

fun main() {
    val day = Day09()
    val inp = readIntArray("Day09")
    println(day.part1(inp))
    println(day.part2(inp))

}