package dfs

import kotlin.math.max

private val goX = intArrayOf(0, 0, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0)

private lateinit var arr: Array<CharArray>
private lateinit var visAlpha: BooleanArray
private var r = 0
private var c = 0
private var answer = 1
private var count = 1
private fun main() {
    val s = readLine()!!.split(' ').map(String::toInt)
    r = s[0]
    c = s[1]
    arr = Array(r) { CharArray(c) }
    visAlpha = BooleanArray('Z'.toInt() - 'A'.toInt() + 1)
    for (i in 0 until r) {
        readLine()!!.forEachIndexed { j, c ->
            arr[i][j] = c
        }
    }
    dfs(0, 0)
    println(answer)
}

private fun dfs(x: Int, y: Int) {
    visAlpha[arr[x][y].toInt()-'A'.toInt()] = true

    for (i in 0 until 4) {
        val curX = x + goX[i]
        val curY = y + goY[i]
        if (curX >= 0 && curX < r && curY >= 0 && curY < c) {
            if (!visAlpha[arr[curX][curY].toInt()-'A'.toInt()]) {
                count++
                answer = max(count, answer)
                dfs(curX, curY)
            }
        }
    }
    count--
    visAlpha[arr[x][y].toInt()-'A'.toInt()] = false
}


