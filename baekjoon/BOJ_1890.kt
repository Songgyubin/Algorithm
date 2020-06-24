package baekjoon.study.dp2

private lateinit var arr: Array<IntArray>
private fun main() {
    val n = readLine()!!.toInt()
    arr = Array(n) { IntArray(n) }

    var dp = Array(n) { LongArray(n) }

    for (i in 0 until n) {
        readLine()!!.split(' ').forEachIndexed { j, c ->
            arr[i][j] = c.toInt()
        }
    }
    dp[0][0] = 1
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i == n - 1 && j == n - 1) break

            var next = arr[i][j]
            if (i + next < n) {
                dp[i + next][j] += dp[i][j]
            }
            if (j + next < n) {
                dp[i][j + next] += dp[i][j]
            }
        }
    }
    println(dp[n - 1][n - 1])
}

