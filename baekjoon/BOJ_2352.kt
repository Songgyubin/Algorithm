package boj.lcs

import kotlin.math.max

private lateinit var arr: IntArray
private lateinit var dp: IntArray
private fun main() {

    val n = readLine()!!.toInt()
    arr = IntArray(n)
    dp = IntArray(n) { 1 }
    arr = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    var tmp = 0
    for (i in arr.indices) {
        val num = arr[i]
        for (j in 0 until i) {
            if (num > arr[j]) dp[i] = max(dp[i], dp[j] + 1)
        }
        tmp = max(tmp, dp[i])
    }
    println(tmp)

}