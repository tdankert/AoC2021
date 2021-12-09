import org.junit.Test
import org.junit.Assert.assertEquals

class Day09Test {
    val input = readIntArray("Day09test")

    var d = Day09()

    @Test
    fun part1() {
        val expected = 15

        val actual = d.part1(input)

        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected  = 1134

        val actual = d.part2(input)

        assertEquals(expected, actual)
    }
}