package boj.bfs

import java.util.*


private val goX = intArrayOf(1, -1, 0, 0)
private val goY = intArrayOf(0, 0, 1, -1)

private lateinit var arr: Array<IntArray>
private lateinit var vis: Array<BooleanArray>

private fun main() {
    repeat(readLine()!!.toInt()) {
        val (m, n, k) = readLine()!!.split(' ').map { it.toInt() }
        arr = Array(n) { IntArray(m) }
        vis = Array(n) { BooleanArray(m) }

        for (i in 0 until k) {
            val (x, y) = readLine()!!.split(' ').map { it.toInt() }
            arr[y][x] = 1
        }
        println(bfs(n, m))
    }
}

private fun bfs(n: Int, m: Int): Int {
    var answer = 0
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (vis[i][j]) continue
            if (arr[i][j] != 1) continue
            vis[i][j] = true
            queue.add(Pair(i, j))
            answer++
            while (queue.isNotEmpty()) {
                val (curX, curY) = queue.poll()
                for (k in 0 until 4) {
                    val (nX, nY) = intArrayOf(curX + goX[k], curY + goY[k])
                    if (nX < 0 || nX >= n || nY < 0 || nY >= m) continue
                    if (vis[nX][nY]) continue
                    if (arr[nX][nY] != 1) continue
                    vis[nX][nY] = true
                    queue.add(Pair(nX, nY))
                }
            }
        }
    }
    return answer
}