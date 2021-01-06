package boj

import kotlin.math.max

private fun main() {
    val s = "0${readLine()!!}"
    val ss = "0${readLine()!!}"
    val dp = Array<IntArray>(1001) { IntArray(1001) }

    for (i in 1 until ss.length) {
        val tmp = ss[i]
        for (j in 1 until s.length) {
            if (tmp == s[j]) dp[i][j] = dp[i - 1][j - 1] + 1
            else dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
        }
    }
    var answer = 0
    dp.forEach { answer = max(answer, it.maxOrNull()!!) }
    println(answer)
}