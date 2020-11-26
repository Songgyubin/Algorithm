package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
//https://mygumi.tistory.com/276
private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()!!.toInt()
    val dp = IntArray(n + 1)
    val st = StringTokenizer(br.readLine())
    for (i in 1..n) {
        val num = st.nextToken().toInt()
        dp[num] = dp[num - 1] + 1
    }
    dp.sort()
    println(n - dp[n])
}
