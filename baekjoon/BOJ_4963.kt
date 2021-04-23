package boj

import java.util.*

private val goX = intArrayOf(0, 0, 1, -1, 1, -1, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0, -1, -1, 1, 1)

private lateinit var arr: Array<IntArray>
private lateinit var vis: Array<BooleanArray>

private fun main() {
    while (true) {
        val (w, h) = readLine()!!.split(" ").map { it.toInt() }
        if (w == 0 && h == 0) break

        arr = Array(h) { IntArray(w) }
        vis = Array(h) { BooleanArray(w) }
        for (i in 0 until h) {
            arr[i] = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
        }
        println(bfs(w, h))
    }
}

private fun bfs(w: Int, h: Int): Int {
    var land = 0
    for (i in 0 until h) {
        for (j in 0 until w) {
            if (vis[i][j]) continue
            if (arr[i][j] == 0) continue
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            queue.add(Pair(i, j))
            vis[i][j] = true
            land += 1
            while (queue.isNotEmpty()) {
                val (x, y) = queue.poll()
                for (k in 0 until 8) {
                    val (nx, ny) = intArrayOf(x + goX[k], y + goY[k])
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue
                    if (vis[nx][ny]) continue
                    if (arr[nx][ny] == 0) continue
                    vis[nx][ny] = true
                    queue.add(Pair(nx, ny))
                }
            }
        }
    }
    return land
}
