package boj.sorting

private fun main() {
    val t = readLine()!!.toInt()

    loop@ for (k in 0 until t) {

        val n = readLine()!!.toInt()
        var arr = Array<String>(n) { "" }
        for (i in 0 until n) {
            arr[i] = readLine()!!
        }
        arr.sort()

        for (i in 1 until n) {
            if (arr[i - 1].length < arr[i].length) {
                if (arr[i - 1] == arr[i].substring(0, arr[i - 1].length)) {
                    println("NO")
                    continue@loop
                }
            }
        }
        println("YES")
    }
}