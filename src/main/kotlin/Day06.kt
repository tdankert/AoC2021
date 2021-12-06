import java.math.BigInteger

class Day06 {

    fun part1(input: MutableList<Int>): Int {
        val list = input
        val days = 80
        for (i in 1..days) {
            val tempList = mutableListOf<Int>()

            for (entry in input) {
                if (entry  == 0 ) {
                    // Add new one with 8 and reset this one to 6
                    tempList.add(8)
                    tempList.add(6)
                } else {
                    tempList.add(entry - 1)
                }
            }
            list.clear()
            list.addAll(tempList)
        }
        return list.size
    }

    fun part2(input: MutableList<Int>): BigInteger {
        var fishes = mutableListOf<BigInteger>()
        fun countFish(): BigInteger {
            var count = BigInteger.ZERO
            for (x in fishes)
            {
                count += x
            }
            return count
        }
        val days = 256
        var list = input

        for (i in 0..8)
            fishes.add(BigInteger.ZERO)

        // Init
        for (entry in input) {
            fishes[entry] = fishes[entry] + BigInteger.ONE
        }

        for (d in 1..days){
            val zeroFish = fishes[0]

            fishes[0] = BigInteger.ZERO
            for (e in 0..7) {
                fishes[e] = fishes[e + 1]
            }

            fishes[6] = fishes[6] + zeroFish
            fishes[8] = zeroFish

        }
        return countFish()
    }
}

fun main() {
    val day = Day06()
    var input = readIntInputOneLine("Day06")
    day.part1(input)
    input = readIntInputOneLine("Day06")
    day.part2(input)

}