package dp

import kotlin.math.max

private fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(' ').map(String::toInt)
    var dpR = IntArray(n) { 1 }
    var dpL = IntArray(n) { 1 }

    for (i in arr.indices) {
        for (j in 0 until i) {
            if (arr[i] > arr[j]) {
                if (dpR[i] < dpR[j] + 1) {
                    dpR[i] = dpR[j] + 1
                }
            }
        }
    }
    for (i in arr.lastIndex downTo 0) {
        for (j in arr.lastIndex downTo i) {
            if (arr[i] > arr[j]) {
                if (dpL[i] < dpL[j] + 1) {
                    dpL[i] = dpL[j] + 1
                }
            }
        }
    }
    var answer = 0
    dpR.forEachIndexed { index, i ->
        answer = max(answer, i + dpL[index])
    }
    println(answer - 1)


}
