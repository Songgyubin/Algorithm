package binarysearch

import kotlin.math.max

//

private lateinit var arr: List<Int>
private var start = 0
private var end = 0
private fun main() {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    arr = readLine()!!.split(' ').map(String::toInt)

    start = arr.max()!!
    end = arr.sum()

    binarySearch(m)
}

private fun binarySearch(m: Int) {
    while (start <= end) {
        var mid = (start + end) / 2
        var sum = 0
        var count = 0
        for (i in arr.indices) {
            if (sum + arr[i] > mid) {
                sum = 0
                count++
            }
            sum += arr[i]
        }
        if (sum != 0) count++
        if (count <= m) end = mid - 1
        else start = mid + 1
    }
    println(start)
}