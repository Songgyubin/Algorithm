package boj

import kotlin.math.max

private lateinit var arr: Array<CharArray>
private lateinit var alphaVis: BooleanArray

private val goX = intArrayOf(1, -1, 0, 0)
private val goY = intArrayOf(0, 0, 1, -1)

private var answer = 0

private fun main() {
    val (r, c) = readLine()!!.split(' ').map { it.toInt() }
    alphaVis = BooleanArray(26)
    arr = Array(r) { CharArray(c) }
    for (i in 0 until r) {
        arr[i] = readLine()!!.toCharArray()
    }
    dfs(r, c, 0, 0, 1)
    println(answer)
}

private fun dfs(r: Int, c: Int, x: Int, y: Int, count: Int) {
    alphaVis[arr[x][y] - 'A'] = true
    for (i in 0 until 4) {
        val (nextX, nextY) = intArrayOf(x + goX[i], y + goY[i])
        if (nextX < 0 || nextX >= r || nextY < 0 || nextY >= c) continue
        if (alphaVis[arr[nextX][nextY] - 'A']) continue
        dfs(r, c, nextX, nextY, count + 1)
        alphaVis[arr[nextX][nextY] - 'A'] = false
    }
    answer = max(answer, count)
}