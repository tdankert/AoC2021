import org.junit.Test
import org.junit.Assert.assertEquals

class Day01_Test {
    private val input = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)

    var d = Day01()

    @Test
    fun part1() {
        val expected = 7

        var actual = d.part1(input)

        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected  = 5

        var actual = d.part2(input)

        assertEquals(expected, actual)
    }
}