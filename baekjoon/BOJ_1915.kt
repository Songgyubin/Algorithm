package dp

import kotlin.math.max
import kotlin.math.min

private val goX = intArrayOf(-1, 0, -1) // 위 왼 대각선
private val goY = intArrayOf(0, -1, -1)

private lateinit var arr: Array<IntArray>
private fun main() {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    arr = Array<IntArray>(n) { IntArray(m) }
    for (i in 0 until n) {
        readLine()!!.forEachIndexed { j, c ->
            arr[i][j] = c.toString().toInt()
        }
    }
    square(n, m)
    var maxScore = 0
    arr.forEach {
        maxScore = max(maxScore, it.max()!!)
    }
    println(maxScore * maxScore)
}

private fun square(n: Int, m: Int) {
// copy?
    for (i in 0 until n) {
        for (j in 0 until m) {
//            var isSquare = true
            var count = 0
            var tmpScore = Int.MAX_VALUE
            if (arr[i][j] != 0) {
                for (k in 0 until 3) {
                    val curX = i + goX[k]
                    val curY = j + goY[k]
                    if (curX >= 0 && curX < n && curY >= 0 && curY < m) {

                        if (arr[curX][curY] == 0) break
                        if (arr[curX][curY] != 0) {
                            count++
                            tmpScore = min(tmpScore, arr[curX][curY])
                        }
                    }
                }
                if (count == 3) {
                    arr[i][j] = tmpScore + 1
                }

            }
        }
    }
}