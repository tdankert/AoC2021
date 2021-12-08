import java.awt.Point
import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("data", "$name.txt").readLines().toMutableList()

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