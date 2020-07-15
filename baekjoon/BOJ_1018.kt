package baekjoon.bruteforce

import kotlin.math.min

private lateinit var arr: Array<CharArray>
// https://whereisusb.tistory.com/158
private fun main() {

    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    arr = Array(n) { CharArray(m) }
    for (i in 0 until n) {
        readLine()!!.forEachIndexed { j, c ->
            arr[i][j] = c
        }
    }
    var answer = Int.MAX_VALUE
    for (j in 0..(m - 8)) {
        for (i in 0..(n - 8)) {
            answer = min(answer, check(i, j))
        }
    }
    println(answer)
}

private fun check(startN: Int, startM: Int): Int {
    var answerB = 0
    var answerW = 0

    var tmpB = 'B'
    for (i in startN..startN + 7) {
        if (arr[i][startM] != tmpB) answerB++
        for (j in startM + 1..startM + 7) {
            if (arr[i][j] == tmpB) {
                answerB++
                tmpB = if (tmpB == 'B') 'W'
                else 'B'
            } else tmpB = arr[i][j]
        }
    }
    var tmpW = 'W'
    for (i in startN..startN + 7) {
        if (arr[i][startM] != tmpW) answerW++
        for (j in startM + 1..startM + 7) {
            if (arr[i][j] == tmpW) {
                answerW++
                tmpW = if (tmpW == 'B') 'W'
                else 'B'
            } else tmpW = arr[i][j]
        }
    }


    return min(answerB, answerW)
}