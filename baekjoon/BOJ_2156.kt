package baekjoon.dp

import kotlin.math.max

private fun main(){

    val n = readLine()!!.toInt()
    var dp = IntArray(n+1)
    var arr = IntArray(n+1)
    for (i in 1 .. n){
        arr[i] = readLine()!!.toInt()
    }

    if (n>=1) dp[1] = arr[1]
    if (n>=2) dp[2] = arr[1]+arr[2]
    if (n>=3) dp[3] = max(dp[2],max(arr[2]+arr[3],arr[1]+arr[3]))

    for (i in 4..n){
        dp[i] = max(dp[i-1],max((dp[i-2]+arr[i]),(arr[i-1]+dp[i-3]+arr[i])))
    }
    println(dp[n])
}