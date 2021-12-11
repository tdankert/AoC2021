import org.junit.Test
import org.junit.Assert.assertEquals

class Day11Test {
    val input = readIntArray("Day11test")

    var d = Day11()

    @Test
    fun part1() {
        val expected = 1656

        val actual = d.part1(input)

        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected  = 0

        val actual = d.part2(input)

        assertEquals(expected, actual)
    }
}