package baekjoon.study.dp1
//https://beginthread.tistory.com/145

private fun main() {
    val n = readLine()!!.toInt()
    var dp = IntArray(31) { 0 }
    dp[0] = 1
    dp[1] = 1

    for (i in 2..n) {
        dp[i] += dp[i - 1]
        dp[i] += dp[i - 2] * 2
    }
    if (n % 2 != 0) println((dp[n] + dp[n / 2]) / 2)
    else println((dp[n] + dp[n / 2] + 2 * dp[n / 2 - 1]) / 2)
}
