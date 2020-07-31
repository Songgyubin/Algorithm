package bfs

import java.util.*
import kotlin.math.min

private lateinit var arr: Array<IntArray>
private lateinit var vis: Array<IntArray>

private val goX = arrayOf(0, 0, -1, 1)
private val goY = arrayOf(1, -1, 0, 0)
private var answer = Int.MAX_VALUE
private fun main() {
    val n = readLine()!!.toInt()
    arr = Array(n) { IntArray(n) }
    vis = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    for (i in 0 until n) {
        readLine()!!.forEachIndexed { j, c ->
            arr[i][j] = c.toString().toInt()
        }
    }
    bfs(n)

    println(vis[n-1][n-1])
}

private fun bfs(n: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(0, 0))
    vis[0][0] = 0
    while (queue.isNotEmpty()) {
        val x = queue.peek().first
        val y = queue.peek().second
        queue.poll()
        for (i in 0 until 4) {
            val curX = x + goX[i]
            val curY = y + goY[i]
            if (curX >= 0 && curX < n && curY >= 0 && curY < n && vis[curX][curY] > vis[x][y]) {
                if (arr[curX][curY] == 0)
                    vis[curX][curY] = vis[x][y] + 1
                else
                    vis[curX][curY] = vis[x][y]
                queue.add(Pair(curX, curY))
            }
        }
    }

}

