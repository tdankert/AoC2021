import org.junit.Test
import org.junit.Assert.assertEquals

class Day06Test {
    private val input =
        mutableListOf(3,4,3,1,2)

    var d = Day06()

    @Test
    fun part1() {
        val expected = 5934

        val actual = d.part1(input, 80)

        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected  = 26984457539

        val actual = d.part1(input, 256)

        assertEquals(expected, actual)
    }
}