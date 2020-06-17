package baekjoon.bfs

import java.util.*

private lateinit var arr: Array<IntArray>
private lateinit var dis: Array<IntArray>

private val goX = intArrayOf(0, 0, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0)


private fun main() {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    arr = Array(n) { IntArray(m) }
    dis = Array(n) { IntArray(m) { -1 } }
    for (i in 0 until n) {
        readLine()!!.forEachIndexed { j, c ->
            arr[i][j] = c.toString().toInt()
        }
    }
    bfs(n,m)
    println(dis[n-1][m-1]+1)
}

private fun bfs(n: Int, m: Int) {
    var queue: Queue<Pair<Int, Int>> = LinkedList()
    dis[0][0] = 0
    queue.add(Pair(0, 0))
    while (queue.isNotEmpty()) {
        val curX = queue.peek().first
        val curY = queue.peek().second
        queue.remove()
        for (i in 0 until 4) {
            val x = curX + goX[i]
            val y = curY + goY[i]
            if (x >= 0 && x < n && y >= 0 && y < m && arr[x][y] == 1 && dis[x][y]<0) {
                dis[x][y] = dis[curX][curY]+1
                queue.add(Pair(x, y))

            }
        }
    }

}