package boj.simulation

import kotlin.math.max
import kotlin.math.min

private lateinit var arr: IntArray

private fun main() {
    var answer = 0
    val (h, w) = readLine()!!.split(' ').map { it.toInt() }
    arr = IntArray(w)
    arr = readLine()!!.split(' ').map { it.toInt() }.toIntArray()

    for (i in 1 until w - 1) {
        var cur = arr[i]
        var (leftMax, rightMax) = intArrayOf(cur, cur)

        leftMax = max(leftMax, arr.take(i + 1).max()!!)
        rightMax = max(rightMax, arr.takeLast(w-i).max()!!)

        if (min(leftMax, rightMax) > cur) answer += (min(leftMax, rightMax) - arr[i])
    }

    println(answer)
}

