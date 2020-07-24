package bruteforce

import java.util.*
import kotlin.math.min

private fun main() = with(Scanner(System.`in`)) {
    val a = next()
    val b = next()
    var answer = Int.MAX_VALUE
    for (i in 0 .. b.length - a.length) {
        var tmpAnswer = 0
        for (j in 0 until a.length) {
            if (a[j] != b[i+j]) tmpAnswer++
        }
        answer = min(answer, tmpAnswer)
    }
    println(answer)
}
