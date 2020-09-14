package dp

import kotlin.system.exitProcess

private fun main() {
    val n = readLine()!!.toInt()
    if (n == 1 || n == 2) {
        println(1)
        exitProcess(0)
    }
    val dp = LongArray(n + 1)
    dp[1] = 1
    dp[2] = 1
    for (i in 3..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    println(dp[n])
}