import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

// Different Colors for output
const val ANSI_RESET = "\u001B[0m"
const val ANSI_BLACK = "\u001B[30m"
const val ANSI_RED = "\u001B[31m"
const val ANSI_GREEN = "\u001B[32m"
const val ANSI_YELLOW = "\u001B[33m"
const val ANSI_BLUE = "\u001B[34m"
const val ANSI_PURPLE = "\u001B[35m"
const val ANSI_CYAN = "\u001B[36m"
const val ANSI_WHITE = "\u001B[37m"

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("data", "$name.txt").readLines().toMutableList()

fun readIntArray(name: String): Array<IntArray> {

    val input = File("data", "$name.txt").readLines()

    var value = Array(input.size) { IntArray(input.first().length) }

    for (line in input.indices) {
        for (character in  input[line].indices) {
            value[line][character] = input[line][character].digitToInt()
        }
    }

    return value
}

fun readIntInput(name: String) = File("data", "$name.txt").readLines().map(String::toInt)

fun readIntInputOneLine(name: String) =
    File("data", "$name.txt").readLines().first().split(',').map(String::toInt).toMutableList()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

fun String.alphabetized() = String(toCharArray().apply { sort() })

class point(x: Int, y: Int) {
    var x = 0
    var y = 0


    fun equals(point: point): Boolean {
        if (this.x == point.x && this.y == point.y) {
            return true
        }
        return false
    }

    fun stepTo(point: point): List<point>{
        var result = mutableListOf<point>()
        if (this.x == point.x) {
            if (this.y < point.y) {
                // step upward
                for (dy in this.y..point.y) {
                    result.add(point(x, dy))
                }
            } else {
                // step downward
                for (dy in this.y downTo point.y) {
                    result.add(point(x, dy))
                }
            }
        } else if (this.y == point.y){
            if (this.x < point.x) {
                // step upward
                for (dx in this.x..point.x) {
                    result.add(point(dx, y))
                }
            } else {
                // step downward
                for (dx in this.x downTo point.x) {
                    result.add(point(dx, y))
                }
            }
        }


        return result
    }
}