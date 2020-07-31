package dp

import kotlin.math.max
import kotlin.math.min

private fun main() {
    val n = readLine()!!.toInt()
    val arr = Array(n) { readLine()!!.split(' ').map(String::toInt).toIntArray() }
    val maxDp = Array(n) { IntArray(3) { 0 } }
    val minDp = Array(n) { IntArray(3) { 0 } }
    for (i in 0..2) {
        maxDp[0][i] = arr[0][i]
        minDp[0][i] = arr[0][i]
    }
    for (i in 1 until n) {
        maxDp[i][0] = max(maxDp[i - 1][0], maxDp[i - 1][1]) + arr[i][0]
        minDp[i][0] = min(minDp[i - 1][0], minDp[i - 1][1]) + arr[i][0]
        maxDp[i][1] = max(maxDp[i - 1][0], max(maxDp[i - 1][1], maxDp[i - 1][2])) + arr[i][1]
        minDp[i][1] = min(minDp[i - 1][0], min(minDp[i - 1][1], minDp[i - 1][2])) + arr[i][1]
        maxDp[i][2] = max(maxDp[i - 1][1], maxDp[i - 1][2]) + arr[i][2]
        minDp[i][2] = min(minDp[i - 1][1], minDp[i - 1][2]) + arr[i][2]
    }
    println("${maxDp[n - 1].max()} ${minDp[n - 1].min()}")
}
