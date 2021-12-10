import org.junit.Test
import org.junit.Assert.assertEquals
import java.math.BigInteger

class Day10Test {
    val input = readInput("Day10test")

    var d = Day10()

    @Test
    fun part1() {
        val expected = 16397

        val actual = d.part1(input)

        assertEquals(expected, actual)
    }

    @Test
    fun part2() {
        val expected  = BigInteger.valueOf(288957)

        val actual = d.part2(input)

        assertEquals(expected, actual)
    }
}