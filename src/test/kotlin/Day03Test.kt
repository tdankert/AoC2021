import org.junit.Test
import org.junit.Assert.assertEquals

class Day03Test {
    private val input =
        mutableListOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010")

    var d = Day03()

    @Test
    fun part1() {
        val expected = 198

        val actual = d.part1(input)

        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected  = 230

        val actual = d.part2(input)

        assertEquals(expected, actual)
    }
}