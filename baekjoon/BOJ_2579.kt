package baekjoon.dp

import kotlin.math.max

private fun main(){
    val n = readLine()!!.toInt()
    val arr = IntArray(n+1)
    val dp = IntArray(n+1)
    for (i in 1 .. n){
        arr[i] = readLine()!!.toInt()
    }


    when (n) {
        1 -> {
            println(arr[1])
        }
        2 -> {
            println(arr[2]+arr[1])
        }
        3 -> {
            max(arr[1]+arr[3],arr[2]+arr[3])
        }
        else -> {
            dp[1] = arr[1]
            dp[2] = arr[2]+arr[1]
            dp[3] = max(arr[1]+arr[3],arr[2]+arr[3])
            for (i in 4..n) {
                dp[i] = max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i])
            }
            println(dp[n])
        }
    }
}