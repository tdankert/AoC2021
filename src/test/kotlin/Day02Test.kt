import org.junit.Test
import org.junit.Assert.assertEquals

class Day02Test {
    private val input = listOf("forward 5",
            "down 5",
            "forward 8",
            "up 3",
            "down 8",
            "forward 2")

    var d = Day02()

    @Test
    fun part1() {
        val expected = 150

        val actual = d.part1(input)

        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected  = 900

        val actual = d.part2(input)

        assertEquals(expected, actual)
    }
}