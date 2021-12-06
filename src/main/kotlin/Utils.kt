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