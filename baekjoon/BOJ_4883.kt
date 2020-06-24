package baekjoon.study.dp2

import java.lang.Integer.min

private fun main() {

    var test = 1

    while (true) {
        val n = readLine()!!.toInt()
        if (n == 0)
            break
        var arr = Array(n) { IntArray(3) }
        for (i in 0 until n) {
            readLine()!!.split(' ').map(String::toInt).forEachIndexed { j, value ->
                arr[i][j] = value
            }
        }

        arr[0][2] += arr[0][1] // 오
        arr[1][0] += arr[0][1] // 왼 오

        arr[1][1] += min(min(arr[1][0], arr[0][2]), arr[0][1])
        arr[1][2] += min(min(arr[0][2], arr[1][1]), arr[0][1])

        for (i in 2 until n) {
            for (j in 0 until 3) {
                if (j == 0) // 0열 일때
                    arr[i][j] += min(arr[i - 1][j], arr[i - 1][j + 1])
                else if (j == 1)
                    arr[i][j] += min(min(arr[i - 1][j], arr[i - 1][j + 1]), min(arr[i - 1][j - 1], arr[i][j - 1]))
                else if (j == 2)
                    arr[i][j] += min(min(arr[i - 1][j - 1], arr[i - 1][j]), arr[i][j - 1])
            }
        }
        println("$test. ${arr[n - 1][1]}")
        test++
    }
}

