package simulation

import kotlin.math.abs

private val goX = intArrayOf(0, -1, 0, 1)
private val goY = intArrayOf(1, 0, -1, 0)

private lateinit var arr: Array<IntArray>

private var r1 = 0
private var r2 = 0
private var c1 = 0
private var c2 = 0
private var max = 0

private fun main() {
    val s = readLine()!!.split(' ').map(String::toInt)
    r1 = s[0]
    c1 = s[1]
    r2 = s[2]
    c2 = s[3]

    arr = Array(r2 - r1 + 1) { IntArray(c2 - c1 + 1) }
    fill()

    val space = len(max) // 공백
    for (i in 0..abs(r1 - r2)) {
        for (j in 0..abs(c1 - c2)) {
            val currentSpace = len(arr[i][j])
            for (k in 0 until space - currentSpace) print(" ")
            print("${arr[i][j]} ")
        }
        println()
    }


}

private fun len(value: Int): Int {
    var result = 0
    var tmp = value
    while (tmp >= 10) {
        result++
        tmp /= 10
    }
    return result
}

private fun fill() {
    var x = 0
    var y = 0
    var dir = 0
    var num = 1
    var dnum = 1
    var cnt = 0
    while (!isFinish()) {
        if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
            arr[x - r1][y - c1] = num
        }
        num++
        cnt++
        x = x + goX[dir]
        y = y + goY[dir]
        if (cnt == dnum) {
            cnt = 0
            if (dir == 1 || dir == 3) dnum++ // 위 아래 마다 개수가 늘어나므로
            dir = (dir + 1) % 4
        }
    }
    max = num
}

private fun isFinish(): Boolean =
    arr[0][0] != 0 && arr[r2 - r1][0] != 0 && arr[0][c2 - c1] != 0 && arr[r2 - r1][c2 - c1] != 0
// 사각형 형식으로 출력 되므로 각 꼭짓점만 확인