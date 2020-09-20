package bfs

import java.util.*

private val goX = intArrayOf(-1, 1, 0, 0)
private val goY = intArrayOf(0, 0, -1, 1)

private lateinit var arr: Array<CharArray>
private lateinit var dis: Array<IntArray>

private var startX = -1
private var startY = -1

private var endX = -1
private var endY = -1


private fun main() {

    val (w, h) = readLine()!!.split(' ').map(String::toInt)
    arr = Array(h) { CharArray(w) }
    dis = Array(h) { IntArray(w) { -1 } }
    for (i in 0 until h) {
        readLine()!!.forEachIndexed { j, c ->
            arr[i][j] = c
            if (c == 'C') {
                if (startX == -1) {
                    startX = i
                    startY = j
                } else {
                    endX = i
                    endY = j
                }
            }
        }
    }
    bfs(h, w)
    println(dis[endX][endY] - 1)
}

private fun bfs(h: Int, w: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(startX, startY))
    dis[startX][startY] = 0

    while (queue.isNotEmpty()) {

        val (x, y) = queue.poll()
        for (i in 0 until 4) {
            var curX = x + goX[i]
            var curY = y + goY[i]
            while (curX in 0 until h && curY in 0 until w) {
                if (arr[curX][curY] == '*') break
                if (dis[curX][curY] == -1) {
                    dis[curX][curY] = dis[x][y] + 1
                    queue.add(Pair(curX, curY))
                }
                curX += goX[i]
                curY += goY[i]
            }
        }
    }

}