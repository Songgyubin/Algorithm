package binarysearch

private lateinit var arr: List<Int>

private fun main() {
    val n = readLine()!!.toInt()
    arr = readLine()!!.split(' ').map(String::toInt).sorted()

    val m = readLine()!!.toInt()

    readLine()!!.split(' ').map(String::toInt).forEach {
        if (binarySearch(it)==-1) println(0)
        else println(1)
    }
}

private fun binarySearch(target: Int): Int {
    var start = 0
    var end = arr.lastIndex
    while (start <= end) {
        var mid = (start + end) / 2
        if (arr[mid] < target)
            start = mid + 1
        else if (arr[mid] > target)
            end = mid - 1
        else
            return mid
    }
    return -1

}