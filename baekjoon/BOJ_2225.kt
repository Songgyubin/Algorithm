package dp

private lateinit var dp: Array<IntArray>
private fun main() {
    dp = Array(201) { IntArray(201) }
    val (n, k) = readLine()!!.split(' ').map(String::toInt)

    dp[0][0] = 1
    for (i in 1..k) {
        for (j in 0..n) {
            for (k in 0..j) {
                dp[i][j] += dp[i - 1][j - k]
                dp[i][j] %= 1000000000
            }
        }
    }
    println(dp[k][n])


}