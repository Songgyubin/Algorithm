package baekjoon.dp

private fun main(){
    val n  = readLine()!!.toInt()
    var dp = IntArray(10007){0}
    dp[0] = 1
    dp[1] = 1
    if (n ==0 || n==1) {
        println(1)
        return
    }else {
        for (i in 2..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
            dp[i] %= 10007
        }
        println(dp[n])
    }
}
