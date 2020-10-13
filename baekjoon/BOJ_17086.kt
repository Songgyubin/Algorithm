package boj.bfs

import java.util.*
import kotlin.math.max

private val goX = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
private val goY = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

private lateinit var arr: Array<IntArray>
private lateinit var vis: Array<BooleanArray>
private var answer = Int.MIN_VALUE

private fun main() {

    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    arr = Array(n) { IntArray(m) }
    vis = Array(n) { BooleanArray(m) }

    for (i in 0 until n) {
        arr[i] = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    }

    findSafeArea(n, m)
    println(answer)

}

private fun findSafeArea(n: Int, m: Int) {

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j] == 1) continue
            vis = Array(n) { BooleanArray(m) }
            val queue: Queue<Node> = LinkedList()
            queue.add(Node(i, j, 0))
            vis[i][j] = true
            while (queue.isNotEmpty()) {
                val (x, y, dist) = queue.poll()
                for (k in 0 until 8) {
                    val (curX, curY, curDist) = intArrayOf(x + goX[k], y + goY[k], dist + 1)
                    if (curX < 0 || curX >= n || curY < 0 || curY >= m || vis[curX][curY]) continue
                    if (arr[curX][curY] == 1) {
                        answer = max(answer, curDist)
                        queue.clear()
                        break
                    }
                    if (arr[curX][curY] == 0) {
                        vis[curX][curY] = true
                        queue.add(Node(curX, curY, curDist))
                    }
                }
            }
        }
    }
}

data class Node(val x: Int, val y: Int, val dist: Int)