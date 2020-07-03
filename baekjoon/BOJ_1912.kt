package baekjoon.dp

import kotlin.math.max

private fun main() {

    val n = readLine()!!.toInt()
    var arr = IntArray(n)
    var dp = IntArray(n)

    readLine()!!.split(' ').map(String::toInt).forEachIndexed { index, i ->
        arr[index] = i
    }
    dp[0] = arr[0]
    var m = arr[0]

    for (i in 1 until n){
        dp[i] = max(dp[i-1]+arr[i],arr[i])
        m = max(m, dp[i])
    }
    println(m)
}