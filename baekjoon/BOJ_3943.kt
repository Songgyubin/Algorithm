package baekjoon.dp

import java.lang.Integer.max

private fun main() {

    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        var n = readLine()!!.toInt()
        var maximum = n

            while (n != 1) {
                if (n % 2 == 0) {
                    n /= 2
                    maximum = max(maximum, n)
                } else {
                    n = (n * 3) + 1
                    maximum = max(maximum, n)
                }
            }
            println(maximum)

    }
}