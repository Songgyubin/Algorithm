package dp

private lateinit var dp: Array<LongArray>
private fun main() {

    val n = readLine()!!.toInt()
    dp = Array(65) { LongArray(10) { 0 } }
    //dp[n][i]

    dp[1] = LongArray(10) { 1 }

    for (i in 0 until n) {
        val t = readLine()!!.toInt()
        if (t == 1) {
            println(10)
            continue
        }
        println(sumNum(t))
    }
}

private fun sumNum(t: Int): Long {
    var answer = 0L
    for (i in 2..t) {
        dp[i][9] = 1
        for (j in 8 downTo 0) {
            dp[i][j] = dp[i - 1][j] + dp[i][j + 1]
        }
    }
    answer = dp[t].sum()
    return answer
}