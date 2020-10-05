package bfs

import java.util.*


private val goX = intArrayOf(0, 0, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0)

private lateinit var arr: Array<Array<Char>>
private lateinit var fDist: Array<Array<Int>>
private lateinit var jDist: Array<Array<Int>>
private lateinit var queueFire: Queue<Pair<Int, Int>>
private lateinit var queueJihoon: Queue<Pair<Int, Int>>

private fun main() {
    val (r, c) = readLine()!!.split(' ').map(String::toInt)
    arr = Array(r) { Array(c) { ' ' } }
    fDist = Array(r) { Array(c) { -1 } }
    jDist = Array(r) { Array(c) { -1 } }
    queueFire = LinkedList()
    queueJihoon = LinkedList()

    for (i in 0 until r) {
        readLine()!!.forEachIndexed { j, value ->
            arr[i][j] = value
            if (value == 'F') {
                queueFire.add(Pair(i, j))
                fDist[i][j] = 0
            }
            if (value == 'J') {
                queueJihoon.add(Pair(i, j))
                jDist[i][j] = 0
            }
        }
    }
    bfs(r, c)
}

private fun bfs(r: Int, c: Int) {

    while (queueFire.isNotEmpty()) {
        val (fx, fy) = queueFire.poll()
        for (i in 0 until 4) {
            val curX = fx + goX[i]
            val curY = fy + goY[i]
            if (curX < 0 || curX >= r || curY < 0 || curY >= c) continue
            if (fDist[curX][curY] >= 0 || arr[curX][curY] == '#') continue
            fDist[curX][curY] = fDist[fx][fy] + 1
            queueFire.add(Pair(curX, curY))
        }
    }
    while (queueJihoon.isNotEmpty()) {
        val (jx,jy) = queueJihoon.poll()
        for (i in goX.indices) {
            val curX = jx + goX[i]
            val curY = jy + goY[i]
            if (curX < 0 || curX >= r || curY < 0 || curY >= c) {
                println(jDist[jx][jy] + 1)
                return
            }
            if (jDist[curX][curY] >= 0 || arr[curX][curY] == '#') continue

            if (fDist[curX][curY] ==-1 || jDist[jx][jy]+1 < fDist[curX][curY]) {
                jDist[curX][curY] = jDist[jx][jy] + 1
                queueJihoon.add(Pair(curX, curY))
            }
        }
    }
    println("IMPOSSIBLE")
}