package boj.greedy

import kotlin.system.exitProcess

private fun main() {

    val n = readLine()!!.toInt()
    val k = readLine()!!.toInt()
    if (k >= n) {
        println(0)
        exitProcess(0)
    }
    val arr = readLine()!!.split(' ').map { it.toInt() }.distinct().sorted().toIntArray()
    val tmpArr = IntArray(arr.size - 1)
    for (i in tmpArr.indices) {
        tmpArr[i] = arr[i + 1] - arr[i]
    }
    println(tmpArr.sorted().subList(0,tmpArr.size-k+1).sum())

}

