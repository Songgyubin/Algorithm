package baekjoon.bruteforce

import kotlin.math.max

private fun main(){

    val n = readLine()!!.toInt()

    var day = IntArray(n+2)
    var pay = IntArray(n+2)

    var dp = IntArray(n+2)

    for (i in 1 .. n){
        val s = readLine()!!.split(' ')
        day[i] = s[0].toInt()
        pay[i] = s[1].toInt()
    }
    dp[0] =0

    for (i in n downTo 1){
        if (i+day[i]<=n+1) {
            dp[i] = max(pay[i]+dp[i+day[i]],dp[i+1])
        }
        else{
            dp[i] = dp[i+1]
        }
    }
    println(dp[1])
}